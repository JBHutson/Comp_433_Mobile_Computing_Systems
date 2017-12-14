package com.example.hutsonj.cw3_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by hutsonj on 12/6/2017.
 */

public class PlotView extends View {

    protected ArrayList<Float> points = new ArrayList<Float>(10);
    protected Paint paintPlot = new Paint();
    protected int pointNum = 0;

    public PlotView(Context context) {
        super(context);
    }

    public PlotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PlotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void clearList(){
        points.clear();
    }

    protected void addPoint(float newPoint){
        if(pointNum != 10) {
            points.add(newPoint);
            pointNum++;
        } else {
            points.remove(0);
            points.add(newPoint);
        }
    }


    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        paintPlot.setColor(Color.BLACK);
        paintPlot.setStrokeWidth(30);

        for(int i = 0; i < pointNum; i++){
            canvas.drawPoint(((getWidth()/10)*i), ((getHeight()/100)*points.get(i)), paintPlot);
        }
        invalidate();

    }
}
