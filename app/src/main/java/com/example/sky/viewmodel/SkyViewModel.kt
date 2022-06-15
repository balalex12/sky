package com.example.sky.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sky.data.SkyDatabase
import com.example.sky.model.Sky
import com.example.sky.repository.SkyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SkyViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<Sky>>

    private val repository: SkyRepository

    init {
        val skyDao = SkyDatabase.getDatabase(application).SkyDao()
        repository = SkyRepository(skyDao)
        getAllData = repository.getAllData
    }

    fun addSky(sky: Sky) {
        viewModelScope.launch(Dispatchers.IO) { repository.addSky(sky) }
    }

    fun updateSky(sky: Sky) {
        viewModelScope.launch(Dispatchers.IO) { repository.updateSky(sky) }
    }

    fun deleteSky(sky: Sky) {
        viewModelScope.launch(Dispatchers.IO) { repository.deleteSky(sky) }
    }
}