package com.hoody.doghoody;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import net.daum.mf.map.api.MapView;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        //다음지도 사용
        MapView mapView = new MapView(this);
        mapView.setDaumMapApiKey("61cf90638e47b3e02de4dd54abd50797");

        ViewGroup mapViewContainer = (ViewGroup)findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        //.MapViewEventListener
        //.POIItemEventListener
        //.OpenAPIKeyAuthenticationResultListener

        RelativeLayout container = (RelativeLayout) findViewById(R.id.map_view);
        container.removeAllViews();
        container.addView(mapView);
    }
}
