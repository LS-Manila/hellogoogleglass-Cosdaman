package com.indooratlas.android.sdk.indoornavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.google.android.glass.view.WindowUtils;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import com.indooratlas.android.sdk.indoornavigation.imageview.DemoRoutingManager;
import com.indooratlas.android.sdk.indoornavigation.imageview.ImageViewActivity;
import com.indooratlas.android.sdk.indoornavigation.outdoor.OutdoorMap;

public class ScanCode extends Activity {

    private CardScrollView mCardScroller;
    private View mView;
    private static int floor_Number;
    private static int room_Number;
    private static int intentChecker;
    public static void Checker(int checker) {intentChecker = checker; //1 if from menu, 0 if from outdoor
    }
    String filePath = "storage/emulated/legacy/DCIM/Logs/";
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    String formattedDate = df.format(c.getTime());
    String formattedTime = sdf.format(c.getTime());
    String FileName;
    String logData;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mView = buildView();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().requestFeature(WindowUtils.FEATURE_VOICE_COMMANDS);


        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(new CardScrollAdapter() {
            @Override
            public int getCount() {
                return 1;
            }

            @Override
            public Object getItem(int position) {
                return mView;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return mView;
            }

            @Override
            public int getPosition(Object item) {
                if (mView.equals(item)) {
                    return 0;
                }
                return AdapterView.INVALID_POSITION;
            }
        });
        setContentView(mCardScroller);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        super.onPause();
    }


    private View buildView() {

        Bundle extras = getIntent().getExtras();
        String QR_Data = extras.getString("QR_SCAN");

        if( extras.getInt("FLOOR_NUMBER")!=0){
            floor_Number = extras.getInt("FLOOR_NUMBER");
            room_Number = extras.getInt("ROOM_NUMBER");
        }
        else{
            //idk lol
        }

        //TODO change display to tell user where intended destination is I.E. second floor of the velasco building

        CardBuilder card = new CardBuilder(this, CardBuilder.Layout.COLUMNS);
        if (intentChecker == 0){
            logData = formattedTime + "--- QR:" + QR_Data + " Destination --- Floor ID:" + floor_Number + " Room:" + room_Number + " Scan from Outdoor";
            generateLogFile(logData);
            card.setText("Current Location: " + QR_Data);
        }
        else if (intentChecker == 1)
        {
            logData = formattedTime + "--- QR:" + QR_Data + " Destination --- Floor ID:" + floor_Number + " Room:" + room_Number+ " Scan from Indoor";
            generateLogFile(logData);
            card.setText("QR Data: " + QR_Data + ". \nDestination Floor ID: " + floor_Number + ". \nDestination Room Number: " + room_Number + "\n");
        }
        card.setIcon(R.drawable.ic_glass_logo);
        return card.getView();
    }

    //create on tap listener to input floor number and room number into demoroutingmanager

    @Override
    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_DPAD_CENTER) {

            if (intentChecker == 0) {

                Intent myIntent = new Intent(this, ImageViewActivity.class);
                intentChecker = 0;
                this.startActivity(myIntent);
                finish();

            }
            else if (intentChecker == 1)
            {
                DemoRoutingManager.setArea(floor_Number);
                DemoRoutingManager.setRoom(room_Number);
                Intent myIntent = new Intent(this, OutdoorMap.class);
                intentChecker = 1;
                this.startActivity(myIntent);
                return true;
            }
        }
        return super.onKeyDown(keycode, event);
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


}
