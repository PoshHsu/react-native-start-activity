package com.posh.reactlibrary;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Callback;

public class RNStartActivityModule extends ReactContextBaseJavaModule {
  private static final String TAG = "RNStartActivityModule";
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
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                      Intent.FLAG_ACTIVITY_CLEAR_TOP |
                      Intent.FLAG_ACTIVITY_SINGLE_TOP);

      boolean isIncomingCall = params.getBoolean("isIncomingCall");

      if (!isIncomingCall) {
        return;
      }

      String callerDisplayName = "";
      boolean videoDisabled = true;
      if (params.hasKey("callerDisplayName")) {
        callerDisplayName = params.getString("callerDisplayName");
      }
      if (params.hasKey("videoDisabled")) {
        videoDisabled = params.getBoolean("videoDisabled");
      }

      intent.putExtra("is_incoming_call", true);
      intent.putExtra("caller_display_name", callerDisplayName);
      intent.putExtra("video_disabled", videoDisabled);

      this.reactContext.startActivity(intent);
    }
  }
}
