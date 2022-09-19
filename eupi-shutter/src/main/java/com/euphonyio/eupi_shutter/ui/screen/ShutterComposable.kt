package com.euphonyio.eupi_shutter.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.euphonyio.eupi_shutter.Command
import com.euphonyio.eupi_shutter.ui.theme.Purple200

@Composable
fun ShutterScreen(
    onShutterClick:() -> Unit,
    onSwitchClick:() -> Unit
){
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
//                Command.SHUTTER -> {
//                    Toast.makeText(context, "셔터", Toast.LENGTH_SHORT).show()
//                }
//                Command.SWITCH -> {
//                    Toast.makeText(context, "카메라 전환", Toast.LENGTH_SHORT).show()
//                }
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
            color = Color.White
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ShutterPreview() {
//    ShutterScreen()
//}