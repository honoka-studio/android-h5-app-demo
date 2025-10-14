package de.honoka.android.h5appdemo.jsinterface

import android.webkit.JavascriptInterface
import cn.hutool.json.JSONObject
import de.honoka.android.h5appdemo.activity.WebActivity
import de.honoka.sdk.util.android.basic.toast
import de.honoka.sdk.util.android.jsinterface.AsyncJavascriptInterface
import java.util.concurrent.TimeUnit

class TestJsInterface(private val webActivity: WebActivity) {

    @JavascriptInterface
    fun test() {
        webActivity.toast("Test")
    }

    @AsyncJavascriptInterface
    fun asyncMethodTest(a: Int, b: Int): JSONObject {
        TimeUnit.SECONDS.sleep(3)
        val result = a + b
        if(result > 100) {
            error("Bigger than 100: $result")
        }
        return JSONObject().set("sum", result.toString())
    }
}
