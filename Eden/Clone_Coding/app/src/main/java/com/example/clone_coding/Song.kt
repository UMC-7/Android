package com.example.clone_coding

//제목, 가수, 현재 재생 시간, 재생 시간, 재생 여부
data class Song(
    val title : String = "",
    val singer : String = "",
    var currentTime : Int = 0,
    var playTime : Int =1,  //ArithmeticException 방지
    var isPlaying : Boolean = false,
    var music : String = ""
)
