package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    private static int SPLASH_SCREEN = 6000;

    Animation topAnim,bottomAnim,leftanim;
    ImageView logo;
    TextView welcome,rest,intel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        //ANIMATION
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        leftanim=AnimationUtils.loadAnimation(this,R.anim.left_anim);

        logo=findViewById(R.id.imageView);
        welcome=findViewById(R.id.textView6);
        rest=findViewById(R.id.textView7);
        intel=findViewById(R.id.textView8);

        logo.setAnimation(leftanim);
        welcome.setAnimation(topAnim);
        rest.setAnimation(bottomAnim);
        intel.setAnimation(bottomAnim);

        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(welcome.this,MainActivity.class);
                startActivity(intent);
                finish();

            }

        },SPLASH_SCREEN);


    }

}