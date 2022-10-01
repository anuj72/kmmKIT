package com.maddeveloper.kmmkit.android.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maddeveloper.kmmkit.android.component.LoadImage
import com.maddeveloper.kmmkit.android.ui.theme.KmmKITTheme
import com.maddeveloper.kmmkit.repo.AppRepo
import com.maddeveloper.kmmkit.service.AppService
import com.skydoves.landscapist.coil.CoilImage
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel


class MainActivity : ComponentActivity() {
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm = getViewModel<MainVm>()

        setContent {
            val data = vm.data

            KmmKITTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                 LazyColumn{
                     items(data.value.size){pos->
                         val url = data.value[pos]
                         Column(modifier = Modifier.padding(16.dp)) {
                             LoadImage(url?:"")
                         }
                        

                     }
                 }

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