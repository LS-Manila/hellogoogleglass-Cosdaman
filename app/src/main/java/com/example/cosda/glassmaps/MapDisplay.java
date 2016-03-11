package com.example.cosda.glassmaps;

        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Path;
        import android.util.AttributeSet;
        import android.view.View;

public class MapDisplay extends View {

    public int w=560;
    public int h=240;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    Context context;
    private Paint mPaint;
    private float mX, mY;
    private static final float TOLERANCE = 5;
    public int mapX;
    public int mapY;

    public MapDisplay(Context c, AttributeSet attrs) {
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

    protected void createBitmap() {
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
        mCanvas = new Canvas(mBitmap);
    }
    // override onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        Bitmap b= BitmapFactory.decodeResource(getResources(), R.drawable.wholedlsu);
        canvas.drawColor(Color.BLACK);
        mapPosition(14.564045, 120.993678);
        canvas.drawBitmap(b, mapX, mapY, p); //navigate x and y axis, positive x moves to the left, positive y moves upwards
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(w/2, h/2, 3, p);
    }

    public void mapPosition(double x, double y){
        //function to move the map position around, need to work on equation to get what i want.
        double xmin = 14.563079;
        double ymin = 120.990966;
        double xratio = 0.004537;
        double yratio = 0.003519;
        double tempx;
        double tempy;
        double xperc;
        double yperc;
        tempx = x - xmin;
        tempy = y - ymin;
        xperc = tempx / xratio;
        yperc = tempy / yratio;

        mapX=(int)(280-(1749*xperc));
        mapY=(int)(120-(794*yperc));
    }
}