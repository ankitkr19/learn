package com.example.ankitsingh.ankit_androidproject.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ankitsingh.ankit_androidproject.R;

import org.w3c.dom.Text;

/**
 * Created by shailendrapundhir on 09/12/17.
 */

public class ListItemViewHolder extends RecyclerView.ViewHolder{
    public TextView text;

    public ListItemViewHolder(View itemView) {
        super(itemView);
        text = (TextView)itemView.findViewById(R.id.text);
    }
}
