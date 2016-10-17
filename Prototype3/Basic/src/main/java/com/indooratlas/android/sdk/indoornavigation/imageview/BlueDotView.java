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

public class BlueDotView extends SubsamplingScaleImageView {
    private static final double EARTH_RADIUS = 6378100.0;
    private int offset;
    private float radius = 1.0f;
    private PointF dotCenter = null;
    private Path routingPath = new Path();
    private ArrayList<Vertex> routingNodes = new ArrayList<Vertex>(){{add(new Vertex("def", new Point(0,0)));}};
    private int areaCode;
    Paint paint = new Paint();
    Paint paint1, paint2;

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
        if (dotCenter != null) {
            PointF vPoint = sourceToViewCoord(dotCenter);
            float scaledRadius = getScale() * radius;
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(getResources().getColor(R.color.ia_blue));

            // fill color
            paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint1.setColor(0x110000FF);
            paint1.setStyle(Paint.Style.FILL);

            // stroke color
            paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint2.setColor(0xFF0000FF);
            paint2.setStyle(Paint.Style.STROKE);

            //blue circle around blue dot
            float subx1 = scaledRadius + 100;
            float subx2 = scaledRadius + 100;
            canvas.drawCircle(vPoint.x, vPoint.y, scaledRadius, paint);
            canvas.drawCircle(vPoint.x, vPoint.y, subx1, paint1);
            canvas.drawCircle(vPoint.x, vPoint.y, subx2, paint2);
        }

		//draw of route
        if(!routingPath.isEmpty()) {
            canvas.drawPath(routingPath, GraphicsManager.linePaint);
        }
    }

    //TODO : draws route on map - gets route/routing nodes from DemoRoutingManager
    public void setRoute(int currentArea){

        routingNodes = DemoRoutingManager.getPath(currentArea);
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
    }
}
