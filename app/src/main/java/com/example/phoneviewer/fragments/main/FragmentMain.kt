package com.example.phoneviewer.fragments.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phoneviewer.R
import com.example.phoneviewer.fragments.main.detail.MainDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentMain : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        observeViewModel()
        viewModel.onViewCreated()
    }

    private fun setupView(view: View) {
        recyclerView = view.findViewById<RecyclerView>(R.id.mainRcV)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeViewModel() {
        viewModel.basketDetailData.observe(viewLifecycleOwner) { mainObject ->
            recyclerView.adapter = MainRecyclerAdapter(
                item = mainObject,
                onItemClickListener = { main ->
                    val intent = Intent(activity, MainDetailActivity::class.java)
                    intent.putExtra("ARG_POP", main)
                    startActivity(intent)
                }
            )
        }
    }
}