package com.indooratlas.android.sdk.indoornavigation.outdoor;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
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
    public void onResume() {
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

            //Buildings
            case "ALPHA":
                tempCanvas.drawCircle(341, 380, 5, paint);
                break;

            case "BETA":
                tempCanvas.drawCircle(55, 330, 5, paint);
                break;

            case "DELTA":
                tempCanvas.drawCircle(314, 256, 5, paint);
                break;

            case "HETA":
                tempCanvas.drawCircle(534, 143, 5, paint);
                break;

            case "IOTA":
                tempCanvas.drawCircle(374, 326, 5, paint);
                break;

            case "LAMBDA":
                tempCanvas.drawCircle(487, 370, 5, paint);
                break;

            case "MU":
                tempCanvas.drawCircle(570, 305, 5, paint);
                break;

            case "OMICRON":
                tempCanvas.drawCircle(796, 308, 5, paint);
                break;

            case "PI":
                tempCanvas.drawCircle(930, 310, 5, paint);
                break;

            case "RHO":
                tempCanvas.drawCircle(901, 332, 5, paint);
                break;

            case "THETA":
                tempCanvas.drawCircle(446, 194, 5, paint);
                break;

            case "XI":
                tempCanvas.drawCircle(682, 342, 5, paint);
                break;

            case "ZETA":
                tempCanvas.drawCircle(368, 108, 5, paint);
                break;

            //checkpoints
            case "AGNO GATE":
                tempCanvas.drawCircle(672, 333, 5, paint);
                break;

            case "SJ WALK":
                tempCanvas.drawCircle(561, 216, 5, paint);
                break;

            case "LAMBDA WALK":
                tempCanvas.drawCircle(536, 367, 5, paint);
                break;

            case "CENTRAL PLAZA":
                tempCanvas.drawCircle(362, 220, 5, paint);
                break;

            case "ALPHA CHECKPOINT":
                tempCanvas.drawCircle(198, 374, 5, paint);
                break;

            case "LAMBDA GATE":
                tempCanvas.drawCircle(535, 458, 5, paint);
                break;

            default:
                tempCanvas.drawCircle(370, 454, 5, paint);
                break;
        }

            //test for drawing check coordinates===

        ImageView iv = (ImageView) findViewById(R.id.imageViewOutdoor);
        iv.setImageBitmap(tempBitmap);
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
