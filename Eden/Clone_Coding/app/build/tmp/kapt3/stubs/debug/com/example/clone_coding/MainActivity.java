package com.example.clone_coding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0014J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/clone_coding/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "albumCoverimg", "", "binding", "Lcom/example/clone_coding/databinding/ActivityMainBinding;", "getBinding", "()Lcom/example/clone_coding/databinding/ActivityMainBinding;", "setBinding", "(Lcom/example/clone_coding/databinding/ActivityMainBinding;)V", "gson", "Lcom/google/gson/Gson;", "song", "Lcom/example/clone_coding/Song;", "initBottomNavigation", "", "inputDummyAlbums", "inputDummySongs", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setAlbumcover", "resImg", "setMiniPlayer", "setNewSong", "newSong", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.clone_coding.databinding.ActivityMainBinding binding;
    @org.jetbrains.annotations.NotNull
    private com.example.clone_coding.Song song;
    @org.jetbrains.annotations.NotNull
    private com.google.gson.Gson gson;
    private int albumCoverimg = 0;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.clone_coding.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.clone_coding.databinding.ActivityMainBinding p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initBottomNavigation() {
    }
    
    private final void setMiniPlayer(com.example.clone_coding.Song song) {
    }
    
    private final void inputDummySongs() {
    }
    
    private final void inputDummyAlbums() {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    public final void setNewSong(@org.jetbrains.annotations.NotNull
    com.example.clone_coding.Song newSong) {
    }
    
    public final void setAlbumcover(int resImg) {
    }
}