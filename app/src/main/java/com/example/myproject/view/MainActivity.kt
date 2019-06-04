package com.example.myproject.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myproject.R
import com.example.myproject.di.networkModule
import com.example.myproject.di.repositoryModule
import com.example.myproject.di.viewModelModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.fragment_host) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger()
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }

        setupActionBarWithNavController(navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}