package com.maddeveloper.kmmkit.android.screens

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maddeveloper.kmmkit.repo.AppRepo
import kotlinx.coroutines.launch

class MainVm:ViewModel() {
    val data = mutableStateOf(listOf<String?>(null))
    val error = mutableStateOf("")



    init {
        viewModelScope.launch {
            kotlin.runCatching {
                AppRepo().getDog(5)
            }.onSuccess {
                it.peekData().let {
                    data.value = it!!
                } }.onFailure {
                error.value = "Error: ${it.localizedMessage}"
            }
        }
    }



    fun getFlowDoge(){
        viewModelScope.launch {
            val mdata=AppRepo().getDataFlow(5)

        }
    }

}