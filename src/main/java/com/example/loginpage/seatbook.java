package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class seatbook extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    String val1;
    int check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.seatbook);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        check=0;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check>0){
                    Toast.makeText(seatbook.this, "Table Already Booked", Toast.LENGTH_SHORT).show();
                }
                if(check==0){
                    val1="Table-1";
                    check=1;
                    Toast.makeText(seatbook.this, "Table-1 Booked", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check>0){
                    Toast.makeText(seatbook.this, "Table Already Booked", Toast.LENGTH_SHORT).show();
                }
                if(check==0){
                    val1="Table-2";
                    check=1;
                    Toast.makeText(seatbook.this, "Table-2 Booked", Toast.LENGTH_LONG).show();
                }

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check>0){
                    Toast.makeText(seatbook.this, "Table Already Booked", Toast.LENGTH_SHORT).show();
                }
                if(check==0){
                    val1="Table-3";
                    check=1;
                    Toast.makeText(seatbook.this, "Table-3 Booked", Toast.LENGTH_LONG).show();
                }


            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check>0){
                    Toast.makeText(seatbook.this, "Table Already Booked", Toast.LENGTH_SHORT).show();
                }
                if(check==0){
                    val1="Table-4";
                    check=1;
                    Toast.makeText(seatbook.this, "Table-4 Booked", Toast.LENGTH_LONG).show();
                }

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check>0){
                    Toast.makeText(seatbook.this, "Table Already Booked", Toast.LENGTH_SHORT).show();
                }
                if(check==0){
                    val1="Table-5";
                    check=1;
                    Toast.makeText(seatbook.this, "Table-5 Booked", Toast.LENGTH_LONG).show();
                }


            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check>0){
                    Toast.makeText(seatbook.this, "Table Already Booked", Toast.LENGTH_SHORT).show();
                }
                if(check==0){
                    val1="Table-6";
                    check=1;
                    Toast.makeText(seatbook.this, "Table-6 Booked", Toast.LENGTH_LONG).show();
                }


            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check>0){
                    Toast.makeText(seatbook.this, "Table Already Booked", Toast.LENGTH_SHORT).show();
                }
                if (check==0){
                    val1="Table-7";
                    check=1;
                    Toast.makeText(seatbook.this, "Table-7 Booked", Toast.LENGTH_LONG).show();
                }



            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check>0){
                    Toast.makeText(seatbook.this, "Table Already Booked", Toast.LENGTH_SHORT).show();
                }
                if (check==0){
                    val1="Table-8";
                    check=1;
                    Toast.makeText(seatbook.this, "Table-8 Booked", Toast.LENGTH_LONG).show();
                }



            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check=0;
                Intent intent = new Intent(seatbook.this, foodmenu.class);
                intent.putExtra("val1",val1);
                startActivity(intent);
            }
        });



    }
}