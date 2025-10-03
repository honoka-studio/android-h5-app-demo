package de.honoka.android.h5appdemo.util

import de.honoka.sdk.util.android.basic.AbstractApplicationUtils
import de.honoka.sdk.util.android.server.HttpServer

object ApplicationUtils : AbstractApplicationUtils() {

    override fun initApplication() {
        HttpServer.start()
    }
}
