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

public final class FragmentAlbumBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView albumAlbumIv;

  @NonNull
  public final ImageView albumBackIv;

  @NonNull
  public final TabLayout albumContentTb;

  @NonNull
  public final ViewPager2 albumContentVp;

  @NonNull
  public final ImageView albumLikeIv;

  @NonNull
  public final ImageView albumLpIv;

  @NonNull
  public final ImageView albumMoreIv;

  @NonNull
  public final TextView albumMusicTitleInfoTv;

  @NonNull
  public final TextView albumMusicTitleTv;

  @NonNull
  public final TextView albumSingerNameTv;

  private FragmentAlbumBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView albumAlbumIv,
      @NonNull ImageView albumBackIv, @NonNull TabLayout albumContentTb,
      @NonNull ViewPager2 albumContentVp, @NonNull ImageView albumLikeIv,
      @NonNull ImageView albumLpIv, @NonNull ImageView albumMoreIv,
      @NonNull TextView albumMusicTitleInfoTv, @NonNull TextView albumMusicTitleTv,
      @NonNull TextView albumSingerNameTv) {
    this.rootView = rootView;
    this.albumAlbumIv = albumAlbumIv;
    this.albumBackIv = albumBackIv;
    this.albumContentTb = albumContentTb;
    this.albumContentVp = albumContentVp;
    this.albumLikeIv = albumLikeIv;
    this.albumLpIv = albumLpIv;
    this.albumMoreIv = albumMoreIv;
    this.albumMusicTitleInfoTv = albumMusicTitleInfoTv;
    this.albumMusicTitleTv = albumMusicTitleTv;
    this.albumSingerNameTv = albumSingerNameTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAlbumBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAlbumBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_album, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAlbumBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.album_album_iv;
      ImageView albumAlbumIv = ViewBindings.findChildViewById(rootView, id);
      if (albumAlbumIv == null) {
        break missingId;
      }

      id = R.id.album_back_iv;
      ImageView albumBackIv = ViewBindings.findChildViewById(rootView, id);
      if (albumBackIv == null) {
        break missingId;
      }

      id = R.id.album_content_tb;
      TabLayout albumContentTb = ViewBindings.findChildViewById(rootView, id);
      if (albumContentTb == null) {
        break missingId;
      }

      id = R.id.album_content_vp;
      ViewPager2 albumContentVp = ViewBindings.findChildViewById(rootView, id);
      if (albumContentVp == null) {
        break missingId;
      }

      id = R.id.album_like_iv;
      ImageView albumLikeIv = ViewBindings.findChildViewById(rootView, id);
      if (albumLikeIv == null) {
        break missingId;
      }

      id = R.id.album_lp_iv;
      ImageView albumLpIv = ViewBindings.findChildViewById(rootView, id);
      if (albumLpIv == null) {
        break missingId;
      }

      id = R.id.album_more_iv;
      ImageView albumMoreIv = ViewBindings.findChildViewById(rootView, id);
      if (albumMoreIv == null) {
        break missingId;
      }

      id = R.id.album_music_title_info_tv;
      TextView albumMusicTitleInfoTv = ViewBindings.findChildViewById(rootView, id);
      if (albumMusicTitleInfoTv == null) {
        break missingId;
      }

      id = R.id.album_music_title_tv;
      TextView albumMusicTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (albumMusicTitleTv == null) {
        break missingId;
      }

      id = R.id.album_singer_name_tv;
      TextView albumSingerNameTv = ViewBindings.findChildViewById(rootView, id);
      if (albumSingerNameTv == null) {
        break missingId;
      }

      return new FragmentAlbumBinding((ConstraintLayout) rootView, albumAlbumIv, albumBackIv,
          albumContentTb, albumContentVp, albumLikeIv, albumLpIv, albumMoreIv,
          albumMusicTitleInfoTv, albumMusicTitleTv, albumSingerNameTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
