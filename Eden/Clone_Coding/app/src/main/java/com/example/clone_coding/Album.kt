package com.example.clone_coding

data class Album(
    var title: String? = "",
    var singer: String? = "",
    var coverimg: Int? = null,
    var songs: ArrayList<Song>? = null,
    var isSwitchOn : Boolean = false
)
