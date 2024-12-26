package com.example.flo_clone_umc_bottom;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/flo_clone_umc_bottom/SongDao;", "", "delete", "", "song", "Lcom/example/flo_clone_umc_bottom/Song;", "getSong", "", "id", "", "insert", "update", "app_debug"})
@androidx.room.Dao
public abstract interface SongDao {
    
    @androidx.room.Insert
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.flo_clone_umc_bottom.Song song);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.NotNull
    com.example.flo_clone_umc_bottom.Song song);
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.example.flo_clone_umc_bottom.Song song);
    
    @androidx.room.Query(value = "SELECT * FROM SongTable")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.flo_clone_umc_bottom.Song> getSong();
    
    @androidx.room.Query(value = "SELECT * FROM SongTable WHERE id = :id")
    @org.jetbrains.annotations.NotNull
    public abstract com.example.flo_clone_umc_bottom.Song getSong(int id);
}