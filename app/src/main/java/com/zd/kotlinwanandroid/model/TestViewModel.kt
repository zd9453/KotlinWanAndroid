package com.zd.kotlinwanandroid.model

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

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

class TestViewModel(application: Application) : AndroidViewModel(application) {

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

//        val application = getApplication<Application>()
//        Toast.makeText(application, "$cont", Toast.LENGTH_SHORT).show()
    }

}