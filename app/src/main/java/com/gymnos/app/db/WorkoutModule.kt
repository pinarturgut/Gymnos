package com.gymnos.app.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object WorkoutModule {

    @[Provides Reusable]
    fun providesWorkoutDao(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, WorkoutDatabase::class.java, "workout_db")
            .build().dao()
}