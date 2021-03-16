package com.zd.kotlinwanandroid

import android.content.Intent
import android.os.Bundle
import android.view.View.generateViewId
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zd.kotlinwanandroid.fragment.HomeFragment
import com.zd.kotlinwanandroid.model.LiveDataSingle
import com.zd.kotlinwanandroid.model.TestViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewModel: TestViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LiveDataSingle.live.observe(this, Observer {
            Toast.makeText(this, "this liveData $it", Toast.LENGTH_LONG).show()
        })

        viewModel = ViewModelProvider.AndroidViewModelFactory(App.appContext!!)
            .create(TestViewModel::class.java)

        viewModel?.liveData?.observe(this, Observer {
            Toast.makeText(this, "this liveData $it", Toast.LENGTH_LONG).show()
        })

        viewModel?.setInt(10)

        supportFragmentManager.beginTransaction()
//            .add(R.id.lay_replace, HomeFragment(R.layout.fragment_home))
            .add(R.id.lay_replace, HomeFragment.newInstance())
            .commitNow()

        val button = Button(this)
        button.id = generateViewId()
        button.text = "addView"

        flow.addView(button)

        layer.setOnClickListener {
            bt1.text = "中国"
            bt2.text = "大江大河"
            bt3.text = "1"
            bt4.text = "就是新年好呀新年好"
            bt5.text = "我们唱歌 我们跳舞"

            jump()
        }

    }

    private fun jump() {
        val intent = Intent(this, LiveDataTestActivity::class.java)
        startActivity(intent)
    }


    override fun onResume() {
        super.onResume()
        Toast.makeText(this, viewModel?.getInt().toString(), Toast.LENGTH_SHORT).show()
//        viewModel?.setInt((viewModel?.getInt()))
    }

}
