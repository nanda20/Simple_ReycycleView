package com.example.owner.hello;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owner.hello.adapter.RecyclerItemClickListener;

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

        email = new MyEmail("Anndi Brown","Being You parent ","lorem dolor","jan-25","#1abc9c",true);
        myEmails.add(email);
        email = new MyEmail("Budi Budiman","Nice to meet you","lorem dolor","jan-25","#8e44ad",true);
        myEmails.add(email);
        email = new MyEmail("Cahya Dwi","makan-makan","lorem dolor","jan-25","#e67e22",true);
        myEmails.add(email);
        email = new MyEmail("Muklis","makan-makan","lorem dolor","jan-25","#3498db",false);
        myEmails.add(email);
        email = new MyEmail("Yoline","makan-makan","lorem dolor","jan-25","#f39c12",true);
        myEmails.add(email);
        email = new MyEmail("Sutria","makan-makan","lorem dolor","jan-25","#95a5a6",false);
        myEmails.add(email);
        email = new MyEmail("Mikal","makan-makan","lorem dolor","jan-25","#3498db",false);
        myEmails.add(email);
        email = new MyEmail("George","makan-makan","lorem dolor","jan-25","#f1c40f",true);
        myEmails.add(email);

        mAdapter = new GmailAdapter(myEmails,getApplicationContext());

        myRecyclerView.setAdapter(mAdapter);
        Context contex=getApplicationContext();


    }


    public static class MyEmail{
        public  String pengirim;
        public String subject;
        public String ringkasan;
        public String date;
        public String color;
        public boolean star;

        public MyEmail(String pengirim, String subject, String ringkasan, String date,String color,boolean star) {
            this.pengirim = pengirim;
            this.subject = subject;
            this.ringkasan = ringkasan;
            this.date = date;
            this.color= color;
            this.star= star;

        }

        public boolean getStar() {
            return star;
        }

        public void setStar(boolean star) {
            this.star = star;
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
        Context context;

        public GmailAdapter(List<MyEmail> myEmails,Context context) {
            this.myEmails= myEmails;
            this.context= context;
        }

        @Override
        public GmailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.gmail_list_template,parent,false);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    int pos = myRecyclerView.getChildAdapterPosition(v);
                    if (pos >= 0 && pos < getItemCount()) {
                            Intent intent= new Intent(context,DetailGmail.class);
                            intent.putExtra("pengirim",myEmails.get(pos).getPengirim());
                            intent.putExtra("ringkasan",myEmails.get(pos).getRingkasan());
                            intent.putExtra("subject",myEmails.get(pos).getSubject());
                            intent.putExtra("color",myEmails.get(pos).getColor());
                            intent.putExtra("date",myEmails.get(pos).getDate());
                            intent.putExtra("star",myEmails.get(pos).getStar());

                            startActivity(intent);
                    }
                }
            });
            return new ViewHolder(itemView,context,myEmails);
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

            if(gmail.getStar() == true) {
                holder.star.setImageResource(android.R.drawable.btn_star_big_on);
            }else{

                holder.star.setImageResource(android.R.drawable.btn_star_big_off);
            }


        }

        @Override
        public int getItemCount() {
            return myEmails.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public TextView pengirim,subject,ringkasan, date;
            public Button btn;
            public ImageView star;

            Context context;
            final List<MyEmail> myEmails;

            public ViewHolder(View itemView, Context context, final List<MyEmail> myEmails) {
                super(itemView);
                this.context=context;
                this.myEmails=myEmails;
                star = (ImageView) itemView.findViewById(R.id.star);
                btn= (Button) itemView.findViewById(R.id.button_round);
                pengirim= (TextView)itemView.findViewById(R.id.pengirim);
                subject= (TextView)itemView.findViewById(R.id.subject);
                ringkasan= (TextView)itemView.findViewById(R.id.ringkasan);
                date = (TextView)itemView.findViewById(R.id.date);

//                itemView.setOnClickListener(new View.OnClickListener(){
//
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(Gmail.this, myEmails.get(getAdapterPosition()).getDate(), Toast.LENGTH_SHORT).show();
//                    }
//                });


            }

            @Override
            public void onClick(View v) {
                int posisi = getAdapterPosition();
                MyEmail myEmail=this.myEmails.get(posisi);
                Intent intent= new Intent(context,DetailGmail.class);;
                startActivity(intent);

            }
        }
    }



}
