package com.example.dora.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.channels.BufferOverflow

class ViewModelSample4ViewModel : ViewModel() {

    private val _eventFlow = MutableSharedFlow<UiEvent>(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val eventFlow: SharedFlow<UiEvent> = _eventFlow

    fun onClick1() {
        sendEvent(UiEvent.UpdateText("点击了 Button 1"))
    }

    fun onClick2() {
        sendEvent(UiEvent.UpdateText("点击了 Button 2"))
    }

    fun onClick3() {
        sendEvent(UiEvent.UpdateText("点击了 Button 3"))
    }

    fun sendEvent(event: UiEvent) {
        _eventFlow.tryEmit(event)
    }
}