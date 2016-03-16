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
    //resolution of map in glass
    public final int mapResX = 1947;
    public final int mapResY = 911;

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
        canvas.drawColor(Color.GREEN);
        mapPosition(14.565307, 120.992999);
        canvas.drawBitmap(b, mapX, mapY, p);
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(w/2, h/2, 3, p);
    }

   public void mapPosition(double latitude, double longitude){
        //function to move the map position around, need to work on equation to get what i want.
       // latitude is y axis on world, longitude is x axis on world
       final double latitudemin = 14.563425;
       final double latitudemax = 14.567229;
       final double longitudemin = 120.991574;
       final double longitudemax = 120.994401;
        final double latitudebetween = latitudemax-latitudemin;
        final double longitudebetween = longitudemax-longitudemin;
        double latdelta = latitude - latitudemin;
        double longdelta = longitude - longitudemin;
        double latperc = latdelta  / latitudebetween;
        double longperc = longdelta / longitudebetween;

        mapX=(int)(280-(mapResX*.5));
        mapY=(int)(120-(mapResY*.5));
    }
}