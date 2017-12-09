package com.example.ankitsingh.ankit_androidproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;

/**
 * Created by shailendrapundhir on 05/12/17.
 */

public class ImageAsyncTask extends AsyncTask<Void,Void,Void> {
    Context context;
    NetworkCallbackInterface iface;
    Bitmap bmp;
    ProgressDialog progressDialog;

    public ImageAsyncTask(Context context, NetworkCallbackInterface nci){
        this.context = context;
        this.iface = nci;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(progressDialog==null){
            progressDialog = new ProgressDialog(context);
        }

        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        iface.onDownloadComplete(bmp);
        if(progressDialog!=null){
            progressDialog.dismiss();
        }
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://i.ebayimg.com/images/i/301981299242-0-1/s-l1000.jpg");

            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
