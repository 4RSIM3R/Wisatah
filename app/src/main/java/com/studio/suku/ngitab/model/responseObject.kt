package com.studio.suku.ngitab.model
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


data class ResponseObject(
    @SerializedName("deskripsi")
    val deskripsi: String,
    @SerializedName("gambar")
    val gambar: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("nama")
    val nama: String
){
    class Deserializer : ResponseDeserializable<Array<ResponseObject>> {
        override fun deserialize(content: String): Array<ResponseObject> = Gson().fromJson(content, Array<ResponseObject>::class.java)
    }
}