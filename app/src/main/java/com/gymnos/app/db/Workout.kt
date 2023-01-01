package com.gymnos.app.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workout(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val tag: String,
    val weight: Int,
    val time: Long,
)
