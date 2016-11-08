package com.indooratlas.android.sdk.indoornavigation.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

import com.indooratlas.android.sdk.indoornavigation.R;

public class GraphicsManager {
    public static Paint linePaint, endpointPaint,startpointPaint, vacantPaint,occupiedPaint,unmonitoredPaint;
    private static final float  borderRadius = 25.0f;
    public static Animation fadeIn,fadeOut;
    public static float XRATIO,YRATIO;

    public static void initializeGraphics(Context myContext) {
        DisplayMetrics metrics = myContext.getResources().getDisplayMetrics();
        BitmapFactory.Options dimensions = new BitmapFactory.Options();
        dimensions.inJustDecodeBounds = true;

        linePaint = new Paint();
        CornerPathEffect cornerPathEffect = new CornerPathEffect(borderRadius);
        //Initialize line Style
        linePaint.setColor(Color.parseColor("#2b81cd"));
        linePaint.setStrokeWidth(3);
        linePaint.setPathEffect(cornerPathEffect);
        linePaint.setStyle(Paint.Style.STROKE);


        endpointPaint = new Paint();
        endpointPaint.setColor(Color.RED);
        endpointPaint.setStrokeWidth(5);
        //endpointPaint.setPathEffect(cornerPathEffect);
        endpointPaint.setStyle(Paint.Style.FILL);


        startpointPaint = new Paint();
        startpointPaint.setColor(Color.GREEN);
        startpointPaint.setStrokeWidth(5);
        //startpointPaint.setPathEffect(cornerPathEffect);
        startpointPaint.setStyle(Paint.Style.FILL);

        vacantPaint = new Paint();
        vacantPaint.setColor(Color.parseColor("#2ecc71"));
        vacantPaint.setStyle(Paint.Style.FILL);

        occupiedPaint = new Paint();
        occupiedPaint.setColor(Color.parseColor("#e74c3c"));
        occupiedPaint.setStyle(Paint.Style.FILL);

        unmonitoredPaint = new Paint();
        unmonitoredPaint.setColor(Color.parseColor("#2c3e50"));
        unmonitoredPaint.setStyle(Paint.Style.FILL);


        fadeIn = new AlphaAnimation(1, 0.7f);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(1000);
        fadeIn.setRepeatCount(Animation.INFINITE);
        fadeOut = new AlphaAnimation(0.7f, 1);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1000);

    }
}
