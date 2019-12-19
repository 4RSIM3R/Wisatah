package com.studio.suku.ngitab.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.studio.suku.ngitab.model.ResponseObject
import com.studio.suku.ngitab.service.ApiRepository

class ListViewModel : ViewModel() {

    val apiRepository = ApiRepository()

    var listPlaces : MutableLiveData<Array<ResponseObject>> = MutableLiveData()

    fun requestListPlaces(){
        apiRepository.getListPlaces({
            listPlaces.postValue(it)
        },{
            Log.e("Ada Error", it.message)
        })

    }

}
