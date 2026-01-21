package com.spoons.popparazzi.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.spoons.popparazzi.core.database.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user LIMIT 1")
    fun select(): UserEntity?
}