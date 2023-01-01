package com.gymnos.app.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Workout::class], version = 1)
abstract class WorkoutDatabase : RoomDatabase() {
    abstract fun dao(): WorkoutDao
}