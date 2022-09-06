package com.euphonyio.eupi_shutter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
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
                    ShutterScreen()
                }
            }
        }
    }
}

@Composable
fun ShutterScreen(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CameraButton(Command.SHUTTER)
        Spacer(modifier = Modifier.height(100.dp))
        CameraButton(Command.SWITCH)
    }
}

@Composable
fun CameraButton(command: Command){
    var context = LocalContext.current

    Button(
        onClick = {
            when(command){
                Command.SHUTTER -> {
                    Toast.makeText(context, "셔터", Toast.LENGTH_SHORT).show()
                }
                Command.SWITCH -> {
                    Toast.makeText(context, "카메라 전환", Toast.LENGTH_SHORT).show()
                }
            }
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple200
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(
            text = command.toString(),
            fontSize = 18.sp,
            color = colorResource(id = R.color.white)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShutterPreview() {
    ShutterScreen()
}