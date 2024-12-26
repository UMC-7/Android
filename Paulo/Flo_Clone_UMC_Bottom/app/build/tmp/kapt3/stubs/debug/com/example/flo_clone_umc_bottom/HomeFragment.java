package com.example.flo_clone_umc_bottom;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/flo_clone_umc_bottom/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "albumDataListener", "Lcom/example/flo_clone_umc_bottom/AlbumRVAdapter$MyItemClickListener;", "albumDatas", "Ljava/util/ArrayList;", "Lcom/example/flo_clone_umc_bottom/Album;", "binding", "Lcom/example/flo_clone_umc_bottom/databinding/FragmentHomeBinding;", "getBinding", "()Lcom/example/flo_clone_umc_bottom/databinding/FragmentHomeBinding;", "setBinding", "(Lcom/example/flo_clone_umc_bottom/databinding/FragmentHomeBinding;)V", "handler", "Landroid/os/Handler;", "timer", "Ljava/util/Timer;", "changeAlbumFragment", "", "album", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "startAutoSlide", "adapter", "Lcom/example/flo_clone_umc_bottom/HomeBannerVPAdapter;", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final java.util.Timer timer = null;
    @org.jetbrains.annotations.NotNull
    private final android.os.Handler handler = null;
    public com.example.flo_clone_umc_bottom.databinding.FragmentHomeBinding binding;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.example.flo_clone_umc_bottom.Album> albumDatas;
    @org.jetbrains.annotations.Nullable
    private com.example.flo_clone_umc_bottom.AlbumRVAdapter.MyItemClickListener albumDataListener;
    
    public HomeFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.flo_clone_umc_bottom.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.flo_clone_umc_bottom.databinding.FragmentHomeBinding p0) {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void changeAlbumFragment(com.example.flo_clone_umc_bottom.Album album) {
    }
    
    private final void startAutoSlide(com.example.flo_clone_umc_bottom.HomeBannerVPAdapter adapter) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
}