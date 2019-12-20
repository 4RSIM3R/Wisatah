package com.studio.suku.ngitab.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.studio.suku.ngitab.model.ResponseObject

import com.studio.suku.wisatah.R
import com.studio.suku.ngitab.viewModel.MapViewModel
import kotlinx.android.synthetic.main.map_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MapFragment : Fragment() {

    private lateinit var map : GoogleMap

    private var places : List<ResponseObject> = listOf()

    companion object {
        fun newInstance() = MapFragment()
    }

    private lateinit var viewModel: MapViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)
        my_map.onCreate(savedInstanceState)
        my_map.onResume()
        observeLocationData()
        my_map.getMapAsync{ gMap ->
            map = gMap
            map.uiSettings?.isZoomControlsEnabled = true
            val pasuruan = LatLng(-7.6514338,112.8700752)
            map.moveCamera(CameraUpdateFactory.newLatLng(pasuruan))
            map.animateCamera(CameraUpdateFactory.zoomTo(10f))
        }

    }

    fun observeLocationData(){
        viewModel.getPlacesLocation().observe(viewLifecycleOwner, Observer {
            it?.let {
                it.forEach {
                    val position = LatLng(it.lat, it.lng)
                    map.addMarker(MarkerOptions().position(position).title(it.nama))
                }
            }
        })
    }




}
