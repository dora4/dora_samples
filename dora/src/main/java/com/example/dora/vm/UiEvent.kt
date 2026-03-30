package com.example.dora.vm

sealed class UiEvent {
    data class UpdateText(val text: String) : UiEvent()
}