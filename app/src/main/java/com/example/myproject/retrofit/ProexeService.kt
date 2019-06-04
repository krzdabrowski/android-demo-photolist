package com.example.myproject.retrofit

import com.example.myproject.model.Photo
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProexeService {

    @GET("json.json")
    fun getPhotos(): Deferred<Response<List<Photo>>>

    companion object {
        fun create(): ProexeService {
            return Retrofit.Builder()
                .baseUrl("http://client.proexe.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(ProexeService::class.java)
        }
    }
}