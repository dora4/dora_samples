package com.example.dora.vm

import android.view.View
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ViewModelSample3ViewModel : ViewModel() {

    private val _textState = MutableStateFlow("123")
    val textState: StateFlow<String> = _textState

    fun onClick1(v: View) {
        updateText("点击了 Button 1")
    }

    fun onClick2(v: View) {
        updateText("点击了 Button 2")
    }

    fun onClick3(v: View) {
        updateText("点击了 Button 3")
    }

    fun updateText(text: String) {
        _textState.value = text
    }
}