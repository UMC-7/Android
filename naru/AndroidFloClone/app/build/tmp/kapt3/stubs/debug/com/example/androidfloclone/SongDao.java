package com.example.androidfloclone;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tH\'J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0011\u001a\u00020\u0003H\'J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\'\u00a8\u0006\u0014"}, d2 = {"Lcom/example/androidfloclone/SongDao;", "", "delete", "", "song", "Lcom/example/androidfloclone/Song;", "getAlbumSongs", "", "albumIdx", "", "getLikedSong", "isLike", "", "getSong", "id", "getSongs", "insert", "unlikeAllSongs", "update", "updateIsLikeMyId", "app_debug"})
@androidx.room.Dao
public abstract interface SongDao {
    
    @androidx.room.Insert
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.Song song);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.Song song);
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.Song song);
    
    @androidx.room.Query(value = "SELECT * FROM SongTable")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.androidfloclone.Song> getSongs();
    
    @androidx.room.Query(value = "SELECT * FROM SongTable WHERE id = :id")
    @org.jetbrains.annotations.NotNull
    public abstract com.example.androidfloclone.Song getSong(int id);
    
    @androidx.room.Query(value = "UPDATE songtable SET isLike = :isLike WHERE id = :id")
    public abstract void updateIsLikeMyId(boolean isLike, int id);
    
    @androidx.room.Query(value = "UPDATE SongTable SET isLike = 0 WHERE isLike = 1")
    public abstract void unlikeAllSongs();
    
    @androidx.room.Query(value = "SELECT * FROM SongTable WHERE isLike = :isLike")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.androidfloclone.Song> getLikedSong(boolean isLike);
    
    @androidx.room.Query(value = "SELECT * FROM SongTable WHERE albumIdx = :albumIdx")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.androidfloclone.Song> getAlbumSongs(int albumIdx);
}