package com.example.androidfloclone;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/example/androidfloclone/SongDatabase;", "Landroidx/room/RoomDatabase;", "()V", "albumDao", "Lcom/example/androidfloclone/AlbumDao;", "songDao", "Lcom/example/androidfloclone/SongDao;", "userDao", "Lcom/example/androidfloclone/UserDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.androidfloclone.Song.class, com.example.androidfloclone.Album.class, com.example.androidfloclone.User.class, com.example.androidfloclone.Like.class}, version = 1)
public abstract class SongDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.Nullable
    private static com.example.androidfloclone.SongDatabase instance;
    @org.jetbrains.annotations.NotNull
    public static final com.example.androidfloclone.SongDatabase.Companion Companion = null;
    
    public SongDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.androidfloclone.AlbumDao albumDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.androidfloclone.SongDao songDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.androidfloclone.UserDao userDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/androidfloclone/SongDatabase$Companion;", "", "()V", "instance", "Lcom/example/androidfloclone/SongDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.Synchronized
        @org.jetbrains.annotations.Nullable
        public final synchronized com.example.androidfloclone.SongDatabase getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}