// Generated by view binder compiler. Do not edit!
package com.example.clone_coding.databinding;

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
import com.example.clone_coding.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomePanel3Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView homePannelAlbumImgIv;

  @NonNull
  public final TextView homePannelAlbumInfoTv;

  @NonNull
  public final TextView homePannelAlbumSingerTv;

  @NonNull
  public final TextView homePannelAlbumTitleTv;

  @NonNull
  public final ImageView homePannelBackgroundIv;

  @NonNull
  public final ImageView homePannelBtnPlayIv;

  @NonNull
  public final TextView homePannelTitleTv;

  private FragmentHomePanel3Binding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView homePannelAlbumImgIv, @NonNull TextView homePannelAlbumInfoTv,
      @NonNull TextView homePannelAlbumSingerTv, @NonNull TextView homePannelAlbumTitleTv,
      @NonNull ImageView homePannelBackgroundIv, @NonNull ImageView homePannelBtnPlayIv,
      @NonNull TextView homePannelTitleTv) {
    this.rootView = rootView;
    this.homePannelAlbumImgIv = homePannelAlbumImgIv;
    this.homePannelAlbumInfoTv = homePannelAlbumInfoTv;
    this.homePannelAlbumSingerTv = homePannelAlbumSingerTv;
    this.homePannelAlbumTitleTv = homePannelAlbumTitleTv;
    this.homePannelBackgroundIv = homePannelBackgroundIv;
    this.homePannelBtnPlayIv = homePannelBtnPlayIv;
    this.homePannelTitleTv = homePannelTitleTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomePanel3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomePanel3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home_panel3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomePanel3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.home_pannel_album_img_iv;
      ImageView homePannelAlbumImgIv = ViewBindings.findChildViewById(rootView, id);
      if (homePannelAlbumImgIv == null) {
        break missingId;
      }

      id = R.id.home_pannel_album_info_tv;
      TextView homePannelAlbumInfoTv = ViewBindings.findChildViewById(rootView, id);
      if (homePannelAlbumInfoTv == null) {
        break missingId;
      }

      id = R.id.home_pannel_album_singer_tv;
      TextView homePannelAlbumSingerTv = ViewBindings.findChildViewById(rootView, id);
      if (homePannelAlbumSingerTv == null) {
        break missingId;
      }

      id = R.id.home_pannel_album_title_tv;
      TextView homePannelAlbumTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (homePannelAlbumTitleTv == null) {
        break missingId;
      }

      id = R.id.home_pannel_background_iv;
      ImageView homePannelBackgroundIv = ViewBindings.findChildViewById(rootView, id);
      if (homePannelBackgroundIv == null) {
        break missingId;
      }

      id = R.id.home_pannel_btn_play_iv;
      ImageView homePannelBtnPlayIv = ViewBindings.findChildViewById(rootView, id);
      if (homePannelBtnPlayIv == null) {
        break missingId;
      }

      id = R.id.home_pannel_title_tv;
      TextView homePannelTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (homePannelTitleTv == null) {
        break missingId;
      }

      return new FragmentHomePanel3Binding((ConstraintLayout) rootView, homePannelAlbumImgIv,
          homePannelAlbumInfoTv, homePannelAlbumSingerTv, homePannelAlbumTitleTv,
          homePannelBackgroundIv, homePannelBtnPlayIv, homePannelTitleTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
