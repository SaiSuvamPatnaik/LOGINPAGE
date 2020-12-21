package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import co.gofynd.gravityview.GravityView;

public class seat1 extends AppCompatActivity {
    GravityView gravityView;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_seat);
        ImageView img = findViewById(R.id.img);
        gravityView = GravityView.getInstance(this);
        boolean is_supported = gravityView.deviceSupported();
        if(is_supported) {
            gravityView
                    .setImage(img,R.drawable.pan4)
                    .center();
        }
        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(seat1.this, seatbook.class);
                startActivity(intent);
                finish();

            }

        },15000);
    }
    @Override
    protected void onResume() {
        super.onResume();
        gravityView.registerListener();
    }
    @Override
    protected void onStop() {
        super.onStop();
        gravityView.unRegisterListener();
    }

}