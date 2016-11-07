package com.indooratlas.android.sdk.indoornavigation.outdoor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.Toast;

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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OutdoorYouHere extends Activity {

    Mat m;
    String QR_Data = null;
    Bundle extras;
    String filePath = "storage/emulated/legacy/DCIM/Logs/";
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    String formattedDate = df.format(c.getTime());
    String formattedTime = sdf.format(c.getTime());
    String FileName;
    String logData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoormap);
        findViewById(android.R.id.content).setKeepScreenOn(true);

         extras = getIntent().getExtras();
        //qr data scanned turned into string and transferred to this class
        QR_Data = extras.getString("QR_SCAN");

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

                    ImageView iv = (ImageView) findViewById(R.id.imageViewOutdoor);
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

        m = Utils.loadResource(OutdoorYouHere.this, R.drawable.worldmapv2, Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
        Bitmap bm = Bitmap.createBitmap(m.cols(), m.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(m, bm);
        Bitmap tempBitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.RGB_565);
        Canvas tempCanvas = new Canvas(tempBitmap);
        tempCanvas.drawBitmap(bm, 0, 0, null);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        Log.d("QR", QR_Data);
        logData = formattedTime + "--- QR:" + QR_Data + " Scan from Where Am I";
        generateLogFile(logData);

        switch (QR_Data) {

            //drawcircle ( x , y , radius , paint formatting)
            case "XI":

                tempCanvas.drawCircle(0, 0, 10, paint);
                break;

            case "LAMBDA":

                tempCanvas.drawCircle(500, 250, 20, paint);
                break;

            default:

                tempCanvas.drawCircle(750, 500, 40, paint);
                break;
        }

            //test for drawing check coordinates

        ImageView iv = (ImageView) findViewById(R.id.imageViewOutdoor);
        iv.setImageBitmap(tempBitmap);
        Toast.makeText(OutdoorYouHere.this, "Please tap the touchpad to return.", Toast.LENGTH_SHORT).show();
    }


    public void generateLogFile(String sBody) {
        try {
            FileName =filePath + formattedDate+".txt";
            File log = new File(FileName);
            FileWriter writer;
            sBody = "\n" + sBody;
            writer = new FileWriter(log,true);
            writer.append(sBody);
            writer.flush();
            writer.close();

            Log.d("Log", "QR Data Logged");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_DPAD_CENTER) {

            finish();
        }
        return super.onKeyDown(keycode, event);
    }
}
