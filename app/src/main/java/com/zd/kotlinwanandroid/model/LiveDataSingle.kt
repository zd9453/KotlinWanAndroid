package com.zd.kotlinwanandroid.model

import androidx.lifecycle.MutableLiveData

/**
 * Package: com.zd.kotlinwanandroid.model
 * <p>
 * describe:
 *
 * @author zhangdong on 2021/1/28
 * @version 1.0
 * @see .
 * @since 1.0
 */
object LiveDataSingle {

    var cont: Int = 0
    val live: MutableLiveData<Int> = MutableLiveData()

    fun getValue(): Int {
        live.value = cont
        return cont
    }

    fun postValue(value: Int) {
        cont = value
        live.postValue(value)
    }

}