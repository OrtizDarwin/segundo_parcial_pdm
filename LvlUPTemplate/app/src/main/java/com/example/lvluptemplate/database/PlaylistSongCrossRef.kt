package com.example.lvluptemplate.database

import androidx.room.Entity

@Entity(
    primaryKeys = ["playlistId", "songId"]
)
data class PlaylistSongCrossRef(

    val playlistId: String,
    val songId: String
)