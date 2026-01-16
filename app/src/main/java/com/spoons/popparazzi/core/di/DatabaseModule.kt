package com.spoons.popparazzi.core.di

import android.content.Context
import androidx.room.Room
import com.spoons.popparazzi.core.config.DatabaseConfig
import com.spoons.popparazzi.core.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DatabaseConfig.DB_NAME
    ).build()

    @Provides
    fun provideUserDao(db: AppDatabase) = db.userDao()

}
