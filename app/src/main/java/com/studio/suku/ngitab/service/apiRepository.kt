package com.studio.suku.ngitab.service

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.isSuccessful
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.studio.suku.ngitab.model.ResponseObject
import com.studio.suku.ngitab.utility.Utility
import java.lang.AssertionError

class ApiRepository(){

    private lateinit var placesDataRequest : Request

    fun getListPlaces(onSuccess: (List<ResponseObject>) -> Unit, onError:(FuelError) -> Unit){
        Log.d("Suku", "Doing Request")
        placesDataRequest = Fuel.get(Utility.url).responseObject<List<ResponseObject>>{req, res, result ->
            result.fold({
                onSuccess(it)
            }, {
                onError(it)
            })
        }
    }

}