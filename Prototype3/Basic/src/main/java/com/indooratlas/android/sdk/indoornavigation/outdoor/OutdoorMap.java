package com.indooratlas.android.sdk.indoornavigation.outdoor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.indooratlas.android.sdk.indoornavigation.R;
import com.indooratlas.android.sdk.indoornavigation.ScanCode;
import com.indooratlas.android.sdk.indoornavigation.imageview.DemoRoutingManager;
import com.indooratlas.android.sdk.indoornavigation.imageview.ImageViewActivity;
import com.squareup.picasso.Picasso;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OutdoorMap extends Activity {

    private ScanCode scanCodeChecker = new ScanCode();
    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int TOP = 2;
    private static final int BOTTOM = 3;
    private Mat m;
    private List<Point> centers;
    DemoRoutingManager demo = new DemoRoutingManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoormap);
    }

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            if (status == LoaderCallbackInterface.SUCCESS ) {
                onClickRoute();

            } else {
                super.onManagerConnected(status);
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_1_0, this, mLoaderCallback);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (m != null){
            m.release();
        }
    }

    public void onClickRoute(){

        // Acquire drawable into bitmap
        Bitmap floorMap = BitmapFactory.decodeResource(getResources(), R.drawable.worldmapv1);

        // Initialize opencv Mat for processing
        m = new Mat();
        Mat hsv = new Mat();
        Mat mask = new Mat();

        // Convert floor map bitmap to opencv Mat
        Utils.bitmapToMat(floorMap,m);

        Imgproc.cvtColor(m, hsv, Imgproc.COLOR_RGB2HSV);
        Core.inRange(hsv, new Scalar(0, 70, 50), new Scalar(10, 255, 255), mask);

        // Find contours
        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(mask, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        // Centers
        centers = new ArrayList<>();

        for( int i = 0; i < contours.size(); i++ )
        {
            Rect rect = Imgproc.boundingRect(contours.get(i));
            Imgproc.rectangle(m, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(255,0,0,255), 8); // RGBA
            centers.add(new Point(rect.x + rect.width/2.0,rect.y + rect.height/2.0));
            Imgproc.drawContours( m, contours, i, new Scalar(255,255,255,255), -1 ); // RGBA
        }

        drawRouteA();

        // Convert back to bitmap:
        Bitmap bm = Bitmap.createBitmap(m.cols(), m.rows(),Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(m, bm);
        ImageView iv = (ImageView) findViewById(R.id.imageViewOutdoor);
        iv.setImageBitmap(bm);
        iv.postInvalidate();
    }

    private void drawRouteA() {
        // Starting point is the lowest point; highest y
        Point start = centers.get(0);
        double max_y = centers.get(0).y;
        int buildingCode = demo.getTargetAreaNumber();
        for (int i = 1; i < centers.size(); i++) {
            if (centers.get(i).y > max_y) {
                max_y = centers.get(i).y;
                start = centers.get(i);
            }
        }

        if(buildingCode == 1) {
            //Velasco
            start = move(start, TOP);
            start = move(start, RIGHT); // start.x = 1227.5, start.y = 591.5
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, RIGHT);
            start = move(start, RIGHT);

        }else if(buildingCode == 2){

            //FC
            start = move(start, TOP);
            start = move(start, LEFT);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, LEFT);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, RIGHT);

        }else if (buildingCode == 3){

            //Gokongwei
            start = move(start,TOP);
            start = move(start, RIGHT); // start.x = 1227.5, start.y = 591.5
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, BOTTOM);

        }else if(buildingCode == 4){

            //Miguel
            start = move(start,TOP);
            start = move(start, RIGHT); // start.x = 1227.5, start.y = 591.5
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, RIGHT);
            start = move(start, RIGHT);

        }else if(buildingCode == 10){

            //William
            start = move(start,TOP);
            start = move(start, RIGHT); // start.x = 1227.5, start.y = 591.5
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, RIGHT);
            start = move(start,TOP);
            start = move(start,TOP);
            start = move(start,TOP);
            start = move(start,TOP);
            start = move(start,TOP);
            start = move(start,TOP);
            start = move(start,TOP);
            start = move(start, LEFT);
            start = move(start, LEFT);

        }else if(buildingCode == 7){

            //STRC
            start = move(start,TOP);
            start = move(start, RIGHT); // start.x = 1227.5, start.y = 591.5
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, TOP);

        }else if(buildingCode == 9){

            //Andrew
            start = move(start,TOP);
            start = move(start, RIGHT); // start.x = 1227.5, start.y = 591.5
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, RIGHT);
            start = move(start, BOTTOM);

        }else if (buildingCode == 5){

            //Henry
            start = move(start, TOP);
            start = move(start, LEFT);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, RIGHT);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);

        }else if (buildingCode == 6){

            //SJ
            start = move(start, TOP);
            start = move(start, LEFT);   // start.x = 1314.0, start.y = 588.0
            start = move(start, TOP);
            start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
            start = move(start, RIGHT);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);

        }else if (buildingCode == 8){

            //Yuch
            start = move(start, TOP);
            start = move(start, LEFT);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, TOP);
            start = move(start, LEFT);
            start = move(start, LEFT);
            start = move(start, LEFT);
            start = move(start, LEFT);

        }

        //LS
        /*
        start = move(start, TOP);
        start = move(start, LEFT);
        start = move(start, TOP);
        start = move(start, TOP);
        start = move(start, TOP);
        start = move(start, LEFT);
        start = move(start, LEFT);*/

        //,John
        /*
        start = move(start, TOP);
        start = move(start, LEFT);
        start = move(start, TOP);
        start = move(start, TOP);
        start = move(start, TOP);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, LEFT);
        start = move(start, TOP);
        start = move(start, TOP);
        start = move(start, LEFT);
        */

        //Razon
        /*
        start = move(start,TOP);
        start = move(start, RIGHT); // start.x = 1227.5, start.y = 591.5
        start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
        start = move(start, TOP);
        start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
        start = move(start, TOP);
        start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
        start = move(start, TOP);
        start = move(start, TOP);   // start.x = 1314.0, start.y = 588.0
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, TOP);
        start = move(start, TOP);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
        start = move(start, RIGHT);
         start = move(start, TOP);
         */
    }


    private Point move(Point current, int direction){

        Log.d("Main", "current.x = " + current.x + ", current.y = " + current.y);

        removePoint(current);

        List<Point> candidate = new ArrayList<>();
        Point next = current;

        double distance;
        double threshold = m.rows()/2;
        double epsilon = 40;  // Little change in height or width

        for (int i = 0; i < centers.size(); i++){
            Point tempPoint = centers.get(i);
            distance = euclidean(current, tempPoint);
            if ( (distance > 0) && (distance < threshold)){ // not equal to current
                switch(direction){
                    case RIGHT: // Slight difference in height and to the right
                        if ((Math.abs(tempPoint.y - current.y) < epsilon) && ((tempPoint.x - current.x) > 0)){
                            candidate.add(tempPoint);
                        }
                    case LEFT: // Slight difference in height and to the left
                        if ((Math.abs(tempPoint.y - current.y) < epsilon) && ((tempPoint.x - current.x) < 0)){
                            candidate.add(tempPoint);
                        }
                    case TOP: // Slight difference in width and to the top
                        if ((Math.abs(tempPoint.x - current.x) < epsilon) && ((tempPoint.y - current.y) < 0)){
                            candidate.add(tempPoint);
                        }
                    case BOTTOM: // Slight difference in width and to the bottom
                        if ((Math.abs(tempPoint.x - current.x) < epsilon) && ((tempPoint.y - current.y) > 0)){
                            candidate.add(tempPoint);
                        }
                }
            }

        }

        if(!candidate.isEmpty()){
            Point bestCand = current;
            double bestDist = Double.MAX_VALUE;
            double tempDist;
            for (int j = 0; j < candidate.size(); j++){
                tempDist = euclidean(current, candidate.get(j));
                if( tempDist < bestDist){
                    bestCand = candidate.get(j);
                    bestDist = tempDist;
                    Log.d("Main", "centers.sizes = "  + centers.size());
                    Log.d("Main", "candidate.size = "  + candidate.size());
                    Log.d("Main", "bestDist =  " + bestDist);
                }
            }
            next = bestCand;
            candidate.clear();
        }

        Log.d("Main", "next.x = " + next.x + ", next.y = " + next.y);
        Imgproc.line(m,current,next,new Scalar(43, 129, 205, 1), 12);
        return next;
    }

    private void removePoint(Point current) {
        for (int i = 0; i < centers.size(); i++){
            Point tmp = centers.get(i);
            if (euclidean(tmp, current) < 5.0){
                centers.remove(i);
            }
        }
    }

    private double euclidean(Point first, Point second){
        double dx =  (second.x - first.x);
        double dy =  (second.y - first.y);
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_DPAD_CENTER) {

            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);
            return true;
        }
        return super.onKeyDown(keycode, event);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Intent scanResult = new Intent(getBaseContext(), ScanCode.class);
                String contents = intent.getStringExtra("SCAN_RESULT");
                scanResult.putExtra("QR_SCAN", contents);
                scanCodeChecker.Checker(0);
                startActivity(scanResult);
                finish();

            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            }
        }
    }
}
