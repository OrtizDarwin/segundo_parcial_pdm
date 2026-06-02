package com.example.lvluptemplate.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlaylistEntity(

    @PrimaryKey
    val id: String,

    val name: String,
    val description: String
)