package com.example.myproject.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myproject.model.Photo
import com.example.myproject.retrofit.ProexeService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber

class PhotoRepository(private val service: ProexeService) {

    fun fetchData(): LiveData<List<Photo>> {
        val result = MutableLiveData<List<Photo>>()

        CoroutineScope(Dispatchers.IO).launch {
            val request = service.getPhotos()
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful && response.body() != null) {
                        result.value = response.body()
                    } else {
                        Timber.e("error")
                    }
                } catch (e: HttpException) {
                    Timber.e("http error")
                } catch (e: Throwable) {
                    Timber.e("error ${e.message}")
                }
            }
        }
        return result
    }
}