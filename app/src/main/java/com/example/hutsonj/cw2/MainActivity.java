package com.example.hutsonj.cw2;

import android.graphics.Color;
import android.support.annotation.ColorLong;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    int LClicks = 0, RClicks = 0;
    public void myFunction(View v){

       if (v.getId() == R.id.b1){
           LClicks += 1;
           if(LClicks % 2 == 1) {
               v.setBackgroundResource(R.drawable.gatomon);
               if(LClicks % 2 == 1 && RClicks % 2 == 1){
                   Toast.makeText(getApplicationContext(), "Same Image", Toast.LENGTH_SHORT).show();
               }
           } else {
               v.setBackgroundColor(Color.BLUE);
           }
       } else {
           RClicks += 1;
           if (RClicks % 2 == 1) {
               v.setBackgroundResource(R.drawable.gatomon);
               if (RClicks % 2 == 1 && LClicks % 2 == 1){
                   Toast.makeText(getApplicationContext(), "Same Image", Toast.LENGTH_SHORT).show();
               }
           } else {
               v.setBackgroundColor(Color.RED);
           }
       }


    }
}
