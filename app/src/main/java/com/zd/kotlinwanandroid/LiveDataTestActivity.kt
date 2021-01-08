package com.zd.kotlinwanandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zd.kotlinwanandroid.fragment.BlankFragment
import com.zd.kotlinwanandroid.fragment.BottomFragment

class LiveDataTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_test)


//        supportFragmentManager.beginTransaction().show(fragment1).commit()

        val newInstance = BlankFragment.newInstance()

        val newIns = BottomFragment.newInstance("bottom")


    }
}