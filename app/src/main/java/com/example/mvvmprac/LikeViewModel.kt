package com.example.mvvmprac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LikeViewModel : ViewModel() {

    //var likeCount:Int = 0

    private val _likeCount = MutableLiveData<Int>(0)
    private val _DislikeCount = MutableLiveData<Int>(0)

    val likeCount: LiveData<Int>
        get() = _likeCount

    val dislikeCount: LiveData<Int>
        get() = _DislikeCount

    fun PerformLike() {

        _likeCount.value = _likeCount.value!! + 1

    }

    fun PerformDisLike() {

        _DislikeCount.value = _DislikeCount.value!! + 1

    }
}