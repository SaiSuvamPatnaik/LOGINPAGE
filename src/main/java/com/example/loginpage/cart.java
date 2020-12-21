package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class cart extends AppCompatActivity {

    String d1,d2,d3,d4,d5,d6,d7,d8,d9;
    int data1,data2,data3,data4,data5,data6,data7,data8,sum;
    int pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8;
    TextView out1,out2,out3,out4,out5,out6,out7,out8,out9,out10,out11;
    private Button button;
    public String p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_cart);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openqrcode();
            }
        });

        out1=(TextView)findViewById(R.id.out1);
        d1=getIntent().getStringExtra("v1");
        if(d1.isEmpty()){
            pr1=0;
            out1.setText(String.valueOf(pr1));
        }
        else {
            data1 = Integer.parseInt(getIntent().getStringExtra("v1"));
            pr1 = data1 * 50;
            out1.setText(String.valueOf(pr1));

        }


        out2=(TextView)findViewById(R.id.out2);
        d2=getIntent().getStringExtra("v2");
        if(d2.isEmpty()){
            pr2=0;
            out2.setText(String.valueOf(pr2));
        }
        else{
            data2=Integer.parseInt(getIntent().getStringExtra("v2"));
            pr2=data2*80;
            out2.setText(String.valueOf(pr2));
        }


        out3=(TextView)findViewById(R.id.out3);
        d3=getIntent().getStringExtra("v3");
        if(d3.isEmpty()){
            pr3=0;
            out3.setText(String.valueOf(pr3));
        }
        else {
            data3 = Integer.parseInt(getIntent().getStringExtra("v3"));
            pr3 = data3 * 100;
            out3.setText(String.valueOf(pr3));
        }


        out4=(TextView)findViewById(R.id.out4);
        d4=getIntent().getStringExtra("v4");
        if(d4.isEmpty()) {
            pr4=0;
            out4.setText(String.valueOf(pr4));

        }
        else {
            data4 = Integer.parseInt(getIntent().getStringExtra("v4"));
            pr4 = data4 * 200;
            out4.setText(String.valueOf(pr4));
        }

        out5=(TextView)findViewById(R.id.out5);
        d5=getIntent().getStringExtra("v5");
        if(d5.isEmpty()){
            pr5=0;
            out5.setText(String.valueOf(pr5));
        }
        else {
            data5 = Integer.parseInt(getIntent().getStringExtra("v5"));
            pr5 = data5 * 180;
            out5.setText(String.valueOf(pr5));
        }



        out6=(TextView)findViewById(R.id.out6);
        d6=getIntent().getStringExtra("v6");
        if(d6.isEmpty()){
            pr6=0;
            out6.setText(String.valueOf(pr6));
        }
        else {
            data6 = Integer.parseInt(getIntent().getStringExtra("v6"));
            pr6 = data6 * 40;
            out6.setText(String.valueOf(pr6));
        }


        out7=(TextView)findViewById(R.id.out7);
        d7=getIntent().getStringExtra("v7");
        if(d7.isEmpty()){
            pr7=0;
            out7.setText(String.valueOf(pr7));
        }
        else {
            data7 = Integer.parseInt(getIntent().getStringExtra("v7"));
            pr7 = data7 * 80;
            out7.setText(String.valueOf(pr7));
        }


        out8=(TextView)findViewById(R.id.out8);
        d8=getIntent().getStringExtra("v8");
        if(d8.isEmpty()){
            pr8=0;
            out8.setText(String.valueOf(pr8));
        }
        else {
            data8 = Integer.parseInt(getIntent().getStringExtra("v8"));
            pr8 = data8 * 150;
            out8.setText(String.valueOf(pr8));
        }


        sum=pr1+pr2+pr3+pr4+pr5+pr6+pr7+pr8;


        out10=findViewById(R.id.out10);
        out10.setText(String.valueOf(sum));
        p1 = out10.getText().toString();
        out11=findViewById(R.id.out11);
        out11.setText(getIntent().getStringExtra("seatbook"));

    }

    public void openqrcode(){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        int data1=Integer.parseInt(out1.getText().toString());
        data1=data1/50;
        myRef.child("Chilli Burger").setValue(String.valueOf(data1));
        int data2=Integer.parseInt(out2.getText().toString());
        data2=data2/80;
        myRef.child("Grilled Sandwich").setValue(String.valueOf(data2));
        int data3=Integer.parseInt(out3.getText().toString());
        data3=data3/100;
        myRef.child("Caesar Salad").setValue(String.valueOf(data3));
        int data4=Integer.parseInt(out4.getText().toString());
        data4=data4/200;
        myRef.child("Paneer Makhni").setValue(String.valueOf(data4));
        int data5=Integer.parseInt(out5.getText().toString());
        data5=data5/180;
        myRef.child("Mix Vegetable").setValue(String.valueOf(data5));
        int data6=Integer.parseInt(out6.getText().toString());
        data6=data6/40;
        myRef.child("Butter Naan").setValue(String.valueOf(data6));
        int data7=Integer.parseInt(out7.getText().toString());
        data7=data7/80;
        myRef.child("Jeera Rice").setValue(String.valueOf(data7));
        int data8=Integer.parseInt(out8.getText().toString());
        data8=data8/150;
        myRef.child("Rasgulla").setValue(String.valueOf(data8));
        int data10=Integer.parseInt(out10.getText().toString());
        myRef.child("Total Cost ").setValue(String.valueOf(data10));
        String data11=out11.getText().toString();
        myRef.child("Table Booked ").setValue(data11);





        Intent intent = new Intent(this,payment.class);
        intent.putExtra("p1",p1);
        startActivity(intent);


    }
}