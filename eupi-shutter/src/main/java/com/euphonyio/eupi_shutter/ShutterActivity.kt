package com.euphonyio.eupi_shutter

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import co.euphony.tx.EuTxManager
import co.euphony.util.EuOption
import com.euphonyio.eupi_shutter.ui.screen.ShutterScreen
import com.euphonyio.eupi_shutter.ui.theme.EupicameraTheme

class ShutterActivity : ComponentActivity() {

    private val euTxManager: EuTxManager by lazy {
        EuTxManager()
    }

    private val audioPermissionCallback =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                Toast.makeText(this, "마이크 권한 허용 승인", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "마이크 권한을 반드시 허용해야 합니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intent.data = Uri.parse("package:$packageName")
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        euTxManager.setMode(EuOption.ModeType.EUPI)

        setContent {
            EupicameraTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    ShutterScreen()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        when {
            ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED -> {
                // TODO: Euphony listen
            }
            shouldShowRequestPermissionRationale(Manifest.permission.RECORD_AUDIO) -> {
                audioPermissionCallback.launch(Manifest.permission.RECORD_AUDIO)
            }
            else -> {
                audioPermissionCallback.launch(Manifest.permission.RECORD_AUDIO)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        euTxManager.stop()
    }
}



