package com.example.ankitsingh.ankit_androidproject.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ankitsingh.ankit_androidproject.R;
import com.example.ankitsingh.ankit_androidproject.adapter.MyListAdapter;

import java.util.ArrayList;

/**
 * Created by shailendrapundhir on 09/12/17.
 */

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        setList();
    }

    private void setList() {
        ArrayList<String> data = new ArrayList<>();

        for(int i=0;i<100;i++){
            data.add(i,"Item "+i);
        }
        MyListAdapter adapter = new MyListAdapter(this,data);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }


}
