package com.example.flo_clone_umc_bottom;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/flo_clone_umc_bottom/SongDatabase;", "Landroidx/room/RoomDatabase;", "()V", "songDao", "Lcom/example/flo_clone_umc_bottom/SongDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.flo_clone_umc_bottom.Song.class}, version = 1)
public abstract class SongDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.Nullable
    private static com.example.flo_clone_umc_bottom.SongDatabase instance;
    @org.jetbrains.annotations.NotNull
    public static final com.example.flo_clone_umc_bottom.SongDatabase.Companion Companion = null;
    
    public SongDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.flo_clone_umc_bottom.SongDao songDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/flo_clone_umc_bottom/SongDatabase$Companion;", "", "()V", "instance", "Lcom/example/flo_clone_umc_bottom/SongDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.Synchronized
        @org.jetbrains.annotations.Nullable
        public final synchronized com.example.flo_clone_umc_bottom.SongDatabase getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}