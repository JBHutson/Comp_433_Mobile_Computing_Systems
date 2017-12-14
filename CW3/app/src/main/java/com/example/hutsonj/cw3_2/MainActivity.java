package com.example.hutsonj.cw3_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Random r = new Random();
    int low = 1;
    int high = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void foo(View v){
        final PlotView vv = (PlotView) findViewById(R.id.myPlotView);
        float point = low + r.nextInt(high);
        vv.addPoint(point);
        vv.invalidate();
    }
}
