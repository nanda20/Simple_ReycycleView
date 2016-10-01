package com.example.owner.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Intent2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);
        Button btn = (Button) findViewById(R.id.btn5);
        TextView text1= (TextView)findViewById(R.id.txtNama);

        Intent intent= getIntent();
        String nama= intent.getStringExtra("nama");
        text1.setText(nama);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainIntent.class);
                startActivity(i);
            }
        });

    }
}
