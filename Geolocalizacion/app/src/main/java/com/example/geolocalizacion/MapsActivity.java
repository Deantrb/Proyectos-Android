package com.example.geolocalizacion;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.example.geolocalizacion.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Marker marcador;
    double lat=0.0;
    double lng=0.0;
    String mensaje;
    String direccion="\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        miUbicacion();
        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(18.632681, -99.151238);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
    }
    private void locationStart(){
        LocationManager mManager=(LocationManager)  getSystemService(Context.LOCATION_SERVICE);
        final boolean gpsEnabled=mManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(!gpsEnabled){
            Intent settings=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settings);
        }
    }
    private void setLocation(Location loc){
        if(loc.getLatitude()!=0.0&& loc.getLongitude()!=0.0){
            try {
                Geocoder geo=new Geocoder(this, Locale.getDefault());
                List<Address> list=geo.getFromLocation(
                        loc.getLatitude(),loc.getLongitude(),1);
                if(!list.isEmpty()){
                    Address DirCalle=list.get(0);
                    direccion=(DirCalle).getAddressLine(0);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void AgregarMarcador(double lat,double lng){
        LatLng coor=new LatLng(lat,lng);
        CameraUpdate miUbi= CameraUpdateFactory.newLatLngZoom(coor,16);
        if(marcador!=null)marcador.remove();
        marcador=mMap.addMarker(new MarkerOptions().position(coor).title("Aqui estoy "+direccion));
        mMap.animateCamera(miUbi);
    }
    private void ActualizarUbicacion(Location location){
        if(location!=null){
            lat=location.getLatitude();
            lng=location.getLongitude();
            AgregarMarcador(lat,lng);
        }

    }
    LocationListener locListener=new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            ActualizarUbicacion(location);
            setLocation(location);
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            mensaje="GPS Activado";
            Mensaje();
        }

        @Override
        public void onProviderDisabled( String provider) {
            mensaje="GPS Desactivado";
            locationStart();
            Mensaje();
        }


    };
    private static int PETICION_PERMISO_LOCACLIZACION=101;
    private void miUbicacion() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED
                &&ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PETICION_PERMISO_LOCACLIZACION);
            return;
        }else{
            LocationManager locationManager =(LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            ActualizarUbicacion(location);
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,1200,0,locListener);

        }
    }
    public void Mensaje(){
        Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show();

    }

}