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
    public static int DEVICE_WIDTH,DEVICE_HEIGHT;
    public static final int XOFFSET=27,YOFFSET=24;
    public static Bitmap firstFloor;
    public static Bitmap secondFloor;
    public static float XRATIO,YRATIO;
    public static Bitmap arrowhead,arrowhead2,exit;
    public static Bitmap parkHere;
          //  DEVICE_WIDTH,DEVICE_HEIGHT,BITMAP_HEIGHT=513,BITMAP_WIDTH=959;



    public static void initalizeGraphics(Context myContext) {
        DisplayMetrics metrics = myContext.getResources().getDisplayMetrics();
        BitmapFactory.Options dimensions = new BitmapFactory.Options();
        dimensions.inJustDecodeBounds = true;
        Log.d("WTF",metrics.widthPixels + " " + metrics.heightPixels );
        Log.d("Metrics",XRATIO + " " + YRATIO);
        arrowhead = BitmapFactory.decodeResource(myContext.getResources(), R.drawable.arrowhead);
        arrowhead2 = BitmapFactory.decodeResource(myContext.getResources(), R.drawable.arrowhead2);
        parkHere = BitmapFactory.decodeResource(myContext.getResources(),R.drawable.finish);
        exit = BitmapFactory.decodeResource(myContext.getResources(),R.drawable.stairs);
        float height = dimensions.outHeight;
        float width =  dimensions.outWidth;
        DEVICE_WIDTH = metrics.widthPixels;
        DEVICE_HEIGHT = metrics.heightPixels;
        if(DEVICE_WIDTH>DEVICE_HEIGHT)
        {
            int temp = DEVICE_WIDTH;
            DEVICE_WIDTH = DEVICE_HEIGHT;
            DEVICE_HEIGHT = temp;
        }
        if(DEVICE_WIDTH ==1440) {
            //JULES - Galaxy S6
            XRATIO = 2.675f;//metrics.widthPixels / width;
            YRATIO = 2.8f;//metrics.heightPixels / height;
            parkHere=    getResizedBitmap(parkHere,125,73);
            arrowhead=    getResizedBitmap(arrowhead,108,84);


        }
        else if(DEVICE_WIDTH==720)
        {
            //Galaxy Note 2
            XRATIO = 1.335f;//metrics.widthPixels / height;
            YRATIO = 1.41f;//metrics.heightPixels / width;

        }
        else if(DEVICE_WIDTH == 720 && DEVICE_HEIGHT==1184)
        {
            XRATIO= 1.330f;
            YRATIO=1.41f;
        }
        else if(DEVICE_WIDTH==768)
        {
            //Alcatel
            XRATIO = 1.25f;//metrics.widthPixels / height;
            YRATIO = 1.51f;//metrics.heightPixels / width;
        }
        else if(DEVICE_WIDTH==1080)
        {
            Log.d("Size","Zenphone");
            //ASUS ZENPHONE
            XRATIO = 1.5f;//metrics.widthPixels / height;
            YRATIO = 1.5f;//metrics.heightPixels / width;
            exit = getResizedBitmap(exit,75,75);
            parkHere=    getResizedBitmap(parkHere,102,84);
            arrowhead=    getResizedBitmap(arrowhead,108,84);

        }
        else if(DEVICE_WIDTH==1280)
        {
            Log.d("Size","Blue Stacks");
            //BLUESTACKS
            XRATIO = 1.335f;//metrics.widthPixels / height;
            YRATIO = 1.41f;//metrics.heightPixels / width;
        }
        else if(DEVICE_WIDTH==480)
        {
            //Samsung Galaxy Mini
            XRATIO = 0.835f;//metrics.widthPixels / height;
            YRATIO = 0.941f;//metrics.heightPixels / width;
          //  parkHere=    getResizedBitmap(parkHere,51,33);
        }
        else if(DEVICE_WIDTH==540 && DEVICE_HEIGHT==960)
        {
            //Galaxy Alpha Mini
            XRATIO = 1.000f;
            YRATIO= 1.065f;
            parkHere = getResizedBitmap(parkHere,51,33);
        }
        else
        {
            //Galaxy Alpha Mini
            XRATIO = 1.000f;
            YRATIO= 1.000f;
        }


    Log.d("Metrics",XRATIO + " " + YRATIO);



        linePaint = new Paint();
        CornerPathEffect cornerPathEffect =
                new CornerPathEffect(borderRadius);
        //Initialize line Style
        linePaint.setColor(Color.parseColor("#2b81cd"));
        linePaint.setStrokeWidth(15);
        linePaint.setPathEffect(cornerPathEffect);
        linePaint.setStyle(Paint.Style.STROKE);


        endpointPaint = new Paint();
        endpointPaint.setColor(Color.RED);
        endpointPaint.setStrokeWidth(5);
        endpointPaint.setPathEffect(cornerPathEffect);
        endpointPaint.setStyle(Paint.Style.FILL);


        startpointPaint = new Paint();
        startpointPaint.setColor(Color.GREEN);
        startpointPaint.setStrokeWidth(5);
        startpointPaint.setPathEffect(cornerPathEffect);
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


    private static  Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth)
    {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }

}
