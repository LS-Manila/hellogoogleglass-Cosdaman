package com.example.cosda.glassmaps;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private CardScrollView mCardScroller;
    private View mView;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mView = buildView();
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
        // Handle the TAP event.
        mCardScroller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Plays disallowed sound to indicate that TAP actions are not supported.
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(Sounds.DISALLOWED);
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
        View view = new CardBuilder(this, CardBuilder.Layout.EMBED_INSIDE)
                .setEmbeddedLayout(R.layout.main)
                .getView();
        ImageView imageView = (ImageView) findViewById(R.id.BoxView);
        GPSTracker gps = new GPSTracker(this);
        TextView textView1 = (TextView) view.findViewById(R.id.footer);
        if(gps.canGetLocation()) {
            textView1.setText(gps.getLatitude()+ ", " + gps.getLongitude() );
        }
        return view;
    }

}
