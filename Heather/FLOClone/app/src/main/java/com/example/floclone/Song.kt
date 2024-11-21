package com.example.floclone

data class Song(
    val title : String = "",
    val singer : String = "",
    var second: Int = 0,
    var playTime: Int = 0,
    var isPlaying: Boolean = false,
    var music: String = "",
    var coverImg: Int? = null,
    var isSwitchOn: Boolean = false  // 스위치 상태를 저장할 변수
)
