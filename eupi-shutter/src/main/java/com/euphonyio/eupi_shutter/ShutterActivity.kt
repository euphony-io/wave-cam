package com.euphonyio.eupi_shutter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.euphonyio.eupi_shutter.ui.theme.EupicameraTheme
import com.euphonyio.eupi_shutter.ui.theme.Purple200

class ShutterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EupicameraTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    ShutterPreview()
                }
            }
        }
    }
}

@Composable
fun CameraChange(str: String){
    Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple200
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(
            text = str,
            fontSize = 18.sp,
            color = colorResource(id = R.color.white),
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShutterPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CameraChange("Shutter")
        Spacer(modifier = Modifier.height(100.dp))
        CameraChange("Change")
    }
}