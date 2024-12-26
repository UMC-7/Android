package com.example.androidfloclone

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SongDao {
    @Insert
    fun insert(song: Song)

    @Update
    fun update(song: Song)

    @Delete
    fun delete(song: Song)

    @Query("SELECT * FROM SongTable")
    fun getSongs(): List<Song>

    @Query("SELECT * FROM SongTable WHERE id = :id")
    fun getSong(id: Int): Song

    @Query("UPDATE songtable SET isLike = :isLike WHERE id = :id")
    fun updateIsLikeMyId(isLike: Boolean, id: Int)

    @Query("UPDATE SongTable SET isLike = 0 WHERE isLike = 1")
    fun unlikeAllSongs()

    @Query("SELECT * FROM SongTable WHERE isLike = :isLike")
    fun getLikedSong(isLike: Boolean): List<Song>

    @Query("SELECT * FROM SongTable WHERE albumIdx = :albumIdx")
    fun getAlbumSongs(albumIdx: Int): List<Song>
}