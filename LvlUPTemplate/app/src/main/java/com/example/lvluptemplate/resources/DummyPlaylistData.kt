package com.example.lvluptemplate.resources

import com.example.lvluptemplate.screen.Playlist

object DummyPlaylistData {

    val playlists = mutableListOf(

        Playlist(
            id = 1,
            name = "Daily Drive",
            tracksCount = 45
        ),

        Playlist(
            id = 2,
            name = "Cyberpunk Beats",
            tracksCount = 28
        ),

        Playlist(
            id = 3,
            name = "Chill Gaming",
            tracksCount = 60
        ),

        Playlist(
            id = 4,
            name = "Elektro Sessions",
            tracksCount = 19
        )
    )
}