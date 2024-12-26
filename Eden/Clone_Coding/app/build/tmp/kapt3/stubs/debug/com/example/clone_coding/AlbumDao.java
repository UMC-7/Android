package com.example.clone_coding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u001f\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\'\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0005H\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\'J\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\'\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/example/clone_coding/AlbumDao;", "", "deleteAll", "", "disLikedAlbum", "", "userId", "albumId", "(II)Ljava/lang/Integer;", "getAlbums", "", "Lcom/example/clone_coding/Album;", "getLikedAlbums", "insert", "album", "isLikedAlbum", "likeAlbum", "like", "Lcom/example/clone_coding/Like;", "app_debug"})
@androidx.room.Dao
public abstract interface AlbumDao {
    
    @androidx.room.Insert(onConflict = 5)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.clone_coding.Album album);
    
    @androidx.room.Query(value = "SELECT * FROM AlbumTable")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.clone_coding.Album> getAlbums();
    
    @androidx.room.Insert
    public abstract void likeAlbum(@org.jetbrains.annotations.NotNull
    com.example.clone_coding.Like like);
    
    @androidx.room.Query(value = "SELECT id FROM LikeTable WHERE userId = :userId AND albumId = :albumId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Integer isLikedAlbum(int userId, int albumId);
    
    @androidx.room.Query(value = "DELETE FROM LikeTable WHERE userId = :userId AND albumId = :albumId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Integer disLikedAlbum(int userId, int albumId);
    
    @androidx.room.Query(value = "SELECT AT.* FROM LikeTable as LT LEFT JOIN AlbumTable as AT ON LT.albumId = AT.id WHERE LT.userId = :userId")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.clone_coding.Album> getLikedAlbums(int userId);
    
    @androidx.room.Query(value = "DELETE FROM AlbumTable")
    public abstract void deleteAll();
}