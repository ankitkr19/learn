package com.example.ankitsingh.ankit_androidproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ankitsingh.ankit_androidproject.ImageAsyncTask;
import com.example.ankitsingh.ankit_androidproject.NetworkCallbackInterface;
import com.example.ankitsingh.ankit_androidproject.R;

public class Image extends AppCompatActivity implements NetworkCallbackInterface {
    TextView textTargetUri;
    ImageView targetImage;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Button buttonLoadImage = (Button) findViewById(R.id.loadimage);
        textTargetUri = (TextView) findViewById(R.id.targeturi);
        targetImage = (ImageView) findViewById(R.id.targetimage);


        buttonLoadImage.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                ImageAsyncTask photos = new ImageAsyncTask(Image.this,Image.this);
                photos.execute();
//                Picasso.with(Image.this).load("https://tpc.googlesyndication.com/simgad/10464256763402806218").into(targetImage);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            //textTargetUri.setText(targetUri.toString());
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                targetImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDownloadComplete(Bitmap bmp) {
        targetImage.setImageBitmap(bmp);
    }
}
