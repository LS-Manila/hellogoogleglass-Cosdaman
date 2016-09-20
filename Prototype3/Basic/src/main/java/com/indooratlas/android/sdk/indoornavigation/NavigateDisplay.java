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

public class NavigateDisplay extends Activity{

    private CardScrollView mCardScroller;
    private View mView;
    Intent intentQR = new Intent("com.google.zxing.client.android.SCAN");
    private static int floorNumber;
    private static int roomNumber;


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
    public boolean onCreatePanelMenu(int featureId, Menu menu){
        if (featureId == WindowUtils.FEATURE_VOICE_COMMANDS || featureId ==  Window.FEATURE_OPTIONS_PANEL) {
            getMenuInflater().inflate(R.menu.mapmenuoptions, menu);
            return true;
        }
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        if (featureId == WindowUtils.FEATURE_VOICE_COMMANDS || featureId ==  Window.FEATURE_OPTIONS_PANEL) {
            switch (item.getItemId()) {
                case R.id.L101:
                    intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                    startActivityForResult(intentQR, 0);
                    floorNumber = 1;
                    roomNumber = 1;
                    break;

                case R.id.L101D:
                    intentQR.putExtra("SCAN_MODE", "QR_CODE_MODE");
                    startActivityForResult(intentQR, 0);
                    break;

            }
            return true;
        }
        return super.onMenuItemSelected(featureId, item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Intent scanResult = new Intent(getBaseContext(), ScanCode.class);
                String contents = intent.getStringExtra("SCAN_RESULT");
                //maybe unnecessary
                //String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                scanResult.putExtra("FLOOR_NUMBER", floorNumber);
                scanResult.putExtra("ROOM_NUMBER", roomNumber);
                scanResult.putExtra("QR_SCAN", contents);
                startActivity(scanResult);

            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            }
        }
    }

}
