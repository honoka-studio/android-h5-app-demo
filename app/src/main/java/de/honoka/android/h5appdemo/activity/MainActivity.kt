package de.honoka.android.h5appdemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.honoka.android.h5appdemo.R
import de.honoka.sdk.util.android.basic.initGlobalComponents
import de.honoka.sdk.util.android.basic.launchOnIo
import de.honoka.sdk.util.android.server.HttpServer
import de.honoka.sdk.util.android.ui.fullScreen
import de.honoka.sdk.util.android.ui.startRootWebActivty

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fullScreen()
        setContentView(R.layout.activity_main)
        initGlobalComponents()
        launchOnIo {
            //init可能是一个耗时的操作，故在IO线程中执行，防止阻塞UI线程
            initApplication()
            startRootWebActivty(WebActivity::class)
        }
    }

    private fun initApplication() {
        HttpServer.start()
    }
}
