package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class foodmenu extends AppCompatActivity {

    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    private Button btn;
    public String v1,v2,v3,v4,v5,v6,v7,v8,v9,seatbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_foodmenu);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t8=(TextView)findViewById(R.id.t8);
        t9=(TextView)findViewById(R.id.t9);


        btn=(Button)findViewById(R.id.btn);



        seatbook=getIntent().getStringExtra("val1");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1=t1.getText().toString();
                v2=t2.getText().toString();
                v3=t3.getText().toString();
                v4=t4.getText().toString();
                v5=t5.getText().toString();
                v6=t6.getText().toString();
                v7=t7.getText().toString();
                v8=t8.getText().toString();
                v9=t9.getText().toString();

                Intent intent = new Intent(foodmenu.this,cart.class);

                intent.putExtra("v1",v1);
                intent.putExtra("v2",v2);
                intent.putExtra("v3",v3);
                intent.putExtra("v4",v4);
                intent.putExtra("v5",v5);
                intent.putExtra("v6",v6);
                intent.putExtra("v7",v7);
                intent.putExtra("v8",v8);
                intent.putExtra("v9",v9);
                intent.putExtra("seatbook",seatbook);


                startActivity(intent);
            }
        });
    }
}