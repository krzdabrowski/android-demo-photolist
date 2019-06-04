package com.example.myproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.R
import com.example.myproject.viewmodel.PhotoViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(), PhotoAdapter.ItemListener {

    private val photoVm: PhotoViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val liveData = photoVm.getLiveData()
        liveData.observe(this, Observer { data -> recyclerView.adapter = PhotoAdapter(context!!, data, this) })
    }

    override fun navigateTo(position: Int) {
        findNavController().navigate(R.id.navigate_to_detail)
    }
}