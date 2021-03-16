package com.zd.kotlinwanandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.zd.kotlinwanandroid.fragment.BlankFragment
import com.zd.kotlinwanandroid.fragment.BottomFragment
import com.zd.kotlinwanandroid.model.LiveDataSingle
import com.zd.kotlinwanandroid.model.TestViewModel

class LiveDataTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_test)


//        supportFragmentManager.beginTransaction().show(fragment1).commit()

        val newInstance = BlankFragment.newInstance()

        val newIns = BottomFragment.newInstance("bottom")

        var viewModel = ViewModelProvider.AndroidViewModelFactory(App.appContext!!)
            .create(TestViewModel::class.java)


        viewModel.setInt(10086)

        if (LiveDataSingle.cont == 0) {
            LiveDataSingle.postValue(10086)
        } else {
            LiveDataSingle.postValue(LiveDataSingle.cont + 1)
        }
    }
}