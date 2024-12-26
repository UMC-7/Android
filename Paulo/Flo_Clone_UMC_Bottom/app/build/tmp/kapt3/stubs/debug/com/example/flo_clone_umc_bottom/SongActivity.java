package com.example.flo_clone_umc_bottom;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001cH\u0014J\b\u0010!\u001a\u00020\u001cH\u0014J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u000eJ\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010\'\u001a\u00020\u000eJ\b\u0010(\u001a\u00020\u001cH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00060\u0016R\u00020\u0000X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006*"}, d2 = {"Lcom/example/flo_clone_umc_bottom/SongActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/flo_clone_umc_bottom/databinding/ActivitySongBinding;", "getBinding", "()Lcom/example/flo_clone_umc_bottom/databinding/ActivitySongBinding;", "setBinding", "(Lcom/example/flo_clone_umc_bottom/databinding/ActivitySongBinding;)V", "gson", "Lcom/google/gson/Gson;", "mediaPlayer", "Landroid/media/MediaPlayer;", "repeat", "", "song", "Lcom/example/flo_clone_umc_bottom/Song;", "getSong", "()Lcom/example/flo_clone_umc_bottom/Song;", "setSong", "(Lcom/example/flo_clone_umc_bottom/Song;)V", "timer", "Lcom/example/flo_clone_umc_bottom/SongActivity$Timer;", "getTimer", "()Lcom/example/flo_clone_umc_bottom/SongActivity$Timer;", "setTimer", "(Lcom/example/flo_clone_umc_bottom/SongActivity$Timer;)V", "initSong", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "setPlayer", "setPlayerStatus", "isPlaying", "setRandomStatus", "setRepeatStatus", "isRepeating", "startTimer", "Timer", "app_debug"})
public final class SongActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.flo_clone_umc_bottom.databinding.ActivitySongBinding binding;
    public com.example.flo_clone_umc_bottom.Song song;
    public com.example.flo_clone_umc_bottom.SongActivity.Timer timer;
    @org.jetbrains.annotations.Nullable
    private android.media.MediaPlayer mediaPlayer;
    @org.jetbrains.annotations.NotNull
    private com.google.gson.Gson gson;
    private boolean repeat = false;
    
    public SongActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo_clone_umc_bottom.databinding.ActivitySongBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.flo_clone_umc_bottom.databinding.ActivitySongBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo_clone_umc_bottom.Song getSong() {
        return null;
    }
    
    public final void setSong(@org.jetbrains.annotations.NotNull
    com.example.flo_clone_umc_bottom.Song p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo_clone_umc_bottom.SongActivity.Timer getTimer() {
        return null;
    }
    
    public final void setTimer(@org.jetbrains.annotations.NotNull
    com.example.flo_clone_umc_bottom.SongActivity.Timer p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initSong() {
    }
    
    private final void setPlayer(com.example.flo_clone_umc_bottom.Song song) {
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
    
    public final void setRepeatStatus(boolean isRepeating) {
    }
    
    public final void setRandomStatus(boolean isPlaying) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/flo_clone_umc_bottom/SongActivity$Timer;", "Ljava/lang/Thread;", "playTime", "", "isPlaying", "", "(Lcom/example/flo_clone_umc_bottom/SongActivity;IZ)V", "()Z", "setPlaying", "(Z)V", "mills", "", "second", "run", "", "app_debug"})
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