package com.flywith24.demo_databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author yyz (杨云召)
 * @date   2020/4/3
 * time   11:14
 * description
 */
class MyViewModel : ViewModel() {
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
}