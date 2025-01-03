// Generated by view binder compiler. Do not edit!
package com.example.androidfloclone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.androidfloclone.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentVideoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView musicVideoIntroductionTv;

  @NonNull
  public final ImageView musicVideoIv;

  @NonNull
  public final TextView musicVideoTv;

  @NonNull
  public final ImageButton sortingMethodIb;

  @NonNull
  public final TextView sortingMethodTv;

  private FragmentVideoBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView musicVideoIntroductionTv, @NonNull ImageView musicVideoIv,
      @NonNull TextView musicVideoTv, @NonNull ImageButton sortingMethodIb,
      @NonNull TextView sortingMethodTv) {
    this.rootView = rootView;
    this.musicVideoIntroductionTv = musicVideoIntroductionTv;
    this.musicVideoIv = musicVideoIv;
    this.musicVideoTv = musicVideoTv;
    this.sortingMethodIb = sortingMethodIb;
    this.sortingMethodTv = sortingMethodTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentVideoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentVideoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_video, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentVideoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.music_video_introduction_tv;
      TextView musicVideoIntroductionTv = ViewBindings.findChildViewById(rootView, id);
      if (musicVideoIntroductionTv == null) {
        break missingId;
      }

      id = R.id.music_video_iv;
      ImageView musicVideoIv = ViewBindings.findChildViewById(rootView, id);
      if (musicVideoIv == null) {
        break missingId;
      }

      id = R.id.music_video_tv;
      TextView musicVideoTv = ViewBindings.findChildViewById(rootView, id);
      if (musicVideoTv == null) {
        break missingId;
      }

      id = R.id.sorting_method_ib;
      ImageButton sortingMethodIb = ViewBindings.findChildViewById(rootView, id);
      if (sortingMethodIb == null) {
        break missingId;
      }

      id = R.id.sorting_method_tv;
      TextView sortingMethodTv = ViewBindings.findChildViewById(rootView, id);
      if (sortingMethodTv == null) {
        break missingId;
      }

      return new FragmentVideoBinding((ConstraintLayout) rootView, musicVideoIntroductionTv,
          musicVideoIv, musicVideoTv, sortingMethodIb, sortingMethodTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
