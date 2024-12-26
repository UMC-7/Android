// Generated by view binder compiler. Do not edit!
package com.example.clone_coding.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.clone_coding.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemAlbumBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView itemAlbumCoverImgCardView;

  @NonNull
  public final ImageView itemAlbumCoverImgIv;

  @NonNull
  public final ImageView itemAlbumPlayImgIv;

  @NonNull
  public final TextView itemAlbumSingerTv;

  @NonNull
  public final TextView itemAlbumTitleTv;

  private ItemAlbumBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardView itemAlbumCoverImgCardView, @NonNull ImageView itemAlbumCoverImgIv,
      @NonNull ImageView itemAlbumPlayImgIv, @NonNull TextView itemAlbumSingerTv,
      @NonNull TextView itemAlbumTitleTv) {
    this.rootView = rootView;
    this.itemAlbumCoverImgCardView = itemAlbumCoverImgCardView;
    this.itemAlbumCoverImgIv = itemAlbumCoverImgIv;
    this.itemAlbumPlayImgIv = itemAlbumPlayImgIv;
    this.itemAlbumSingerTv = itemAlbumSingerTv;
    this.itemAlbumTitleTv = itemAlbumTitleTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemAlbumBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemAlbumBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_album, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemAlbumBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.item_album_cover_img_cardView;
      CardView itemAlbumCoverImgCardView = ViewBindings.findChildViewById(rootView, id);
      if (itemAlbumCoverImgCardView == null) {
        break missingId;
      }

      id = R.id.item_album_cover_img_iv;
      ImageView itemAlbumCoverImgIv = ViewBindings.findChildViewById(rootView, id);
      if (itemAlbumCoverImgIv == null) {
        break missingId;
      }

      id = R.id.item_album_play_img_iv;
      ImageView itemAlbumPlayImgIv = ViewBindings.findChildViewById(rootView, id);
      if (itemAlbumPlayImgIv == null) {
        break missingId;
      }

      id = R.id.item_album_singer_tv;
      TextView itemAlbumSingerTv = ViewBindings.findChildViewById(rootView, id);
      if (itemAlbumSingerTv == null) {
        break missingId;
      }

      id = R.id.item_album_title_tv;
      TextView itemAlbumTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (itemAlbumTitleTv == null) {
        break missingId;
      }

      return new ItemAlbumBinding((ConstraintLayout) rootView, itemAlbumCoverImgCardView,
          itemAlbumCoverImgIv, itemAlbumPlayImgIv, itemAlbumSingerTv, itemAlbumTitleTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
