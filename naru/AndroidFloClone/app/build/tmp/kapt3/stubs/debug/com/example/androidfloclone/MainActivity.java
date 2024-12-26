package com.example.androidfloclone;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010\'\u001a\u00020\u001dH\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\fH\u0002J\u0012\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u001dH\u0014J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u0019H\u0002J\u000e\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u000202R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u00063"}, d2 = {"Lcom/example/androidfloclone/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/androidfloclone/databinding/ActivityMainBinding;", "getBinding", "()Lcom/example/androidfloclone/databinding/ActivityMainBinding;", "setBinding", "(Lcom/example/androidfloclone/databinding/ActivityMainBinding;)V", "mediaPlayer", "Landroid/media/MediaPlayer;", "nowPos", "", "getNowPos", "()I", "setNowPos", "(I)V", "songDB", "Lcom/example/androidfloclone/SongDatabase;", "getSongDB", "()Lcom/example/androidfloclone/SongDatabase;", "setSongDB", "(Lcom/example/androidfloclone/SongDatabase;)V", "songs", "Ljava/util/ArrayList;", "Lcom/example/androidfloclone/Song;", "getSongs", "()Ljava/util/ArrayList;", "albumSongsReceived", "", "jsonData", "", "getJwt", "getPlayingSongPosition", "songId", "initBottomNavigation", "initClickListener", "initPlayList", "inputDummyAlbums", "inputDummySongs", "moveSong", "direct", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setMiniPlayer", "song", "setPlayerStatus", "isPlaying", "", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.androidfloclone.databinding.ActivityMainBinding binding;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.example.androidfloclone.Song> songs = null;
    public com.example.androidfloclone.SongDatabase songDB;
    private int nowPos = 0;
    @org.jetbrains.annotations.Nullable
    private android.media.MediaPlayer mediaPlayer;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.androidfloclone.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.databinding.ActivityMainBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.example.androidfloclone.Song> getSongs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.androidfloclone.SongDatabase getSongDB() {
        return null;
    }
    
    public final void setSongDB(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.SongDatabase p0) {
    }
    
    public final int getNowPos() {
        return 0;
    }
    
    public final void setNowPos(int p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setPlayerStatus(boolean isPlaying) {
    }
    
    private final void initBottomNavigation() {
    }
    
    private final int getPlayingSongPosition(int songId) {
        return 0;
    }
    
    private final void initPlayList() {
    }
    
    private final void initClickListener() {
    }
    
    private final void moveSong(int direct) {
    }
    
    private final void setMiniPlayer(com.example.androidfloclone.Song song) {
    }
    
    public final void albumSongsReceived(@org.jetbrains.annotations.NotNull
    java.lang.String jsonData) {
    }
    
    private final java.lang.String getJwt() {
        return null;
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    private final void inputDummyAlbums() {
    }
    
    private final void inputDummySongs() {
    }
}