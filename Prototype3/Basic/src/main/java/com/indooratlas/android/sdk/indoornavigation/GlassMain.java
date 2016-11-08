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
import com.google.android.glass.view.WindowUtils;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import com.indooratlas.android.sdk.indoornavigation.imageview.DemoRoutingManager;
import com.indooratlas.android.sdk.indoornavigation.imageview.GraphicsManager;
import com.indooratlas.android.sdk.indoornavigation.imageview.ImageViewActivity;
import com.indooratlas.android.sdk.indoornavigation.outdoor.OutdoorMap;
import com.indooratlas.android.sdk.indoornavigation.outdoor.OutdoorYouHere;

public class GlassMain extends Activity {

    private CardScrollView mCardScroller;
    private View mView;
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        //initialize graphics
        GraphicsManager.initializeGraphics(getApplicationContext());

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

        //set menu to open on click
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

        //contents of main menu
        CardBuilder card = new CardBuilder(this, CardBuilder.Layout.COLUMNS);
        card.setText("Welcome to the Main Menu");
        card.setIcon(R.drawable.ic_glass_logo);
        return card.getView();
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu){
        if (featureId == WindowUtils.FEATURE_VOICE_COMMANDS || featureId ==  Window.FEATURE_OPTIONS_PANEL) {
            getMenuInflater().inflate(R.menu.mainmenuoptions, menu);
            return true;
        }
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        if (featureId == WindowUtils.FEATURE_VOICE_COMMANDS || featureId ==  Window.FEATURE_OPTIONS_PANEL) {
            switch (item.getItemId()) {

                case R.id.display_indoor_map_menu_item:
                    intent = new Intent(GlassMain.this, ImageViewActivity.class);
                    startActivity(intent);
                    break;

                case R.id.display_outdoor_map_menu_item:
                    intent = new Intent(GlassMain.this, OutdoorMap.class);
                    startActivity(intent);
                    break;

                case R.id.navigate_menu_item:
                    intent = new Intent(GlassMain.this, NavigateDisplay.class);
                    startActivity(intent);
                    break;

                case R.id.qr_menu_item:
                    intent = new Intent("com.google.zxing.client.android.SCAN");
                    intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                    startActivityForResult(intent, 0);
                    break;

                /*
                case R.id.test_menu_item:
                    DemoRoutingManager.setArea(1);
                    DemoRoutingManager.setRoom(1);
                    Intent myIntent = new Intent(this, OutdoorMap.class);
                    intentChecker = 1;
                    this.startActivity(myIntent);
                    break;
                */

                case R.id.exit_menu_item:
                    finish();
                    break;

            }
            return true;
        }
        return super.onMenuItemSelected(featureId, item);
    }


    //on result for qr code scan "where am i"
    //this is where the qr code results are
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Intent scanResult = new Intent(getBaseContext(), OutdoorYouHere.class);
                String contents = intent.getStringExtra("SCAN_RESULT");
                //scanResult.putExtra("FLOOR_NUMBER", floorNumber);
                //scanResult.putExtra("ROOM_NUMBER", roomNumber);
                scanResult.putExtra("QR_SCAN", contents);
                startActivity(scanResult);

            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            }
        }
    }
}