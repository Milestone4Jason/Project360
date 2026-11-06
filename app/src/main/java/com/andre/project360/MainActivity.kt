package com.andre.project360

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Green = Color(0xFF79B900)
private val Dark = Color(0xFF101510)
private val Tile = Color(0xFF202A20)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { Dashboard() } }
    }
}

@Composable
private fun Dashboard() {
    var updateLabel by remember { mutableStateOf("No update selected") }
    var selectedUri by remember { mutableStateOf<Uri?>(null) }
    val picker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        if (uri != null) {
            selectedUri = uri
            updateLabel = uri.lastPathSegment?.substringAfterLast('/') ?: "Update ZIP selected"
        }
    }
    Surface(Modifier.fillMaxSize(), color = Dark) {
        Column(Modifier.fillMaxSize().padding(22.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text("PROJECT", color = Color.LightGray, fontSize = 12.sp, letterSpacing = 4.sp)
                    Text("360", color = Green, fontSize = 44.sp, fontWeight = FontWeight.Black)
                }
                Text("PREVIEW 0.1", color = Color.LightGray, fontSize = 11.sp)
            }
            Text("Your console-inspired hub", color = Color.White, fontSize = 21.sp, fontWeight = FontWeight.Bold)
            TileCard("GAME LIBRARY", "Emulator core not connected", "Game launching is not available in this starter build.")
            TileCard("SYSTEM UPDATE", updateLabel, "Choose an update archive stored on your device.")
            Button(onClick = { picker.launch(arrayOf("application/zip", "application/octet-stream", "*/*")) },
                colors = ButtonDefaults.buttonColors(containerColor = Green),
                shape = RoundedCornerShape(10.dp)) {
                Text("IMPORT UPDATE ZIP", color = Color.Black, fontWeight = FontWeight.Bold)
            }
            TileCard("EMULATOR STATUS", "Not installed", "This is a dashboard shell, not yet a working Xbox 360 emulator.")
            Spacer(Modifier.weight(1f))
            Text("Android • ARM64-capable UI • No games or firmware bundled", color = Color.Gray, fontSize = 11.sp)
        }
    }
}

@Composable
private fun TileCard(title: String, subtitle: String, detail: String) {
    Column(Modifier.fillMaxWidth().background(Tile, RoundedCornerShape(14.dp)).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp)) {
        Text(title, color = Green, fontSize = 12.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.3.sp)
        Text(subtitle, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        Text(detail, color = Color.LightGray, fontSize = 12.sp)
    }
}
