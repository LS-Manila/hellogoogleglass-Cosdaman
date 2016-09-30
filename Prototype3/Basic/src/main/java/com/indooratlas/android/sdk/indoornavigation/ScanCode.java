package com.indooratlas.android.sdk.indoornavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.glass.view.WindowUtils;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import com.indooratlas.android.sdk.indoornavigation.imageview.DemoRoutingManager;
import com.indooratlas.android.sdk.indoornavigation.imageview.ImageViewActivity;

/**
 * Created by Cosda on 8/28/2016.
 */
public class ScanCode extends Activity {

    private CardScrollView mCardScroller;
    private View mView;
    private int floor_Number;
    private int room_Number;


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
        floor_Number = extras.getInt("FLOOR_NUMBER");
        room_Number = extras.getInt("ROOM_NUMBER");
        CardBuilder card = new CardBuilder(this, CardBuilder.Layout.COLUMNS);
        card.setText("Insert picture of " + QR_Data + " (start location) here. Floor Number: " + floor_Number +". Room Number: "+ room_Number +"\n");
        card.setIcon(R.drawable.ic_glass_logo);

        return card.getView();
    }

    //create on tap listener to input floor number and room number into demoroutingmanager

    @Override
    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_DPAD_CENTER) {

            Intent myIntent = new Intent(this, ImageViewActivity.class);
            DemoRoutingManager.setArea(99);
            DemoRoutingManager.setRoom(1);
            this.startActivity(myIntent);

            //Toast.makeText(getApplicationContext(), " TAPPY ", Toast.LENGTH_SHORT).show();
            Log.d("Tap Listener", "TAPPY");
            return true;
        }

        return super.onKeyDown(keycode, event);
    }

}
