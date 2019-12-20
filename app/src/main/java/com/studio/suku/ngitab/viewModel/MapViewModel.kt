package com.studio.suku.ngitab.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.studio.suku.ngitab.model.ResponseObject
import com.studio.suku.ngitab.service.ApiRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MapViewModel : ViewModel() {

    val repository = ApiRepository()

    val listPlacesLocation : MutableLiveData<List<ResponseObject>> = MutableLiveData<List<ResponseObject>>()

    fun getPlacesLocation() : MutableLiveData<List<ResponseObject>>{
        GlobalScope.launch {
            if (listPlacesLocation.value.isNullOrEmpty())
                repository.getListPlaces({
                    listPlacesLocation.postValue(it)
                },{
                    Log.e("Ada Error", it.message)
                })
        }
        return listPlacesLocation
    }

}
