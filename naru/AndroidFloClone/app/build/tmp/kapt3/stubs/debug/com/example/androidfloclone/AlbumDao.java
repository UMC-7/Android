package com.example.androidfloclone;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bH\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001f\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\'J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0016"}, d2 = {"Lcom/example/androidfloclone/AlbumDao;", "", "delete", "", "album", "Lcom/example/androidfloclone/Album;", "disLikedAlbum", "userId", "", "albumId", "getAlbum", "id", "getAlbums", "", "getLikedAlbums", "insert", "isLikedAlbum", "(II)Ljava/lang/Integer;", "likeAlbum", "like", "Lcom/example/androidfloclone/Like;", "update", "app_debug"})
@androidx.room.Dao
public abstract interface AlbumDao {
    
    @androidx.room.Insert
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.Album album);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.Album album);
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.Album album);
    
    @androidx.room.Query(value = "SELECT * FROM AlbumTable")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.androidfloclone.Album> getAlbums();
    
    @androidx.room.Query(value = "SELECT * FROM AlbumTable WHERE id = :id")
    @org.jetbrains.annotations.NotNull
    public abstract com.example.androidfloclone.Album getAlbum(int id);
    
    @androidx.room.Insert
    public abstract void likeAlbum(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.Like like);
    
    @androidx.room.Query(value = "SELECT id FROM LikeTable WHERE userId = :userId AND albumId = :albumId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Integer isLikedAlbum(int userId, int albumId);
    
    @androidx.room.Query(value = "DELETE FROM LikeTable WHERE userId = :userId AND albumId = :albumId")
    public abstract void disLikedAlbum(int userId, int albumId);
    
    @androidx.room.Query(value = "SELECT AT.* FROM LikeTable as LT LEFT JOIN AlbumTable as AT ON LT.albumId = AT.id WHERE LT.userId = :userId")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.androidfloclone.Album> getLikedAlbums(int userId);
}