package com.indooratlas.android.sdk.indoornavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.google.android.glass.app.Card;
import com.google.android.glass.view.WindowUtils;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import com.indooratlas.android.sdk.indoornavigation.imageview.DemoRoutingManager;

public class NavigateDisplay extends Activity {

    private CardScrollView mCardScroller;
    private View mView;
    Intent intentQR = new Intent("com.google.zxing.client.android.SCAN");
    public static int floorNumber;
    public static int roomNumber;
    ScanCode scanCodeChecker = new ScanCode();


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
        mCardScroller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openOptionsMenu();
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
        CardBuilder card = new CardBuilder(this, CardBuilder.Layout.TEXT);
        card.setText("Tap to Navigate");
        return card.getView();

    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId == WindowUtils.FEATURE_VOICE_COMMANDS || featureId == Window.FEATURE_OPTIONS_PANEL) {
            getMenuInflater().inflate(R.menu.mapmenuoptions, menu);
            return true;
        }
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //GlassMenuSwitch.getFloorNumber(item.getItemId()); TODO CREATE FUNCTION TO MOVE SWITCH STATEMENT TO ANOTHER JAVA CLASS

        switch (item.getItemId()) {

            case R.id.L101:
                floorNumber = 1;
                roomNumber = 1;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L101D:
                floorNumber = 1;
                roomNumber = 2;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L103:
                floorNumber = 1;
                roomNumber = 3;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L104:
                floorNumber = 1;
                roomNumber = 4;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;


            case R.id.L105:
                floorNumber = 1;
                roomNumber = 5;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;


            case R.id.L106:
                floorNumber = 1;
                roomNumber = 6;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;


            case R.id.L107:
                floorNumber = 1;
                roomNumber = 7;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;


            case R.id.L108:
                floorNumber = 1;
                roomNumber = 8;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L109:
                floorNumber = 1;
                roomNumber = 9;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L201:
                floorNumber = 2;
                roomNumber = 1;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L202:
                floorNumber = 2;
                roomNumber = 2;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L203:
                floorNumber = 2;
                roomNumber = 3;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L204:
                floorNumber = 2;
                roomNumber = 4;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;


            case R.id.L205:
                floorNumber = 2;
                roomNumber = 5;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;


            case R.id.L206:
                floorNumber = 2;
                roomNumber = 6;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;


            case R.id.L207:
                floorNumber = 2;
                roomNumber = 7;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;


            case R.id.L208A:
                floorNumber = 2;
                roomNumber = 8;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L208B:
                floorNumber = 2;
                roomNumber = 9;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;


            case R.id.L312:
                floorNumber = 3;
                roomNumber = 0;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L306:
                floorNumber = 3;
                roomNumber = 1;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L415:
                floorNumber = 4;
                roomNumber = 0;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L406:
                floorNumber = 4;
                roomNumber = 1;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L504:
                floorNumber = 5;
                roomNumber = 0;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

            case R.id.L507:
                floorNumber = 5;
                roomNumber = 0;
                intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intentQR, 0);
                break;

        }


        if (featureId == WindowUtils.FEATURE_VOICE_COMMANDS || featureId ==  Window.FEATURE_OPTIONS_PANEL) {

            //TODO create function to move the switch case to another class

            return true;
        }
        return super.onMenuItemSelected(featureId, item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Intent scanResult = new Intent(getBaseContext(), ScanCode.class);
                String contents = intent.getStringExtra("SCAN_RESULT");
                scanResult.putExtra("FLOOR_NUMBER", floorNumber);
                scanResult.putExtra("ROOM_NUMBER", roomNumber);
                scanResult.putExtra("QR_SCAN", contents);
                scanCodeChecker.Checker(1);
                startActivity(scanResult);
                finish();

            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            }
        }
    }

}
