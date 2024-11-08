package com.example.gymapp.present

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymapp.R

open class FragmentViewModel:ViewModel() {

    val message:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val mainMessage:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val pictureSent:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

}