package com.example.myproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myproject.model.Photo
import com.example.myproject.repository.PhotoRepository

class PhotoViewModel(private val repository: PhotoRepository) : ViewModel() {
    private lateinit var liveData: LiveData<List<Photo>>

    fun getLiveData(): LiveData<List<Photo>> {
        liveData = repository.fetchData()
        return liveData
    }
}