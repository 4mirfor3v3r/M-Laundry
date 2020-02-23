package com.amier.laundry.network

import com.amier.laundry.model.Users
import com.google.gson.stream.JsonReader
import retrofit2.Call
import retrofit2.http.*

interface APIService {
//    @GET("getAllUsers/")
//    fun getUsers(): Call<ArrayList<Users>>

    //
    @FormUrlEncoded
    @POST("/users/tambah/")
    fun addUser(
        @Field("nama") nip: String,
        @Field("email") nama_pegawai: String,
        @Field("password") alamat_pegawai: String,
        @Field("no_telp") no_telp: String,
        @Field("jenis") jenis: String
    ): Call<Users>

//    @FormUrlEncoded
//    @PUT("edit/")
//    fun updateUser(
//        @Field("_id") _id: String,
//        @Field("nip") nip: String,
//        @Field("nama_pegawai") nama_pegawai: String,
//        @Field("alamat_pegawai") alamat_pegawai: String,
//        @Field("no_telp") no_telp: String
//    ): Call<Users>
//
//    @DELETE("delete/{id}")
//    fun deleteUser(@Path("id") _id: String): Call<JsonReader>
}