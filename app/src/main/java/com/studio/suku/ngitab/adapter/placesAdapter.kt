package com.studio.suku.ngitab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.studio.suku.ngitab.model.ResponseObject
import com.studio.suku.wisatah.R
import com.studio.suku.wisatah.databinding.RowPlacesBinding
import kotlinx.android.synthetic.main.row_places.view.*

class PlacesAdapter() : RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder>() {

    private lateinit var dataPlaces : List<ResponseObject>

    fun setDataPlaces(newData : List<ResponseObject>){
        dataPlaces = newData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowPlacesBinding.inflate(inflater)
        return PlacesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataPlaces.size
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        return holder.bind(dataPlaces[position])
    }

    class PlacesViewHolder(val binding: RowPlacesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemResponse : ResponseObject){
            binding.item = itemResponse
            binding.executePendingBindings()
        }
    }

}