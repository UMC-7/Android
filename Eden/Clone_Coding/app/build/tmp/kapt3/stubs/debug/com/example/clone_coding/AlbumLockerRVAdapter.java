package com.example.clone_coding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0018\u0019B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\n2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\rH\u0007J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/clone_coding/AlbumLockerRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/clone_coding/AlbumLockerRVAdapter$ViewHolder;", "()V", "albums", "Ljava/util/ArrayList;", "Lcom/example/clone_coding/Album;", "myItemClickListener", "Lcom/example/clone_coding/AlbumLockerRVAdapter$MyItemClickListener;", "addAlbums", "", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "removeSong", "setMyItemClickListener", "itemClickListener", "MyItemClickListener", "ViewHolder", "app_debug"})
public final class AlbumLockerRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.clone_coding.AlbumLockerRVAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.example.clone_coding.Album> albums = null;
    private com.example.clone_coding.AlbumLockerRVAdapter.MyItemClickListener myItemClickListener;
    
    public AlbumLockerRVAdapter() {
        super();
    }
    
    public final void setMyItemClickListener(@org.jetbrains.annotations.NotNull
    com.example.clone_coding.AlbumLockerRVAdapter.MyItemClickListener itemClickListener) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.clone_coding.AlbumLockerRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.clone_coding.AlbumLockerRVAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void addAlbums(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.example.clone_coding.Album> albums) {
    }
    
    @android.annotation.SuppressLint(value = {"notifyDataSetChanged"})
    public final void removeSong(int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/clone_coding/AlbumLockerRVAdapter$MyItemClickListener;", "", "onRemoveSong", "", "position", "", "app_debug"})
    public static abstract interface MyItemClickListener {
        
        public abstract void onRemoveSong(int position);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/clone_coding/AlbumLockerRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/clone_coding/databinding/ItemLockerAlbumBinding;", "(Lcom/example/clone_coding/AlbumLockerRVAdapter;Lcom/example/clone_coding/databinding/ItemLockerAlbumBinding;)V", "getBinding", "()Lcom/example/clone_coding/databinding/ItemLockerAlbumBinding;", "bind", "", "album", "Lcom/example/clone_coding/Album;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.clone_coding.databinding.ItemLockerAlbumBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.example.clone_coding.databinding.ItemLockerAlbumBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.clone_coding.databinding.ItemLockerAlbumBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.clone_coding.Album album) {
        }
    }
}