package com.example.clone_coding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/example/clone_coding/SongDatabase;", "Landroidx/room/RoomDatabase;", "()V", "albumDao", "Lcom/example/clone_coding/AlbumDao;", "songDao", "Lcom/example/clone_coding/SongDao;", "userDao", "Lcom/example/clone_coding/UserDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.clone_coding.Song.class, com.example.clone_coding.User.class, com.example.clone_coding.Album.class, com.example.clone_coding.Like.class}, version = 1)
public abstract class SongDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.Nullable
    private static com.example.clone_coding.SongDatabase instance;
    @org.jetbrains.annotations.NotNull
    public static final com.example.clone_coding.SongDatabase.Companion Companion = null;
    
    public SongDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.clone_coding.SongDao songDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.clone_coding.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.clone_coding.AlbumDao albumDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/clone_coding/SongDatabase$Companion;", "", "()V", "instance", "Lcom/example/clone_coding/SongDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.Synchronized
        @org.jetbrains.annotations.Nullable
        public final synchronized com.example.clone_coding.SongDatabase getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}