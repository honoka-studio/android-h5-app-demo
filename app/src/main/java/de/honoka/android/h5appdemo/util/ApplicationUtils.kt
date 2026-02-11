package de.honoka.android.h5appdemo.util

import de.honoka.sdk.util.android.various.AbstractApplicationUtils
import de.honoka.sdk.util.android.web.server.DefaultHttpServer

object ApplicationUtils : AbstractApplicationUtils() {

    override fun initApplication() {
        DefaultHttpServer.start()
    }
}
