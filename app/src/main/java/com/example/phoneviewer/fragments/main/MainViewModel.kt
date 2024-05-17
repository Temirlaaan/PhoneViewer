package com.example.phoneviewer.fragments.main

import android.graphics.ColorSpace
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phoneviewer.fragments.main.model.Model
import com.example.phoneviewer.network.ApiServices
import com.example.phoneviewer.network.MainDTO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val apiServices: ApiServices
) : ViewModel() {

    private val _basketDetailData = MutableLiveData<List<Model>>()
    val basketDetailData: LiveData<List<Model>>
        get() = _basketDetailData

    private val mainObject = mutableListOf<Model>()

    fun onViewCreated() {
        viewModelScope.launch {
            try {
                val response = apiServices.getMainMovies()
                if (response.isSuccessful) {
                    response.body()?.data?.items?.forEach {
                        mainObject.add(
                            Model(
                                id = it.id,
                                title = it.title,
                                photos = it.photos.firstOrNull() ?: ""
                            )
                        )
                    }
                    _basketDetailData.postValue(mainObject)
                } else {
                    Log.e("MainViewModel", "API Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("MainViewModel", "API Error: ${e.message}", e)
            }
        }
    }
}
