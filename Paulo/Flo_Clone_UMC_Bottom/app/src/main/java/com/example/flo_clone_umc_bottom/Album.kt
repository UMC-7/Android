package com.example.flo_clone_umc_bottom

import java.util.ArrayList

data class Album(
    var title: String? = "",
    var singer: String? = "",
    var coverImg: Int? = null,
    var songs: ArrayList<Song>? = null
)
