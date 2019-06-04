package com.example.myproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.R
import com.example.myproject.di.networkModule
import com.example.myproject.di.repositoryModule
import com.example.myproject.di.viewModelModule
import com.example.myproject.model.Photo
import com.example.myproject.viewmodel.PhotoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val photoVm: PhotoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger()
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        val liveData = photoVm.getLiveData()
        liveData.observe(this, Observer { data -> recyclerView.adapter = PhotoAdapter(this, data) })
    }
}
