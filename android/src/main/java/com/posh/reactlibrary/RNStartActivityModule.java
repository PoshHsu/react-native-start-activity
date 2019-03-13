package com.posh.reactlibrary;

import android.content.ComponentName;
import android.content.Intent;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Callback;

public class RNStartActivityModule extends ReactContextBaseJavaModule {
  private static final String ATTR_PACKAGE_NAME = "packageName";
  private static final String ATTR_CLASS_NAME = "className";

  private final ReactApplicationContext reactContext;

  public RNStartActivityModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNStartActivity";
  }

  @ReactMethod
  public void startActivity(ReadableMap params) {
    Intent intent = new Intent();

    if (params.hasKey(ATTR_CLASS_NAME)) {
      ComponentName cn;
      if (params.hasKey(ATTR_PACKAGE_NAME)) {
        cn = new ComponentName(params.getString(ATTR_PACKAGE_NAME), params.getString(ATTR_CLASS_NAME));
      } else {
        cn = new ComponentName(getReactApplicationContext(), params.getString(ATTR_CLASS_NAME));
      }
      intent.setComponent(cn);

      this.reactContext.startActivity(intent);
    }
  }
}
