package de.honoka.android.h5appdemo.activity

import de.honoka.android.h5appdemo.jsinterface.TestJsInterface
import de.honoka.sdk.util.android.activity.DefaultWebActivity

class WebActivity : DefaultWebActivity() {

    override val definedJsInterfaceInstances: List<Any> = listOf(TestJsInterface(this))
}
