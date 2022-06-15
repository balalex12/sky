package com.example.sky.repository

import androidx.lifecycle.LiveData
import com.example.sky.data.SkyDao
import com.example.sky.model.Sky

class SkyRepository(private val skyDao: SkyDao) {
    val getAllData: LiveData<List<Sky>> = skyDao.getAlData()

    suspend fun addSky(sky: Sky) {
        skyDao.addSky(sky)
    }

    suspend fun updateSky(sky: Sky) {
        skyDao.updateSky(sky)
    }

    suspend fun deleteSky(sky: Sky) {
        skyDao.deleteSky(sky)
    }
}