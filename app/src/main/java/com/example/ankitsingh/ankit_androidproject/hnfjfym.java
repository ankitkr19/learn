package com.example.ankitsingh.ankit_androidproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;

/**
 * Created by shailendrapundhir on 05/12/17.
 */

public class hnfjfym extends AsyncTask<Void,Void,Void> {
    Context context;
    NetworkCallbackInterface iface;
    Bitmap bmp;
    public hnfjfym(Context context,NetworkCallbackInterface nci){
        this.context = context;
        this.iface = nci;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        iface.onDownloadComplete(bmp);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://tpc.googlesyndication.com/simgad/10464256763402806218");

            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
