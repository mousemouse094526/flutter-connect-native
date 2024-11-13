package com.example.flutter_connect_native

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity(){

    private val CHANNEL = "com.example/native_bridge"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "getNativeData") {
                val nativeData = getNativeData()
                result.success(nativeData)
            } else {
                result.notImplemented()
            }
        }
    }

    private fun getNativeData(): String {
        return "Hello from Native"
    }
}
 