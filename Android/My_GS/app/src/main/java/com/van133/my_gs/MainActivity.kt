package com.van133.my_gs

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.van133.my_gs.ui.theme.MY_GSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        var bar_code :String
        val btn_event = findViewById<Button>(R.id.Camera)
        var qrCodeScan = QRCodeScan(this)
        btn_event.setOnClickListener{
            qrCodeScan.startQRScan()

            println("==========================================")
            println(qrCodeScan.getBar())
            println("==========================================")
        }

    }
}
