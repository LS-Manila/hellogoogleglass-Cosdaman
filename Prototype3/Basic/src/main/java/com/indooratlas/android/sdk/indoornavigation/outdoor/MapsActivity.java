package com.indooratlas.android.sdk.indoornavigation.outdoor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.indooratlas.android.sdk.indoornavigation.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

        LocationRequest mLocationRequest;
        GoogleApiClient mGoogleApiClient;

        LatLng latLng;
        GoogleMap mGoogleMap;
        SupportMapFragment mFragment;

    private static final LatLng HOME = new LatLng(14.342701, 121.067555);
    private static final LatLng DLSU = new LatLng(14.565477, 120.992884);
    private static final LatLng Alpha = new LatLng(14.564325, 120.993836);
    private static final LatLng Beta = new LatLng(14.563543, 120.993783);
    private static final LatLng Delta = new LatLng(14.564337, 120.993183);
    private static final LatLng Zeta = new LatLng(14.564643, 120.992285);
    private static final LatLng Heta = new LatLng(14.565079, 120.992148);
    private static final LatLng Theta = new LatLng(14.564893, 120.992536);
    private static final LatLng Iota = new LatLng(14.565006, 120.993171);
    private static final LatLng Lambda = new LatLng(14.565461, 120.993233);
    private static final LatLng Mu = new LatLng(14.565615, 120.992593);
    private static final LatLng Omicron = new LatLng(14.566313, 120.992187);
    private static final LatLng Pi = new LatLng(14.566313, 120.992187);
    private static final LatLng Rho = new LatLng(14.567012, 120.992708);
    private static final LatLng Xi = new LatLng(14.566263, 120.992984);

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);
            mFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {

            mGoogleMap = googleMap;
            mGoogleMap.setMyLocationEnabled(true);
            mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
            mGoogleMap.getUiSettings().setMapToolbarEnabled(false);
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DLSU, 17f));

            /* Not Supported
            BitmapDescriptor image = BitmapDescriptorFactory.fromResource(R.drawable.dlsugoogle);

            GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
            groundOverlayOptions.position(DLSU, 50000f);
            groundOverlayOptions.image(image);
            groundOverlayOptions.transparency(.5f);
            mGoogleMap.addGroundOverlay(groundOverlayOptions);
            */

            Marker alpha = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Alpha)
                    .title("Alpha"));
            alpha.showInfoWindow();

            Marker beta = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Beta)
                    .title("Lambda"));
            beta.showInfoWindow();

            Marker delta = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Delta)
                    .title("Delta"));
            delta.showInfoWindow();

            Marker zeta = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Zeta)
                    .title("Zeta"));
            zeta.showInfoWindow();

            Marker heta = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Heta)
                    .title("Heta"));
            heta.showInfoWindow();

            Marker theta = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Theta)
                    .title("Theta"));
            theta.showInfoWindow();

            Marker iota = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Iota)
                    .title("Iota"));
            iota.showInfoWindow();

            Marker lambda = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Lambda)
                    .title("Lambda"));
            lambda.showInfoWindow();

            Marker mu = mGoogleMap.addMarker(new MarkerOptions()
                            .position(Mu)
                            .title("Mu"));
            mu.showInfoWindow();

            Marker omicron = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Omicron)
                    .title("Omicron"));
            omicron.showInfoWindow();

            Marker rho = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Rho)
                    .title("Lambda"));
            rho.showInfoWindow();

            Marker pi = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Pi)
                    .title("Pi"));
            pi.showInfoWindow();

            Marker xi = mGoogleMap.addMarker(new MarkerOptions()
                    .position(Xi)
                    .title("Xi"));
            xi.showInfoWindow();

            mGoogleMap.addPolyline(new PolylineOptions()
                    .add(new LatLng(14.565565, 120.993119
                    ), new LatLng(14.565501, 120.992970), new LatLng(14.566040, 120.992692), new LatLng(14.566040, 120.992692), new LatLng(14.566871, 120.992309), new LatLng(14.566926, 120.992426))
                    .width(5)
                    .color(Color.RED));

            //buildGoogleApiClient();
            //mGoogleApiClient.connect();
