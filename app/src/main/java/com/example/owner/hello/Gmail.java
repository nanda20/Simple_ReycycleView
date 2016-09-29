package com.example.owner.hello;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Gmail extends AppCompatActivity {
    public RecyclerView myRecyclerView;
    public RecyclerView.LayoutManager mLayoutManager;
    public RecyclerView.Adapter mAdapter;
    List<MyEmail> myEmails= new ArrayList<>();
    private MyEmail email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail);
        myRecyclerView =(RecyclerView) findViewById(R.id.gmailList);
        mLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(mLayoutManager);

        email = new MyEmail("Anndi Brown","Being You parent ","lorem dolor","jan-25","#1abc9c");
        myEmails.add(email);
        email = new MyEmail("Budi Budiman","Nice to meet you","lorem dolor","jan-25","#8e44ad");
        myEmails.add(email);
        email = new MyEmail("Cahya Dwi","makan-makan","lorem dolor","jan-25","#e67e22");
        myEmails.add(email);
        email = new MyEmail("Muklis","makan-makan","lorem dolor","jan-25","#3498db");
        myEmails.add(email);
        email = new MyEmail("Yoline","makan-makan","lorem dolor","jan-25","#f39c12");
        myEmails.add(email);
        email = new MyEmail("Sutria","makan-makan","lorem dolor","jan-25","#95a5a6");
        myEmails.add(email);
        email = new MyEmail("Mikal","makan-makan","lorem dolor","jan-25","#3498db");
        myEmails.add(email);
        email = new MyEmail("George","makan-makan","lorem dolor","jan-25","#f1c40f");
        myEmails.add(email);



        mAdapter = new GmailAdapter(myEmails);
        myRecyclerView.setAdapter(mAdapter);
    }

    public class MyEmail{
        public  String pengirim;
        public String subject;
        public String ringkasan;
        public String date;
        public String color;

        public MyEmail(String pengirim, String subject, String ringkasan, String date,String color) {
            this.pengirim = pengirim;
            this.subject = subject;
            this.ringkasan = ringkasan;
            this.date = date;
            this.color= color;

        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getPengirim() {
            return pengirim;
        }

        public void setPengirim(String pengirim) {
            this.pengirim = pengirim;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getRingkasan() {
            return ringkasan;
        }

        public void setRingkasan(String ringkasan) {
            this.ringkasan = ringkasan;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }


    public class GmailAdapter extends RecyclerView.Adapter<GmailAdapter.ViewHolder> {
        List<MyEmail> myEmails;

        public GmailAdapter(List<MyEmail> myEmails) {
            this.myEmails= myEmails;
        }

        @Override
        public GmailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.gmail_list_template,parent,false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(GmailAdapter.ViewHolder holder, int position) {
            MyEmail gmail= myEmails.get(position);
            holder.pengirim.setText(gmail.getPengirim());
            holder.ringkasan.setText(gmail.getRingkasan());
            holder.subject.setText(gmail.getSubject());
            holder.date.setText(gmail.getDate());
            String s= gmail.getPengirim().substring(0,1);
            holder.btn.setBackgroundColor(Color.parseColor(gmail.getColor()));

            holder.btn.setText(s);

        }

        @Override
        public int getItemCount() {
            return myEmails.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            public TextView pengirim,subject,ringkasan, date;
            public Button btn;
            public ViewHolder(View itemView) {
                super(itemView);
                btn= (Button) itemView.findViewById(R.id.button_round);
                pengirim= (TextView)itemView.findViewById(R.id.pengirim);
                subject= (TextView)itemView.findViewById(R.id.subject);
                ringkasan= (TextView)itemView.findViewById(R.id.ringkasan);
                date = (TextView)itemView.findViewById(R.id.date);

            }
        }
    }



}
