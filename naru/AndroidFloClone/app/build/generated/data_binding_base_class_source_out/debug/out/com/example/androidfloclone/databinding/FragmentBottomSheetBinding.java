// Generated by data binding compiler. Do not edit!
package com.example.androidfloclone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.androidfloclone.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentBottomSheetBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomSheetDeleteBtn;

  @NonNull
  public final LinearLayout bottomSheetMylistBtn;

  @NonNull
  public final LinearLayout bottomSheetPlayBtn;

  @NonNull
  public final LinearLayout bottomSheetPlaylistBtn;

  @NonNull
  public final LinearLayout buttonRow;

  protected FragmentBottomSheetBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout bottomSheetDeleteBtn, LinearLayout bottomSheetMylistBtn,
      LinearLayout bottomSheetPlayBtn, LinearLayout bottomSheetPlaylistBtn,
      LinearLayout buttonRow) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomSheetDeleteBtn = bottomSheetDeleteBtn;
    this.bottomSheetMylistBtn = bottomSheetMylistBtn;
    this.bottomSheetPlayBtn = bottomSheetPlayBtn;
    this.bottomSheetPlaylistBtn = bottomSheetPlaylistBtn;
    this.buttonRow = buttonRow;
  }

  @NonNull
  public static FragmentBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentBottomSheetBinding>inflateInternal(inflater, R.layout.fragment_bottom_sheet, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentBottomSheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentBottomSheetBinding>inflateInternal(inflater, R.layout.fragment_bottom_sheet, null, false, component);
  }

  public static FragmentBottomSheetBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentBottomSheetBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentBottomSheetBinding)bind(component, view, R.layout.fragment_bottom_sheet);
  }
}