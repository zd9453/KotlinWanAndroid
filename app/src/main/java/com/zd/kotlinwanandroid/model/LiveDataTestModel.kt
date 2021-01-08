package com.zd.kotlinwanandroid.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Package: com.zd.kotlinwanandroid.model
 * <p>
 * describe:
 *
 * @author zhangdong on 2021/1/8
 * @version 1.0
 * @see .
 * @since 1.0
 */
class LiveDataTestModel : ViewModel() {

    var progressV: MutableLiveData<Int>? = null
        get() {
            if (field == null)
                field = MutableLiveData()
            return field
        }
        //可以私有化set方法保证外部不可修改
        private set

    override fun onCleared() {
        super.onCleared()
        progressV = null
    }

}