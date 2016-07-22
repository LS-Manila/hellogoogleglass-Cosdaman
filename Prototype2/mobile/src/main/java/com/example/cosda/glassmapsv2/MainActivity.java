package com.example.cosda.glassmapsv2;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;


public class MainActivity extends Activity {

    private Set<BluetoothDevice>pairedDevices;
    ListView lv;
    final BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button turnON = (Button) findViewById(R.id.turnON);
        final Button discoverable = (Button) findViewById(R.id.discoverable);
        final Button turnOFF = (Button) findViewById(R.id.turnOFF);
        lv = (ListView)findViewById(R.id.listView);


        turnON.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!bluetooth.isEnabled()) {
                    startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 0);
                }
            }
        });

        discoverable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (!bluetooth.isDiscovering()) {
                    startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE), 0);
                }
            }
        });
        turnOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                bluetooth.disable();
            }
        });

    }

    public void list(View v){
        pairedDevices = bluetooth.getBondedDevices();
        ArrayList list = new ArrayList();
        for(BluetoothDevice bt : pairedDevices)
            list.add(bt.getName());
        Toast.makeText(getApplicationContext(),"Showing Paired Devices",Toast.LENGTH_SHORT).show();

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
