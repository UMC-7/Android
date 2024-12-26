package com.example.flo_clone_umc_bottom;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0014J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/flo_clone_umc_bottom/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/flo_clone_umc_bottom/databinding/ActivityMainBinding;", "getBinding", "()Lcom/example/flo_clone_umc_bottom/databinding/ActivityMainBinding;", "setBinding", "(Lcom/example/flo_clone_umc_bottom/databinding/ActivityMainBinding;)V", "getResultText", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getGetResultText", "()Landroidx/activity/result/ActivityResultLauncher;", "gson", "Lcom/google/gson/Gson;", "song", "Lcom/example/flo_clone_umc_bottom/Song;", "initBottomNavigation", "", "inputDummySongs", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setMiniPlayer", "updateMiniPlayer", "album", "Lcom/example/flo_clone_umc_bottom/Album;", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.flo_clone_umc_bottom.databinding.ActivityMainBinding binding;
    @org.jetbrains.annotations.NotNull
    private com.example.flo_clone_umc_bottom.Song song;
    @org.jetbrains.annotations.NotNull
    private com.google.gson.Gson gson;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getResultText = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo_clone_umc_bottom.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.flo_clone_umc_bottom.databinding.ActivityMainBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getGetResultText() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initBottomNavigation() {
    }
    
    private final void setMiniPlayer(com.example.flo_clone_umc_bottom.Song song) {
    }
    
    public final void updateMiniPlayer(@org.jetbrains.annotations.NotNull
    com.example.flo_clone_umc_bottom.Album album) {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    private final void inputDummySongs() {
    }
}