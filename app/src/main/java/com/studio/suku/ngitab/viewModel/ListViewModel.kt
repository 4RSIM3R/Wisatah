package com.studio.suku.ngitab.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.studio.suku.ngitab.model.ResponseObject
import com.studio.suku.ngitab.service.ApiRepository

class ListViewModel : ViewModel() {

    val apiRepository = ApiRepository()

    var listPlaces : MutableLiveData<List<ResponseObject>> = MutableLiveData<List<ResponseObject>>()

    fun requestListPlaces() : MutableLiveData<List<ResponseObject>>{
        if (listPlaces.value.isNullOrEmpty())
            apiRepository.getListPlaces({
                listPlaces.postValue(it)
                Log.d("Datnya", it.size.toString())
            },{
                Log.e("Ada Error", it.message)
            })
        return listPlaces
    }

}
