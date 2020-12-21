package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.loginpage.R.*;

public class Home_Page extends AppCompatActivity {

    ImageView backbtn;
    Button btn,btn1,btn2,btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(layout.activity_home__page);

        BottomNavigationView bottomNavigationView = findViewById(id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(id.nav_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case id.nav_home:
                        return true;
                    case id.nav_help:
                        startActivity(new Intent(getApplicationContext(),help.class));
                        overridePendingTransition(0,0);
                        return true;
                    case id.nav_about:
                        startActivity(new Intent(getApplicationContext(),Aboutus.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


       //hiding bottom bar
        hideNavigationbar();




        // for going back12
        backbtn = findViewById(id.back_pressed);
        btn = findViewById(id.btn);
        btn1 = findViewById(id.btn1);
        btn2 = findViewById(id.btn2);
        btn3 = findViewById(id.btn3);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openn();

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threesixty();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threesixty1();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threesixty2();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threesixty3();
            }
        });

    }

    private void hideNavigationbar()
    {
        this.getWindow().getDecorView().setSystemUiVisibility(

        View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );


    }



    public void threesixty(){
        Intent intent = new Intent(this,seat.class);
        startActivity(intent);
    }
    public void threesixty1(){
        Intent intent = new Intent(this,seat1.class);
        startActivity(intent);
    }
    public void threesixty2(){
        Intent intent = new Intent(this,seat2.class);
        startActivity(intent);
    }
    public void threesixty3(){
        Intent intent = new Intent(this,seat3.class);
        startActivity(intent);
    }
    public void openn(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}