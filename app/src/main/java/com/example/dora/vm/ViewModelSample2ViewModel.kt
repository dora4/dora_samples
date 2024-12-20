package com.example.dora.vm

import android.view.View
import androidx.lifecycle.MutableLiveData

class ViewModelSample2ViewModel : BaseViewModel() {

    var liveData = MutableLiveData<String>("123")

    val onClick1 = View.OnClickListener {
        liveData.postValue("Clicked button 1")
    }

    val onClick2 = View.OnClickListener {
        liveData.postValue("Clicked button 2")
    }

    val onClick3 = View.OnClickListener {
        liveData.postValue("Clicked button 3")
    }
}