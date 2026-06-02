package com.example.lvluptemplate.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlaylistDao {

    @Insert
    suspend fun insertPlaylist(
        playlist: PlaylistEntity
    )

    @Query("SELECT * FROM PlaylistEntity")
    suspend fun getAllPlaylists(): List<PlaylistEntity>
}