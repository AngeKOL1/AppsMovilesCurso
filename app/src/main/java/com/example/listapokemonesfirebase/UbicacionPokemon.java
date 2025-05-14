package com.example.listapokemonesfirebase;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.listapokemonesfirebase.Entidades.Pokemon;
import com.example.listapokemonesfirebase.Entidades.Ubicacion;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.listapokemonesfirebase.databinding.ActivityUbicacionPokemonBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UbicacionPokemon extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityUbicacionPokemonBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion_pokemon);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Mostrar controles de zoom y permitir gestos
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        // Centrar el mapa en el mundo inicialmente (por si no hay ubicaciones)
        LatLng mundo = new LatLng(0, 0);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mundo, 1f));

        String idPokemon = getIntent().getStringExtra("pokemon_id");


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("pokemones").child(idPokemon);
        ref.get().addOnSuccessListener(snapshot -> {
            Pokemon pokemon = snapshot.getValue(Pokemon.class);
            if (pokemon != null && pokemon.ubicaciones != null && !pokemon.ubicaciones.isEmpty()) {

                // Builder para calcular los límites visibles
                LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();

                for (Ubicacion u : pokemon.ubicaciones) {
                    LatLng pos = new LatLng(u.latitud, u.longitud);
                    mMap.addMarker(new MarkerOptions().position(pos).title(pokemon.nombre));
                    boundsBuilder.include(pos);
                }

                LatLngBounds bounds = boundsBuilder.build();
                int padding = 100;
                mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
            }
        });
    }

}