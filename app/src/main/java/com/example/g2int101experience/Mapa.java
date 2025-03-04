package com.example.g2int101experience;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para mostrar un mapa debemos usar un SupportMapFragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fgMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        //Mapa normal, se puede cambiar de ser necesario
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Lista de ubicaciones
        //Unas pocas de momento
        LatLng plazaMayor = new LatLng(40.4611107,-3.7580916);
        LatLng museoDeLasIlusiones = new LatLng(40.41325,-3.70392);
        LatLng museoDelPadro = new LatLng(40.41354,-3.69143);
        LatLng temploDeDebod = new LatLng(40.425,-3.713);
        LatLng barrioMalanesa = new LatLng(40.4270,-3.7050);


        //Marcadores
        //================================ NOTAS ====================================================
        //Un marcador transparente como tal no existe, tendría que hacerlo mediante drawable o bitmap
        //De momento los pongo normales a espera de nuevas instrucciones
        //Marcadores de distinto color para variar un poco
        mMap.addMarker(new MarkerOptions()
                        .position(plazaMayor)
                        .title("Plaza Mayor")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
                .showInfoWindow();

        mMap.addMarker(new MarkerOptions()
                        .position(museoDeLasIlusiones)
                        .title("Museo De Las Ilusiones")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
                .showInfoWindow();

        mMap.addMarker(new MarkerOptions()
                        .position(museoDelPadro)
                        .title("Museo del Prado")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
                .showInfoWindow();

        mMap.addMarker(new MarkerOptions()
                        .position(temploDeDebod)
                        .title("Templo de Debod")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
                .showInfoWindow();

        mMap.addMarker(new MarkerOptions()
                        .position(barrioMalanesa)
                        .title("Barrio de Malasaña")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
                .showInfoWindow();

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(plazaMayor, 10f);
        mMap.moveCamera(cameraUpdate);


    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {

    }

}
