package de.honoka.android.h5appdemo.jsinterface

import android.webkit.JavascriptInterface
import cn.hutool.json.JSONObject
import de.honoka.android.h5appdemo.activity.WebActivity
import de.honoka.sdk.util.android.jsinterface.AsyncJavascriptInterface
import de.honoka.sdk.util.android.ui.toast
import java.util.concurrent.TimeUnit

class TestJsInterface(private val webActivity: WebActivity) {

    @JavascriptInterface
    fun test() {
        webActivity.toast("Test")
    }

    @AsyncJavascriptInterface
    fun asyncMethodTest(a: Int, b: Int): JSONObject {
        TimeUnit.SECONDS.sleep(3)
        return JSONObject().set("sum", (a + b).toString())
    }
}
