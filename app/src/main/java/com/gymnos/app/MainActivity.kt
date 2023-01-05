package com.gymnos.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gymnos.app.ui.Route
import com.gymnos.app.ui.add_workout.AddWorkout
import com.gymnos.app.ui.workout_list.WorkoutList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.WorkoutList.name
    ) {
        composable(Route.WorkoutList.name) {
            WorkoutList()
        }
        composable(Route.AddWorkout.name) {
            AddWorkout()
        }
    }
}