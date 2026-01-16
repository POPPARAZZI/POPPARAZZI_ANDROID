package com.spoons.popparazzi.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spoons.popparazzi.core.config.DatabaseConfig
import com.spoons.popparazzi.core.database.dao.UserDao
import com.spoons.popparazzi.core.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = DatabaseConfig.DB_VERSION, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}