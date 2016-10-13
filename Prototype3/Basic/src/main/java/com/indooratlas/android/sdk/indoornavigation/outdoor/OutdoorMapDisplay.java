package com.indooratlas.android.sdk.indoornavigation.outdoor;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.indooratlas.android.sdk.indoornavigation.R;

public class OutdoorMapDisplay extends View {

    public int w=560;
    public int h=240;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    Context context;
    private Paint mPaint;
    private static final float TOLERANCE = 5;
    public int mapX;
    public int mapY;
    Paint p = new Paint();
    BitmapFactory.Options options = new BitmapFactory.Options();
    Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.wholedlsu, options);
    int imageHeight = options.outHeight;
    int imageWidth = options.outWidth;
    Rect dest;

    public OutdoorMapDisplay(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(4f);
    }

  /*  protected void createBitmap() {
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
        mCanvas = new Canvas(mBitmap);

    }*/

    // override onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //b = BitmapFactory.decodeResource(context.getResources(), R.drawable.wholedlsu, options);
        Log.d("height", "" + imageHeight);
        Log.d("width", "" + imageWidth);

        //TODO continue here
        //dest = new Rect(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(b, null, dest, p);
        canvas.drawColor(Color.DKGRAY);
        //p.setColor(Color.RED);
        //p.setStyle(Paint.Style.FILL);
        //canvas.drawCircle(w / 2, h / 2, 3, p);
    }



}