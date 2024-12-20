package com.example.dora.vm

import android.view.View
import androidx.databinding.ObservableField

class ViewModelSample1ViewModel : BaseViewModel() {

    var textObservable = ObservableField<String>("123")

    val onClick1 = View.OnClickListener {
        textObservable.set("Clicked button 1")
    }

    val onClick2 = View.OnClickListener {
        textObservable.set("Clicked button 2")
    }

    val onClick3 = View.OnClickListener {
        textObservable.set("Clicked button 3")
    }
}