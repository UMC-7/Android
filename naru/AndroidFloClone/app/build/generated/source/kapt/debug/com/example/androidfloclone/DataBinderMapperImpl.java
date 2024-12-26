package com.example.androidfloclone;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.androidfloclone.databinding.ActivityMainBindingImpl;
import com.example.androidfloclone.databinding.FragmentAlbumBindingImpl;
import com.example.androidfloclone.databinding.FragmentBottomSheetBindingImpl;
import com.example.androidfloclone.databinding.ToastBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_FRAGMENTALBUM = 2;

  private static final int LAYOUT_FRAGMENTBOTTOMSHEET = 3;

  private static final int LAYOUT_TOAST = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.androidfloclone.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.androidfloclone.R.layout.fragment_album, LAYOUT_FRAGMENTALBUM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.androidfloclone.R.layout.fragment_bottom_sheet, LAYOUT_FRAGMENTBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.androidfloclone.R.layout.toast, LAYOUT_TOAST);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTALBUM: {
          if ("layout/fragment_album_0".equals(tag)) {
            return new FragmentAlbumBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_album is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBOTTOMSHEET: {
          if ("layout/fragment_bottom_sheet_0".equals(tag)) {
            return new FragmentBottomSheetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_bottom_sheet is invalid. Received: " + tag);
        }
        case  LAYOUT_TOAST: {
          if ("layout/toast_0".equals(tag)) {
            return new ToastBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for toast is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_main_0", com.example.androidfloclone.R.layout.activity_main);
      sKeys.put("layout/fragment_album_0", com.example.androidfloclone.R.layout.fragment_album);
      sKeys.put("layout/fragment_bottom_sheet_0", com.example.androidfloclone.R.layout.fragment_bottom_sheet);
      sKeys.put("layout/toast_0", com.example.androidfloclone.R.layout.toast);
    }
  }
}
