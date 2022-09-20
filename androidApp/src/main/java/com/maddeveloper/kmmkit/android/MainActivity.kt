package com.maddeveloper.kmmkit.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maddeveloper.kmmkit.android.ui.theme.KmmKITTheme
import com.maddeveloper.kmmkit.repo.AppRepo
import com.maddeveloper.kmmkit.service.AppService
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val data = remember {
                mutableStateOf("Loading")
            }
            LaunchedEffect(Unit) {
                kotlin.runCatching {
                    AppRepo().getDog(3)
                }.onSuccess {
                    data.value = it.toString()
                }.onFailure {
                    data.value = "Error: ${it.localizedMessage}"
                }
            }
            KmmKITTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("${data.value}")
                }
            }
        }


    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name!")

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KmmKITTheme {
        Greeting("Android")
    }
}