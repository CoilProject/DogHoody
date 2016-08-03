package com.hoody.doghoody;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class MapActivity extends AppCompatActivity {

    private MapView mapView;
    private int tag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        //다음지도 사용
        mapView = new MapView(this);
        mapView.setDaumMapApiKey("61cf90638e47b3e02de4dd54abd50797");

        ViewGroup mapViewContainer = (ViewGroup)findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        //.MapViewEventListener
        //.POIItemEventListener
        //.OpenAPIKeyAuthenticationResultListener


        //중심점변경
        //mapView.setMapCenterPoint(MapPoint,true);


        //마커 생성 및 설정
        addMarker("시청역",37.5657125,126.9771195);

        RelativeLayout container = (RelativeLayout) findViewById(R.id.map_view);
        container.removeAllViews();
        container.addView(mapView);
    }

    private void addMarker(String name,double latitude,double longitude){
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName(name);
        marker.setTag(tag++);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(latitude,longitude));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker);
    }

}
