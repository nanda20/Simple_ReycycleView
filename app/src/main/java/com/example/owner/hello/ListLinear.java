package com.example.owner.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.security.PublicKey;

public class ListLinear extends AppCompatActivity {
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView.Adapter adapter;
    private String []mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_linear);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.ListBuah);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);

        mData= new String[]{"nanasa","apel","duren","pisang","mangga"};
        MyAdapter myAdapter= new MyAdapter(mData);

        recyclerView.setAdapter(myAdapter);

    }
}
