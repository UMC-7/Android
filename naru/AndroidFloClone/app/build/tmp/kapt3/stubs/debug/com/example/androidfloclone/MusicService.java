package com.example.androidfloclone;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0003\u00a8\u0006\u0010"}, d2 = {"Lcom/example/androidfloclone/MusicService;", "Landroid/app/Service;", "()V", "createNotificationChannel", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onStartCommand", "", "flags", "startId", "showNotification", "Companion", "app_debug"})
public final class MusicService extends android.app.Service {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "MusicService";
    @org.jetbrains.annotations.NotNull
    public static final com.example.androidfloclone.MusicService.Companion Companion = null;
    
    public MusicService() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void showNotification() {
    }
    
    private final void createNotificationChannel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/androidfloclone/MusicService$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}