package com.gymnos.app.repository

import com.gymnos.app.db.Workout
import com.gymnos.app.db.WorkoutDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted.Companion.Lazily
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkoutRepository @Inject constructor(
    private val workoutDao: WorkoutDao
) : WorkoutDao by workoutDao {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val workoutFlow by lazy {
        workoutDao.getWorkouts()
            .shareIn(coroutineScope, Lazily, replay = 1)
    }

    override fun getWorkouts(): Flow<List<Workout>> = workoutFlow
}