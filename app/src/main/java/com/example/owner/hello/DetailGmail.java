package com.example.owner.hello;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailGmail extends AppCompatActivity {
    private TextView pengirim,subject,ringkasan,date;
    private ImageView star;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gmail);

        star = (ImageView) findViewById(R.id.star1);
        btn= (Button) findViewById(R.id.button_round1);
        pengirim= (TextView)findViewById(R.id.pengirim1);
        subject= (TextView)findViewById(R.id.subject1);
        ringkasan= (TextView)findViewById(R.id.ringkasan1);
        date = (TextView)findViewById(R.id.date1);

        Intent i= getIntent();

         pengirim.setText(i.getStringExtra("pengirim"));
        ringkasan.setText(i.getStringExtra("ringkasan"));
        subject.setText(i.getStringExtra("subject"));

        btn.setBackgroundColor(Color.parseColor(i.getStringExtra("color")));
        String s= i.getStringExtra("pengirim").substring(0,1);
        btn.setText(s);

        if( i.getExtras().getBoolean("star") == true) {
            star.setImageResource(android.R.drawable.btn_star_big_on);
        }else{

            star.setImageResource(android.R.drawable.btn_star_big_off);
        }
        date.setText(i.getStringExtra("date"));

    }
}
