package com.example.androidfloclone;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010\'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\fH\u0002J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020#H\u0014J\b\u0010/\u001a\u00020#H\u0014J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0019H\u0002J\u000e\u00105\u001a\u00020#2\u0006\u00106\u001a\u000202J\b\u00107\u001a\u00020#H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00060\u001dR\u00020\u0000X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u00069"}, d2 = {"Lcom/example/androidfloclone/SongActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/androidfloclone/databinding/ActivitySongBinding;", "getBinding", "()Lcom/example/androidfloclone/databinding/ActivitySongBinding;", "setBinding", "(Lcom/example/androidfloclone/databinding/ActivitySongBinding;)V", "mediaPlayer", "Landroid/media/MediaPlayer;", "nowPos", "", "getNowPos", "()I", "setNowPos", "(I)V", "songDB", "Lcom/example/androidfloclone/SongDatabase;", "getSongDB", "()Lcom/example/androidfloclone/SongDatabase;", "setSongDB", "(Lcom/example/androidfloclone/SongDatabase;)V", "songs", "Ljava/util/ArrayList;", "Lcom/example/androidfloclone/Song;", "getSongs", "()Ljava/util/ArrayList;", "timer", "Lcom/example/androidfloclone/SongActivity$Timer;", "getTimer", "()Lcom/example/androidfloclone/SongActivity$Timer;", "setTimer", "(Lcom/example/androidfloclone/SongActivity$Timer;)V", "albumSongsReceived", "", "getPlayingSongPosition", "songId", "initClickListener", "initPlayList", "initSong", "moveSong", "direct", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "setLike", "isLike", "", "setPlayer", "song", "setPlayerStatus", "isPlaying", "startTimer", "Timer", "app_debug"})
public final class SongActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.androidfloclone.databinding.ActivitySongBinding binding;
    public com.example.androidfloclone.SongActivity.Timer timer;
    @org.jetbrains.annotations.Nullable
    private android.media.MediaPlayer mediaPlayer;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.example.androidfloclone.Song> songs = null;
    public com.example.androidfloclone.SongDatabase songDB;
    private int nowPos = 0;
    
    public SongActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.androidfloclone.databinding.ActivitySongBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.databinding.ActivitySongBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.androidfloclone.SongActivity.Timer getTimer() {
        return null;
    }
    
    public final void setTimer(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.SongActivity.Timer p0) {
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
    
    private final void albumSongsReceived() {
    }
    
    private final void initPlayList() {
    }
    
    private final void initClickListener() {
    }
    
    private final void initSong() {
    }
    
    private final void setLike(boolean isLike) {
    }
    
    private final void moveSong(int direct) {
    }
    
    private final int getPlayingSongPosition(int songId) {
        return 0;
    }
    
    private final void setPlayer(com.example.androidfloclone.Song song) {
    }
    
    public final void setPlayerStatus(boolean isPlaying) {
    }
    
    private final void startTimer() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/androidfloclone/SongActivity$Timer;", "Ljava/lang/Thread;", "playTime", "", "isPlaying", "", "(Lcom/example/androidfloclone/SongActivity;IZ)V", "()Z", "setPlaying", "(Z)V", "mills", "", "second", "run", "", "app_debug"})
    public final class Timer extends java.lang.Thread {
        private final int playTime = 0;
        private boolean isPlaying;
        private int second = 0;
        private float mills = 0.0F;
        
        public Timer(int playTime, boolean isPlaying) {
            super();
        }
        
        public final boolean isPlaying() {
            return false;
        }
        
        public final void setPlaying(boolean p0) {
        }
        
        @java.lang.Override
        public void run() {
        }
    }
}