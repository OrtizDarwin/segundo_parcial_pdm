package com.example.lvluptemplate.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SongEntity(

    @PrimaryKey
    val id: String,

    val title: String,
    val artist: String,
    val album: String,
    val cover: String,
    val genreId: String
)