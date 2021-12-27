package com.regawa.basicmaps

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.regawa.basicmaps.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var geocoder: Geocoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        geocoder = Geocoder(this)
        var lokasi = geocoder.getFromLocationName("Jalan Paledang No.235 Rt.04 Rw.02, Kelurahan Cempaka, Kecamatan Andir, Kota Bandung", 1)
        val rumahPajo = LatLng(lokasi[0].latitude, lokasi[0].longitude)
        mMap.addMarker(MarkerOptions().position(rumahPajo).title("Rumah Pajo"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahPajo))

        var lokasiAnnaz = geocoder.getFromLocationName("Puri Nawala Permai Blok D4 No.4", 1)
        val rumahAnnaz = LatLng(lokasiAnnaz[0].latitude, lokasiAnnaz[0].longitude)
        mMap.addMarker(MarkerOptions().position(rumahAnnaz).title("Rumah Annaz"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumahAnnaz))

        var lokasiSekolah = geocoder.getFromLocationName("SMK 2100 Bekasi", 1)
        val sekolahAnnaz = LatLng(lokasiSekolah[0].latitude, lokasiSekolah[0].longitude)
        mMap.addMarker(MarkerOptions().position(sekolahAnnaz).title("Sekolah Annaz"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sekolahAnnaz))
    }
}