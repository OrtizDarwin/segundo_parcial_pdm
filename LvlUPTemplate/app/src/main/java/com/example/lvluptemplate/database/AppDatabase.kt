package com.example.lvluptemplate.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        PlaylistEntity::class,
        SongEntity::class,
        GenreEntity::class
    ],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun playlistDao(): PlaylistDao
}