package com.psob96.reddit

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewTreeLifecycleOwner
import com.psob96.reddit.ui.nav.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewTreeLifecycleOwner.set(window.decorView, this)
        setContent {
          //  window.statusBarColor = MaterialTheme.colors.background.toArgb()
           // window.navigationBarColor = MaterialTheme.colors.background.toArgb()
            MainScreen()
        }
    }
}