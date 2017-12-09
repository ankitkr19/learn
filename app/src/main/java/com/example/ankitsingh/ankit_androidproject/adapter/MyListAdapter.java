package com.example.ankitsingh.ankit_androidproject.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ankitsingh.ankit_androidproject.R;
import com.example.ankitsingh.ankit_androidproject.activities.Image;
import com.example.ankitsingh.ankit_androidproject.activities.MainActivity;
import com.example.ankitsingh.ankit_androidproject.views.ListItemViewHolder;

import java.util.ArrayList;

/**
 * Created by shailendrapundhir on 09/12/17.
 */

public class MyListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private Context context;
    private ArrayList<String> data;

    public MyListAdapter(Context context,ArrayList<String> list) {
        this.context = context;
        this.data  = list;
    }


    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        ListItemViewHolder holder = new ListItemViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.text.setText(data.get(position));
        final String text = data.get(position);
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog(text);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    protected void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setTitle("Saio Nara");
        builder.setIcon(R.drawable.ic_delete_black_24dp);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

           /* builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            })*/

        builder.show();
    }
}
