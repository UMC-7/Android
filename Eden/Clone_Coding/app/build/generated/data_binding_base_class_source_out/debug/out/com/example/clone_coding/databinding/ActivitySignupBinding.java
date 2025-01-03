// Generated by view binder compiler. Do not edit!
package com.example.clone_coding.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.clone_coding.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySignupBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final View signUpAddressUnderscoreView;

  @NonNull
  public final TextView signUpAtSignTv;

  @NonNull
  public final EditText signUpDirectInputEt;

  @NonNull
  public final TextView signUpEmailErrorTv;

  @NonNull
  public final ImageView signUpEmailListIv;

  @NonNull
  public final ImageView signUpHidePasswordCheckIv;

  @NonNull
  public final ImageView signUpHidePasswordIv;

  @NonNull
  public final EditText signUpIdEt;

  @NonNull
  public final View signUpIdUnderscoreView;

  @NonNull
  public final ProgressBar signUpLoadingPb;

  @NonNull
  public final EditText signUpNameEt;

  @NonNull
  public final View signUpNameUnderscoreView;

  @NonNull
  public final EditText signUpPasswordCheckEt;

  @NonNull
  public final View signUpPasswordCheckUnderscoreView;

  @NonNull
  public final EditText signUpPasswordEt;

  @NonNull
  public final View signUpPasswordUnderscoreView;

  @NonNull
  public final AppCompatButton signUpSignUpBtn;

  @NonNull
  public final TextView signUpSignUpTv;

  private ActivitySignupBinding(@NonNull ConstraintLayout rootView,
      @NonNull View signUpAddressUnderscoreView, @NonNull TextView signUpAtSignTv,
      @NonNull EditText signUpDirectInputEt, @NonNull TextView signUpEmailErrorTv,
      @NonNull ImageView signUpEmailListIv, @NonNull ImageView signUpHidePasswordCheckIv,
      @NonNull ImageView signUpHidePasswordIv, @NonNull EditText signUpIdEt,
      @NonNull View signUpIdUnderscoreView, @NonNull ProgressBar signUpLoadingPb,
      @NonNull EditText signUpNameEt, @NonNull View signUpNameUnderscoreView,
      @NonNull EditText signUpPasswordCheckEt, @NonNull View signUpPasswordCheckUnderscoreView,
      @NonNull EditText signUpPasswordEt, @NonNull View signUpPasswordUnderscoreView,
      @NonNull AppCompatButton signUpSignUpBtn, @NonNull TextView signUpSignUpTv) {
    this.rootView = rootView;
    this.signUpAddressUnderscoreView = signUpAddressUnderscoreView;
    this.signUpAtSignTv = signUpAtSignTv;
    this.signUpDirectInputEt = signUpDirectInputEt;
    this.signUpEmailErrorTv = signUpEmailErrorTv;
    this.signUpEmailListIv = signUpEmailListIv;
    this.signUpHidePasswordCheckIv = signUpHidePasswordCheckIv;
    this.signUpHidePasswordIv = signUpHidePasswordIv;
    this.signUpIdEt = signUpIdEt;
    this.signUpIdUnderscoreView = signUpIdUnderscoreView;
    this.signUpLoadingPb = signUpLoadingPb;
    this.signUpNameEt = signUpNameEt;
    this.signUpNameUnderscoreView = signUpNameUnderscoreView;
    this.signUpPasswordCheckEt = signUpPasswordCheckEt;
    this.signUpPasswordCheckUnderscoreView = signUpPasswordCheckUnderscoreView;
    this.signUpPasswordEt = signUpPasswordEt;
    this.signUpPasswordUnderscoreView = signUpPasswordUnderscoreView;
    this.signUpSignUpBtn = signUpSignUpBtn;
    this.signUpSignUpTv = signUpSignUpTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.sign_up_address_underscore_view;
      View signUpAddressUnderscoreView = ViewBindings.findChildViewById(rootView, id);
      if (signUpAddressUnderscoreView == null) {
        break missingId;
      }

      id = R.id.sign_up_at_sign_tv;
      TextView signUpAtSignTv = ViewBindings.findChildViewById(rootView, id);
      if (signUpAtSignTv == null) {
        break missingId;
      }

      id = R.id.sign_up_direct_input_et;
      EditText signUpDirectInputEt = ViewBindings.findChildViewById(rootView, id);
      if (signUpDirectInputEt == null) {
        break missingId;
      }

      id = R.id.sign_up_email_error_tv;
      TextView signUpEmailErrorTv = ViewBindings.findChildViewById(rootView, id);
      if (signUpEmailErrorTv == null) {
        break missingId;
      }

      id = R.id.sign_up_email_list_iv;
      ImageView signUpEmailListIv = ViewBindings.findChildViewById(rootView, id);
      if (signUpEmailListIv == null) {
        break missingId;
      }

      id = R.id.sign_up_hide_password_check_iv;
      ImageView signUpHidePasswordCheckIv = ViewBindings.findChildViewById(rootView, id);
      if (signUpHidePasswordCheckIv == null) {
        break missingId;
      }

      id = R.id.sign_up_hide_password_iv;
      ImageView signUpHidePasswordIv = ViewBindings.findChildViewById(rootView, id);
      if (signUpHidePasswordIv == null) {
        break missingId;
      }

      id = R.id.sign_up_id_et;
      EditText signUpIdEt = ViewBindings.findChildViewById(rootView, id);
      if (signUpIdEt == null) {
        break missingId;
      }

      id = R.id.sign_up_id_underscore_view;
      View signUpIdUnderscoreView = ViewBindings.findChildViewById(rootView, id);
      if (signUpIdUnderscoreView == null) {
        break missingId;
      }

      id = R.id.sign_up_loading_pb;
      ProgressBar signUpLoadingPb = ViewBindings.findChildViewById(rootView, id);
      if (signUpLoadingPb == null) {
        break missingId;
      }

      id = R.id.sign_up_name_et;
      EditText signUpNameEt = ViewBindings.findChildViewById(rootView, id);
      if (signUpNameEt == null) {
        break missingId;
      }

      id = R.id.sign_up_name_underscore_view;
      View signUpNameUnderscoreView = ViewBindings.findChildViewById(rootView, id);
      if (signUpNameUnderscoreView == null) {
        break missingId;
      }

      id = R.id.sign_up_password_check_et;
      EditText signUpPasswordCheckEt = ViewBindings.findChildViewById(rootView, id);
      if (signUpPasswordCheckEt == null) {
        break missingId;
      }

      id = R.id.sign_up_password_check_underscore_view;
      View signUpPasswordCheckUnderscoreView = ViewBindings.findChildViewById(rootView, id);
      if (signUpPasswordCheckUnderscoreView == null) {
        break missingId;
      }

      id = R.id.sign_up_password_et;
      EditText signUpPasswordEt = ViewBindings.findChildViewById(rootView, id);
      if (signUpPasswordEt == null) {
        break missingId;
      }

      id = R.id.sign_up_password_underscore_view;
      View signUpPasswordUnderscoreView = ViewBindings.findChildViewById(rootView, id);
      if (signUpPasswordUnderscoreView == null) {
        break missingId;
      }

      id = R.id.sign_up_sign_up_btn;
      AppCompatButton signUpSignUpBtn = ViewBindings.findChildViewById(rootView, id);
      if (signUpSignUpBtn == null) {
        break missingId;
      }

      id = R.id.sign_up_sign_up_tv;
      TextView signUpSignUpTv = ViewBindings.findChildViewById(rootView, id);
      if (signUpSignUpTv == null) {
        break missingId;
      }

      return new ActivitySignupBinding((ConstraintLayout) rootView, signUpAddressUnderscoreView,
          signUpAtSignTv, signUpDirectInputEt, signUpEmailErrorTv, signUpEmailListIv,
          signUpHidePasswordCheckIv, signUpHidePasswordIv, signUpIdEt, signUpIdUnderscoreView,
          signUpLoadingPb, signUpNameEt, signUpNameUnderscoreView, signUpPasswordCheckEt,
          signUpPasswordCheckUnderscoreView, signUpPasswordEt, signUpPasswordUnderscoreView,
          signUpSignUpBtn, signUpSignUpTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
