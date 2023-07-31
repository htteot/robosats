#[cfg(target_os = "android")]
#[allow(non_snake_case)]
pub mod android {
    use jni::objects::JClass;
    use jni::sys::jstring;
    use jni::JNIEnv;

    // The native function implemented in Rust.
    #[no_mangle]
    pub unsafe extern "C" fn Java_com_example_myrustapplication_NativeLibrary_nativeRun(
        env: JNIEnv,
        _: JClass,
    ) -> jstring {
        todo!("Implement something useful.")
    }

    #[no_mangle]
    pub unsafe extern "C" fn Java_com_example_myrustapplication_NativeLibrary_getArchName(
    ) -> &'static str {
        #[cfg(target_arch = "x86")]
        return "x86";

        #[cfg(target_arch = "x86_64")]
        return "x86_64";

        #[cfg(target_arch = "arm")]
        return "arm";

        #[cfg(target_arch = "aarch64")]
        return "aarch64";

        #[cfg(not(any(
            target_arch = "x86",
            target_arch = "x86_64",
            target_arch = "arm",
            target_arch = "aarch64",
        )))]
        return "unknown";
    }
}
