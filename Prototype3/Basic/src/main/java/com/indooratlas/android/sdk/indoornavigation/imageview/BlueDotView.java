package com.indooratlas.android.sdk.indoornavigation.imageview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.indooratlas.android.sdk.indoornavigation.R;

import java.util.ArrayList;

/**
 * Extends great ImageView library by Dave Morrissey. See more:
 * https://github.com/davemorrissey/subsampling-scale-image-view.
 */
public class BlueDotView extends SubsamplingScaleImageView {
    private static final double EARTH_RADIUS = 6378100.0;
    private int offset;
    private float radius = 1.0f;
    private PointF dotCenter = null;
    private Path routingPath = new Path();
    private ArrayList<Vertex> routingNodes = new ArrayList<Vertex>(){{add(new Vertex("def", new Point(0,0)));}};
    private int areaCode;
    private static final float ratio= GraphicsManager.XRATIO, ratio2= GraphicsManager.YRATIO;

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setDotCenter(PointF dotCenter) {
        this.dotCenter = dotCenter;
    }

    public BlueDotView(Context context) {
        this(context, null);
    }

    public BlueDotView(Context context, AttributeSet attr) {
        super(context, attr);
        initialise();
    }

    private void initialise() {
        setWillNotDraw(false);
        //setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_INSIDE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!isReady()) {
            return;
        }
    Log.d("CANVAS", Integer.toString(canvas.getWidth()) + Integer.toString(canvas.getHeight()));
        if (dotCenter != null) {
            PointF vPoint = sourceToViewCoord(dotCenter);
            float scaledRadius = getScale() * radius;
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(getResources().getColor(R.color.ia_blue));

            // fill color
            Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint1.setColor(0x110000FF);
            paint1.setStyle(Paint.Style.FILL);

            // stroke color
            Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint2.setColor(0xFF0000FF);
            paint2.setStyle(Paint.Style.STROKE);

            //blue circle around blue dot
            float subx1 = scaledRadius + 100;
            float subx2 = scaledRadius + 100;
            canvas.drawCircle(vPoint.x, vPoint.y, scaledRadius, paint);
            canvas.drawCircle(vPoint.x, vPoint.y, subx1, paint1);
            canvas.drawCircle(vPoint.x, vPoint.y, subx2, paint2);
        }


        //TODO: draws arrow head and destination images on map
        if(!routingPath.isEmpty()) {
            areaCode = 1;
            canvas.drawPath(routingPath, GraphicsManager.linePaint);
            try {
                PointF asd =  sourceToViewCoord(routingNodes.get(0).coordinate.x,routingNodes.get(0).coordinate.y);
                canvas.drawBitmap(GraphicsManager.arrowhead, asd.x,asd.y, new Paint());

                canvas.drawBitmap(GraphicsManager.arrowhead, (float) Math.floor(routingNodes.get(0).coordinate.x * ratio) - (float) Math.floor(GraphicsManager.XOFFSET * ratio), (float) Math.floor(routingNodes.get(0).coordinate.y * ratio2) - (float) Math.floor(GraphicsManager.YOFFSET * ratio), new Paint());
                if (areaCode != DemoRoutingManager.getArea())
                    canvas.drawBitmap(GraphicsManager.exit, (float) Math.floor(routingNodes.get(routingNodes.size() - 1).coordinate.x * ratio) - (float) Math.floor(16 * ratio), (float) Math.floor(routingNodes.get(routingNodes.size() - 1).coordinate.y * ratio2) - (float) Math.floor(23 * ratio), new Paint());
                else
                    canvas.drawBitmap(GraphicsManager.parkHere, (float) Math.floor(routingNodes.get(routingNodes.size() - 1).coordinate.x * ratio) - (float) Math.floor(16 * ratio), (float) Math.floor(routingNodes.get(routingNodes.size() - 1).coordinate.y * ratio2) - (float) Math.floor(23 * ratio), new Paint());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //TODO : draws route on map - gets route/routing nodes from DemoRoutingManager
    /**public void setRoute(int currentArea){

        Log.d("ROUTE", "Drawing route to " + Integer.toString(currentArea));
        routingNodes = DemoRoutingManager.getPath(currentArea);
        Log.d("ROUTE", routingNodes.toString());
        routingPath.reset();
        if(routingNodes!=null) {
            routingPath.moveTo((int) Math.floor(routingNodes.get(0).coordinate.x * ratio), (int) Math.floor(routingNodes.get(0).coordinate.y * ratio2));
            for (Vertex g : routingNodes) {
                int c2 = (int) Math.floor(g.coordinate.x * ratio);
                int b2 = (int) Math.floor(g.coordinate.y * ratio2);

                routingPath.lineTo(c2, b2);
            }
            routingPath.lineTo((int) Math.floor(routingNodes.get(routingNodes.size() - 1).coordinate.x * ratio), (int) Math.floor(routingNodes.get(routingNodes.size() - 1).coordinate.y * ratio2));

            invalidate();
        }
    }**/
}
