package com.zd.kotlinwanandroid.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Package: com.zd.kotlinwanandroid.model
 * <p>
 * describe:
 *
 * @author zhangdong on 2021/1/5
 * @version 1.0
 * @see .
 * @since 1.0
 */

class TestViewModel : ViewModel() {

    var liveData: MutableLiveData<Int> = MutableLiveData()

    private var cont: Int? = 0

    fun getInt(): Int? {
        return cont
    }

    override fun onCleared() {
        super.onCleared()
        println("--------onCleared---------")
    }

    fun setInt(i: Int?) {
        cont = i
        liveData.postValue(cont)
    }

}