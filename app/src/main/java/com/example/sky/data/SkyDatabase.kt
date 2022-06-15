package com.example.sky.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sky.model.Sky

@Database(entities = [Sky::class], version = 1, exportSchema = false)
abstract class SkyDatabase: RoomDatabase() {
    abstract fun SkyDao(): SkyDao

    companion object {
        @Volatile
        private var INSTANCE: SkyDatabase? = null

        fun getDatabase(context: android.content.Context): SkyDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SkyDatabase::class.java,
                    "sky_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
