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
    int orderno=0;
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


        int food1=Integer.parseInt(out1.getText().toString());
        food1=food1/50;
        String data1=String.valueOf(food1);
        String Chilli_Burger = data1;

        int food2=Integer.parseInt(out2.getText().toString());
        food2=food2/80;
        String data2=String.valueOf(food2);
        String Grilled_Sandwich = data2;

        int food3=Integer.parseInt(out3.getText().toString());
        food3=food3/100;
        String data3=String.valueOf(food3);
        String Caesar_Salad = data3;

        int food4=Integer.parseInt(out4.getText().toString());
        food4=food4/200;
        String data4=String.valueOf(food4);
        String Paneer_Makhni = data4;

        int food5=Integer.parseInt(out5.getText().toString());
        food5=food5/180;
        String data5=String.valueOf(food5);
        String Mix_Vegetable = data5;

        int food6=Integer.parseInt(out6.getText().toString());
        food6=food6/40;
        String data6=String.valueOf(food6);
        String Butter_Nan = data6;

        int food7=Integer.parseInt(out7.getText().toString());
        food7=food7/80;
        String data7=String.valueOf(food7);
        String Jeera_Rice = data7;

        int food8=Integer.parseInt(out8.getText().toString());
        food8=food8/150;
        String data8=String.valueOf(food8);
        String Rasgulla = data8;

        int food10=Integer.parseInt(out10.getText().toString());
        String data10=String.valueOf(food10);
        String Total_Cost = data10;


        String data11=out11.getText().toString();
        String Table_Booked = data11;





        dataholder obj = new dataholder(Chilli_Burger,Grilled_Sandwich,Caesar_Salad,Paneer_Makhni,
                            Mix_Vegetable,Butter_Nan,Jeera_Rice,Rasgulla,Total_Cost,Table_Booked);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Orders: ");
        String id = myRef.push().getKey();
        myRef.child("Order id = "+id).setValue(obj);


        Intent intent = new Intent(this,payment.class);
        intent.putExtra("p1",p1);
        startActivity(intent);


    }
}















