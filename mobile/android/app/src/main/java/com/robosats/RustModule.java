package com.robosats.myrustapplication;

package com.robosats;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RustModule extends ReactContextBaseJavaModule {
    @Override
    public String getName() {
        return "NativeModule";  // Name of the Native Modules.
    }

    static {
        System.loadLibrary("rust_module");
    }

    @ReactMethod
    public String run() {
        return nativeRun();
    }

    @ReactMethod
    public void encrypt(String plainText, Promise promise) {
    try {
      // Add your encryption logic here
      // (can use any JAVA encryption library or use default)
      String encryptedText = plainText + "This is encrypted text";
      promise.resolve(encryptedText); // return encryptedText
    } catch (Exception e) {
      promise.reject("ENCRYPTION_FAILED", "Encryption Failed");
    }
}
}

// public class NativeModule {
//     // Load the native library "librust_module.so".
//     static {
//         System.loadLibrary("rust_module");
//     }

//     public String run() {
//         return nativeRun();
//     }

//     public String arch() {
//         return getArchName();
//     }

//     // Native function implemented in Rust.
//     private static native String nativeRun();
//     private static native String getArchName();
// }