package com.studio.suku.ngitab.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kittinunf.fuel.core.HttpException
import com.github.kittinunf.fuel.coroutines.awaitObjectResult
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import com.google.gson.JsonIOException
import com.studio.suku.ngitab.adapter.PlacesAdapter
import com.studio.suku.ngitab.model.ResponseObject
import com.studio.suku.ngitab.service.ApiRepository


import com.studio.suku.ngitab.viewModel.ListViewModel
import com.studio.suku.wisatah.R
import kotlinx.android.synthetic.main.list_fragment.*
import kotlinx.coroutines.runBlocking

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel
    private var placesAdapter: PlacesAdapter = PlacesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        list_places.setHasFixedSize(true)
        list_places.layoutManager = LinearLayoutManager(context)
        viewModel.requestListPlaces()
        observerPlacesData()

    }

    fun observerPlacesData(){
        viewModel.listPlaces.observe(viewLifecycleOwner, Observer <Array<ResponseObject>>{
            it?.let {
                Log.d("Datanya", it.toString())
                placesAdapter.setDataPlaces(it)
                list_places.adapter = placesAdapter
            }
        })
    }





}
