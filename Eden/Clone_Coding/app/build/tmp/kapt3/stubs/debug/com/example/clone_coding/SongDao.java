package com.example.clone_coding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\'\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\'J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/example/clone_coding/SongDao;", "", "delete", "", "song", "Lcom/example/clone_coding/Song;", "getFirstSongId", "", "()Ljava/lang/Integer;", "getLikedSongs", "", "isLike", "", "getSong", "id", "getSongs", "insert", "update", "updateIsLikeById", "app_debug"})
@androidx.room.Dao
public abstract interface SongDao {
    
    @androidx.room.Insert
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.clone_coding.Song song);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.NotNull
    com.example.clone_coding.Song song);
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.example.clone_coding.Song song);
    
    @androidx.room.Query(value = "SELECT * FROM SongTable")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.clone_coding.Song> getSongs();
    
    @androidx.room.Query(value = "SELECT * FROM SongTable WHERE id = :id")
    @org.jetbrains.annotations.NotNull
    public abstract com.example.clone_coding.Song getSong(int id);
    
    @androidx.room.Query(value = "SELECT id FROM SongTable LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Integer getFirstSongId();
    
    @androidx.room.Query(value = "UPDATE SongTable SET isLike= :isLike WHERE id = :id")
    public abstract void updateIsLikeById(boolean isLike, int id);
    
    @androidx.room.Query(value = "SELECT * FROM SongTable WHERE isLike = :isLike")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.clone_coding.Song> getLikedSongs(boolean isLike);
}