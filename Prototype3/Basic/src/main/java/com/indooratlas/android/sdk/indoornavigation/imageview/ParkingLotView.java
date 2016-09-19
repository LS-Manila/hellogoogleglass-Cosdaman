package com.indooratlas.android.sdk.indoornavigation.imageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.indooratlas.android.sdk.indoornavigation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jian Lastino on 3/10/2016.
 */
public class ParkingLotView extends FrameLayout{
    private Path routingPath, vacantSlots, occupiedSlots,unmonitoredSlots = new Path();
    private static final float ratio= GraphicsManager.XRATIO, ratio2= GraphicsManager.YRATIO;
    private ArrayList<Vertex> routingNodes = new ArrayList<Vertex>(){{add(new Vertex("def", new Point(0,0)));}};
    private DemoRoutingManager demoRoutingManager;
    private String testvac;
    private int areaCode;
    private List<Pair<Point,Point>> slotCoordinates = new ArrayList<Pair<Point,Point>>();
private boolean isTest = false;



    public ParkingLotView(Context context) {
        super(context);
        initializeViews(context);
    }


    public ParkingLotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        demoRoutingManager = new DemoRoutingManager();
        initializeViews(context);

    }

    private void initializeViews(Context context)
    {
        //Initialize Routing Nodes
        demoRoutingManager = new DemoRoutingManager();

        routingNodes.add(new Vertex("DEFAULT", new Point(0, 0)));
        routingNodes.clear();
        }

    @Override
    protected void  onFinishInflate()
    {

        super.onFinishInflate();
        routingPath = new Path();

    }


    public void drawRoute(int currentArea)
    {
        areaCode =
        Log.d("ROUTE","Drawing route to " + Integer.toString(currentArea));
        routingNodes =DemoRoutingManager.getPath(currentArea);
Log.d("ROUTE",routingNodes.toString());
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



            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                canvas.drawCircle(250,250,20f,GraphicsManager.linePaint);
                canvas.drawPath(routingPath, GraphicsManager.linePaint);
                try {
                    canvas.drawBitmap(GraphicsManager.arrowhead, (float) Math.floor(routingNodes.get(0).coordinate.x * ratio) - (float) Math.floor(GraphicsManager.XOFFSET * ratio), (float) Math.floor(routingNodes.get(0).coordinate.y * ratio2) - (float) Math.floor(GraphicsManager.YOFFSET * ratio), new Paint());
                    if(areaCode!=DemoRoutingManager.getArea())
                        canvas.drawBitmap(GraphicsManager.exit, (float) Math.floor(routingNodes.get(routingNodes.size() - 1).coordinate.x * ratio) - (float) Math.floor(16 * ratio), (float) Math.floor(routingNodes.get(routingNodes.size() - 1).coordinate.y * ratio2) - (float) Math.floor(23 * ratio), new Paint());
                   else
                        canvas.drawBitmap(GraphicsManager.parkHere, (float) Math.floor(routingNodes.get(routingNodes.size() - 1).coordinate.x * ratio) - (float) Math.floor(16 * ratio), (float) Math.floor(routingNodes.get(routingNodes.size() - 1).coordinate.y * ratio2) - (float) Math.floor(23 * ratio), new Paint());

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }



}
