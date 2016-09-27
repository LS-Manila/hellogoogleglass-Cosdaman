package com.indooratlas.android.sdk.indoornavigation.imageview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.indooratlas.android.sdk.indoornavigation.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoomSelection extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_selection);
GraphicsManager.initalizeGraphics(getApplicationContext());
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                /*
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
    */
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                /*
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition)
                        Integer.toString(groupPosition) + " " + Integer.toString(childPosition) , Toast.LENGTH_SHORT)
                        .show();
                        */
                Intent myIntent = new Intent(RoomSelection.this, ImageViewActivity.class);
                DemoRoutingManager.setArea(groupPosition+1);
                DemoRoutingManager.setRoom(childPosition);
                RoomSelection.this.startActivity(myIntent);
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Velasco First Floor");
        listDataHeader.add("Velasco Second Floor");
        listDataHeader.add("Velasco Third Floor");
        listDataHeader.add("Velasco Fourth Floor");
        listDataHeader.add("Velasco Fifth Floor");

        // Adding child data
        List<String> LFirst = new ArrayList<String>();
        List<String> LSecond = new ArrayList<String>();
        List<String> LThird = new ArrayList<String>();
        List<String> LFourth = new ArrayList<String>();
        List<String> LFifth = new ArrayList<String>();

        LFirst.add("L101");
        LFirst.add("L101D");
        LFirst.add("L103");
        LFirst.add("L104");
        LFirst.add("L105");
        LFirst.add("L106");
        LFirst.add("L107");
        LFirst.add("L108");
        LFirst.add("L109");

        LSecond.add("L201");
        LSecond.add("L202");
        LSecond.add("L203");
        LSecond.add("L204");
        LSecond.add("L205");
        LSecond.add("L206");
        LSecond.add("L207");
        LSecond.add("L208A");
        LSecond.add("L208B");

        LThird.add("L301");
        LThird.add("L302");
        LThird.add("L303A");
        LThird.add("L303B");
        LThird.add("L304");
        LThird.add("L305");
        LThird.add("L306");
        LThird.add("L307");
        LThird.add("L308");
        LThird.add("L309");
        LThird.add("L310");
        LThird.add("L311");
        LThird.add("L312");
        LThird.add("L313");
        LThird.add("L314");


        LFourth.add("L401");
        LFourth.add("L402");
        LFourth.add("L403");
        LFourth.add("L404");
        LFourth.add("L405");
        LFourth.add("L406");
        LFourth.add("L407");
        LFourth.add("L408");
        LFourth.add("L409");
        LFourth.add("L410A");
        LFourth.add("L410B");
        LFourth.add("L411");
        LFourth.add("L412");
        LFourth.add("L413");
        LFourth.add("L414");
        LFourth.add("L415");

        LFifth.add("L501");
        LFifth.add("L502");
        LFifth.add("L503");
        LFifth.add("L504");
        LFifth.add("L505");
        LFifth.add("L506");
        LFifth.add("L507");
        LFifth.add("L508");
        LFifth.add("L509");
        LFifth.add("L510");
        LFifth.add("L511");
        LFifth.add("L512");
        LFifth.add("L513");

        listDataChild.put(listDataHeader.get(0), LFirst); // Header, Child data
        listDataChild.put(listDataHeader.get(1), LSecond);
        listDataChild.put(listDataHeader.get(2), LThird);
        listDataChild.put(listDataHeader.get(3), LFourth);
        listDataChild.put(listDataHeader.get(4), LFifth);

    }
}