/*
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.563812, 120.994733), new LatLng(14.562956, 120.992767), new LatLng(14.566903, 120.990885), new LatLng(14.567790, 120.992918))
                    .fillColor(Color.BLACK)
                    .strokeColor(Color.rgb(0, 0, 0)));
            //Henry Sy
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.564702, 120.993071), new LatLng(14.565138, 120.992859), new LatLng(14.565347, 120.993309), new LatLng(14.564906, 120.993506))
                    .fillColor(Color.rgb(80,80,80))
                    .strokeColor(Color.rgb(191,191,191)));
            //Velasco
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.565257, 120.992983), new LatLng(14.565523, 120.993594), new LatLng(14.565687, 120.993514), new LatLng(14.565422, 120.992903))
                    .fillColor(Color.rgb(80, 80, 80))
                    .strokeColor(Color.rgb(191,191,191)));
            //Razon
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.566616, 120.991693), new LatLng(14.566968, 120.991513), new LatLng(14.567224, 120.992075), new LatLng(14.566856, 120.992253))
                    .fillColor(Color.rgb(80,80,80))
                    .strokeColor(Color.rgb(191,191,191)));
            //Andrew
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.566840, 120.992398), new LatLng(14.567038, 120.992298), new LatLng(14.567278, 120.992889), new LatLng(14.567064, 120.992994))
                    .fillColor(Color.rgb(80,80,80))
                    .strokeColor(Color.rgb(191,191,191)));
            //Gokongwei
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.566048, 120.992792), new LatLng(14.566274, 120.992687), new LatLng(14.566482, 120.993183), new LatLng(14.566264, 120.993298))
                    .fillColor(Color.rgb(80,80,80))
                    .strokeColor(Color.rgb(191,191,191)));
            //Yuchengco
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.564082, 120.993180), new LatLng(14.564168, 120.993395), new LatLng(14.564547, 120.993212), new LatLng(14.564444, 120.992996))
                    .fillColor(Color.rgb(80,80,80))
                    .strokeColor(Color.rgb(191,191,191)));

            //Miguel
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.565402, 120.992414), new LatLng(14.565617, 120.992894), new LatLng(14.565884, 120.992773), new LatLng(14.565669, 120.992288))
                    .fillColor(Color.rgb(80,80,80))
                    .strokeColor(Color.rgb(191, 191, 191)));
            //Faculty
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.564399, 120.992227), new LatLng(14.564516, 120.992522), new LatLng(14.564913, 120.992331), new LatLng(14.564791, 120.992039))
                    .fillColor(Color.rgb(80,80,80))
                    .strokeColor(Color.rgb(191,191,191)));
            //William
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.564935, 120.991911), new LatLng(14.565124, 120.992354), new LatLng(14.565204, 120.992316), new LatLng(14.565009, 120.991874))
                    .fillColor(Color.rgb(80,80,80))
                    .strokeColor(Color.rgb(191,191,191)));
            //Sj
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.564503, 120.992635), new LatLng(14.564545, 120.992759), new LatLng(14.565366, 120.992370), new LatLng(14.565312, 120.992260))
                    .fillColor(Color.rgb(80,80,80))
                    .strokeColor(Color.rgb(191,191,191)));
            //Strc
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.566133, 120.991949), new LatLng(14.566382, 120.992464 ), new LatLng(14.566510, 120.992402), new LatLng(14.566296, 120.991874))
                    .fillColor(Color.rgb(80,80,80))
                    .strokeColor(Color.rgb(191,191,191)));
            //LS
            mGoogleMap.addPolygon(new PolygonOptions()
                    .add(new LatLng(14.563930, 120.994323), new LatLng(14.563608, 120.993607), new LatLng(14.563730, 120.993556), new LatLng(14.563906, 120.993923),
                            new LatLng(14.564695, 120.993582), new LatLng(14.564540, 120.993253), new LatLng(14.564680, 120.993184), new LatLng(14.564976, 120.993840),
                            new LatLng(14.564851, 120.993899), new LatLng(14.564763, 120.993725), new LatLng(14.563956, 120.994073), new LatLng(14.564049, 120.994273))
                    .fillColor(Color.rgb(80, 80, 80))
                    .strokeColor(Color.rgb(191, 191, 191)));


            mGoogleMap.addPolyline(new PolylineOptions()
                    .add(new LatLng(0, 0), new LatLng(14.342701, 121.067555), new LatLng(14.566040, 120.992692), new LatLng(14.566476, 120.992497), new LatLng(14.566871, 120.992309), new LatLng(14.566926, 120.992426))
                    .width(5)
                    .color(Color.RED));*/
        }

    }
