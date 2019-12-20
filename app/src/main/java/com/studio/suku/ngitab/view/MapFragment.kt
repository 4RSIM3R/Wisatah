package com.studio.suku.ngitab.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

import com.studio.suku.wisatah.R
import com.studio.suku.ngitab.viewModel.MapViewModel
import kotlinx.android.synthetic.main.map_fragment.*

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var map : GoogleMap

    companion object {
        fun newInstance() = MapFragment()
    }




    private lateinit var viewModel: MapViewModel

    override fun onMapReady(p0: GoogleMap?) {
        p0?.let {
            map = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        my_map.onCreate(savedInstanceState)
        my_map.onResume()
        my_map.getMapAsync(this)
        viewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)

    }



}
