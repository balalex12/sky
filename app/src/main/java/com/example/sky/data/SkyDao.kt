package com.example.sky.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sky.model.Sky

@Dao
interface SkyDao {

    @Query("SELECT * FROM SKY")
    fun getAlData(): LiveData<List<Sky>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSky(sky: Sky)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateSky(sky: Sky)

    @Delete
    suspend fun deleteSky(sky: Sky)
}