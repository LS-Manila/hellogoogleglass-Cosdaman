package com.indooratlas.android.sdk.indoornavigation.outdoor;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.indooratlas.android.sdk.indoornavigation.R;
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.IOException;

public class OutdoorYouHere extends Activity {

    Mat m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoormap);
        findViewById(android.R.id.content).setKeepScreenOn(true);
    }

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            if (status == LoaderCallbackInterface.SUCCESS ) {

                try{
                    hello();
                } catch(IOException ioe) {

                    m = Mat.zeros(100,400, CvType.CV_8UC3);
                    Imgproc.putText(m, "Catch block", new Point(30, 80), Core.FONT_HERSHEY_SCRIPT_SIMPLEX, 2.2, new Scalar(200, 200, 0), 2);
                    Bitmap bm = Bitmap.createBitmap(m.cols(), m.rows(),Bitmap.Config.ARGB_8888);
                    Utils.matToBitmap(m, bm);

                    ImageView iv = (ImageView) findViewById(R.id.imageView);
                    iv.setImageBitmap(bm);
                }
            } else {
                super.onManagerConnected(status);
            }
        }
    };

    @Override
    public void onResume() {;
        super.onResume();
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_1_0, this, mLoaderCallback);
    }

    public void hello() throws IOException {

        m = Utils.loadResource(OutdoorYouHere.this, R.drawable.worldmapv1, Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
        Bitmap bm = Bitmap.createBitmap(m.cols(), m.rows(),Bitmap.Config.ARGB_8888);
        Bitmap dotbm = bm.copy(Bitmap.Config.ARGB_8888, true);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);

        //todo function to change drawn dot for scanned point to be you are here

        //test
        Canvas canvas = new Canvas(dotbm);
        canvas.drawCircle(60, 50, 25, paint);


        Utils.matToBitmap(m, bm);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageBitmap(bm);


    }
}
