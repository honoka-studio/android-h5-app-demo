version = rootProject.version

android {
    namespace = "de.honoka.android.h5appdemo"

    defaultConfig {
        applicationId = namespace
        versionCode = libs.versions.pvc.app.get().toInt()
        versionName = project.version.toString()
    }
}
