// Generated by view binder compiler. Do not edit!
package com.example.flo_clone_umc_bottom.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.example.flo_clone_umc_bottom.R;
import com.google.android.material.tabs.TabLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLockerBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TabLayout lockerContentTb;

  @NonNull
  public final ViewPager2 lockerContentVp;

  @NonNull
  public final TextView lockerLoginTv;

  @NonNull
  public final ImageView lockerPlayAllImgIv;

  @NonNull
  public final TextView lockerPlayAllTv;

  @NonNull
  public final ImageView lockerSelectAllImgIv;

  @NonNull
  public final TextView lockerSelectAllTv;

  @NonNull
  public final TextView lockerTitleTv;

  private FragmentLockerBinding(@NonNull ConstraintLayout rootView,
      @NonNull TabLayout lockerContentTb, @NonNull ViewPager2 lockerContentVp,
      @NonNull TextView lockerLoginTv, @NonNull ImageView lockerPlayAllImgIv,
      @NonNull TextView lockerPlayAllTv, @NonNull ImageView lockerSelectAllImgIv,
      @NonNull TextView lockerSelectAllTv, @NonNull TextView lockerTitleTv) {
    this.rootView = rootView;
    this.lockerContentTb = lockerContentTb;
    this.lockerContentVp = lockerContentVp;
    this.lockerLoginTv = lockerLoginTv;
    this.lockerPlayAllImgIv = lockerPlayAllImgIv;
    this.lockerPlayAllTv = lockerPlayAllTv;
    this.lockerSelectAllImgIv = lockerSelectAllImgIv;
    this.lockerSelectAllTv = lockerSelectAllTv;
    this.lockerTitleTv = lockerTitleTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLockerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLockerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_locker, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLockerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.locker_content_tb;
      TabLayout lockerContentTb = ViewBindings.findChildViewById(rootView, id);
      if (lockerContentTb == null) {
        break missingId;
      }

      id = R.id.locker_content_vp;
      ViewPager2 lockerContentVp = ViewBindings.findChildViewById(rootView, id);
      if (lockerContentVp == null) {
        break missingId;
      }

      id = R.id.locker_login_tv;
      TextView lockerLoginTv = ViewBindings.findChildViewById(rootView, id);
      if (lockerLoginTv == null) {
        break missingId;
      }

      id = R.id.locker_play_all_img_iv;
      ImageView lockerPlayAllImgIv = ViewBindings.findChildViewById(rootView, id);
      if (lockerPlayAllImgIv == null) {
        break missingId;
      }

      id = R.id.locker_play_all_tv;
      TextView lockerPlayAllTv = ViewBindings.findChildViewById(rootView, id);
      if (lockerPlayAllTv == null) {
        break missingId;
      }

      id = R.id.locker_select_all_img_iv;
      ImageView lockerSelectAllImgIv = ViewBindings.findChildViewById(rootView, id);
      if (lockerSelectAllImgIv == null) {
        break missingId;
      }

      id = R.id.locker_select_all_tv;
      TextView lockerSelectAllTv = ViewBindings.findChildViewById(rootView, id);
      if (lockerSelectAllTv == null) {
        break missingId;
      }

      id = R.id.locker_title_tv;
      TextView lockerTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (lockerTitleTv == null) {
        break missingId;
      }

      return new FragmentLockerBinding((ConstraintLayout) rootView, lockerContentTb,
          lockerContentVp, lockerLoginTv, lockerPlayAllImgIv, lockerPlayAllTv, lockerSelectAllImgIv,
          lockerSelectAllTv, lockerTitleTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
