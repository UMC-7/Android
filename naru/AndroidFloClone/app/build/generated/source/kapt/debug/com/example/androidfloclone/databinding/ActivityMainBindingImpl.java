package com.example.androidfloclone.databinding;
import com.example.androidfloclone.R;
import com.example.androidfloclone.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.main_frm, 1);
        sViewsWithIds.put(R.id.main_progress_sb, 2);
        sViewsWithIds.put(R.id.main_player_cl, 3);
        sViewsWithIds.put(R.id.main_miniplayer_title_tv, 4);
        sViewsWithIds.put(R.id.main_miniplayer_singer_tv, 5);
        sViewsWithIds.put(R.id.main_previous_btn, 6);
        sViewsWithIds.put(R.id.main_miniplayer_btn, 7);
        sViewsWithIds.put(R.id.main_pause_btn, 8);
        sViewsWithIds.put(R.id.main_next_btn, 9);
        sViewsWithIds.put(R.id.main_bnv, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.bottomnavigation.BottomNavigationView) bindings[10]
            , (android.widget.FrameLayout) bindings[1]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.SeekBar) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}