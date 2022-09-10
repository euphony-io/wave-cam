package com.euphonyio.eupi_camera

import android.app.Application
import android.util.Log
import androidx.camera.camera2.Camera2Config
import androidx.camera.core.CameraXConfig

/**
 * eupi-camera
 * Created by SeonJK
 * Date: 2022-09-03
 * Time: 오후 4:22
 * */
class CameraApplication : Application(), CameraXConfig.Provider {
    override fun getCameraXConfig(): CameraXConfig {
        return CameraXConfig.Builder.fromConfig(Camera2Config.defaultConfig())
            .setMinimumLoggingLevel(Log.ERROR).build()
    }
}