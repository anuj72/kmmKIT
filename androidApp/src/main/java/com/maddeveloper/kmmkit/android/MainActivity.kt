package com.maddeveloper.kmmkit.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import com.maddeveloper.kmmkit.Greeting
import com.maddeveloper.kmmkit.repo.AppRepo
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "Loading..."
        mainScope.launch {
            kotlin.runCatching {
                AppRepo().getDog(3)
            }.onSuccess {
                tv.text = it.toString()
            }.onFailure {
                tv.text = "Error: ${it.localizedMessage}"
            }
        }

    }
}
