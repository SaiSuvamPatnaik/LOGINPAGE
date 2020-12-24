package com.example.loginpage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;





public class payment extends AppCompatActivity {

    TextView amt;
    EditText id,name,note;
    Button btn,nxt;
    final int upi=0;
    String d1;
    int data1;
    String status,paymentCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        amt=findViewById(R.id.amt);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        note=findViewById(R.id.note);
        btn=findViewById(R.id.btn);
        nxt=findViewById(R.id.nxt);

        d1=getIntent().getStringExtra("p1");
        if(d1.isEmpty()){
            amt.setText("0");
        }
        else {
            data1 = Integer.parseInt(getIntent().getStringExtra("p1"));

            amt.setText(String.valueOf(data1));

        }

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opennn();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Amount=amt.getText().toString();
                String UpiId=id.getText().toString();
                String Name=name.getText().toString();
                String Note=note.getText().toString();
                payUsingUpi(Amount,UpiId,Name,Note);
            }
        });
    }

    void payUsingUpi(String Amount,String UpiId,String Name,String Note){
        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa",UpiId)
                .appendQueryParameter("pn",Name)
                .appendQueryParameter("tn",Note)
                .appendQueryParameter("am",Amount)
                .appendQueryParameter("cu","INR")
                .build();

        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);

        Intent chooser=Intent.createChooser(upiPayIntent,"Pay With");

        if (null!=chooser.resolveActivity(getPackageManager())){
            startActivityForResult(chooser,upi);

        }
        else {
            Toast.makeText(payment.this,"No App Found",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case upi:
                if ((RESULT_OK==requestCode)||(resultCode==11)){
                    if (data!=null){
                        String trxt = data.getStringExtra("response");
                        Log.d("UPI","onActivityResult: "+trxt);
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add(trxt);
                        upipaymentdataoperation(dataList);
                    }
                    else {
                        Log.d("UPI","onActivityResult: "+"Return Data is Null");
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("nothing");
                        upipaymentdataoperation(dataList);
                    }

                }
                else {
                    Log.d("UPI","onActivityResult: "+"Return Data is Null");
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upipaymentdataoperation(dataList);
                }
                break;
        }
    }








    private void upipaymentdataoperation(ArrayList<String> data){
        String str = data.get(0);
        Log.d("UPI PAY","upipaymentdataoperation; "+str);
        paymentCancel = " ";
        if (str==null) str = "discard";
        status = " ";
        String approvalRefNo = " ";
        String response[]=str.split("&");
        for (int i=0;i<response.length;i++){
            String equalStr[]=response[i].split("=");
            if(equalStr.length>=2){
                if (equalStr[0].toLowerCase().equals("Status".toLowerCase())){
                    status = equalStr[1].toLowerCase();
                }
                else if (equalStr[0].toLowerCase().equals("Approval Ref No".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())){
                    approvalRefNo=equalStr[1];
                }

            }
            else {
                paymentCancel="Payment Cancelled By User";
            }

        }
        if (status.equals("success")){
            Toast.makeText(payment.this,"Transaction Successful",Toast.LENGTH_LONG).show();
            Log.d("UPI","responseStr: "+approvalRefNo);
        }
        else if ("Payment Cancelled By User".equals(paymentCancel)){
            Toast.makeText(payment.this,"Payment Cancelled By User",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(payment.this,"Failed Transaction",Toast.LENGTH_SHORT).show();
        }
    }

    public void opennn() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        int datas=Integer.parseInt(amt.getText().toString());
        myRef.child("Paid").setValue(String.valueOf(datas));
        Intent intent = new Intent(payment.this,qrcode.class);
        startActivity(intent);


    }



}