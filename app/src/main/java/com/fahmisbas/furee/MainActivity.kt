package com.fahmisbas.furee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.fahmisbas.furee.ui.HomeScreen
import com.fahmisbas.furee.ui.theme.FureeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FureeTheme {
                this.window.statusBarColor = ContextCompat.getColor(this,R.color.cardColor)
                HomeScreen()

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FureeTheme {
        // A surface container using the 'background' color from the theme
        HomeScreen()

    }
}