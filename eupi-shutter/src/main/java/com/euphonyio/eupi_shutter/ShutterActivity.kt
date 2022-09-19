package com.euphonyio.eupi_shutter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.euphonyio.eupi_shutter.ui.screen.ShutterScreen
import com.euphonyio.eupi_shutter.ui.theme.EupicameraTheme

class ShutterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}



