package com.studio.suku.ngitab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.studio.suku.ngitab.model.ResponseObject
import com.studio.suku.wisatah.R
import kotlinx.android.synthetic.main.row_places.view.*

class PlacesAdapter() : RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder>() {

    private var dataPlaces = arrayOf<ResponseObject>()

    fun setDataPlaces(newData : Array<ResponseObject>){
        dataPlaces = newData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
        return  PlacesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_places, parent, false))
    }

    override fun getItemCount(): Int {
        return dataPlaces.size
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        holder.view.places_title.text = "Hiya"
        holder.view.places_desc.text = "Etes"
    }

    class PlacesViewHolder(val view : View) : RecyclerView.ViewHolder(view) {

    }

}