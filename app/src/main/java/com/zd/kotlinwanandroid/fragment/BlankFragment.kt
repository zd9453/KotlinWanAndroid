package com.zd.kotlinwanandroid.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zd.kotlinwanandroid.R
import com.zd.kotlinwanandroid.adapter.HomeListAdapter
import com.zd.kotlinwanandroid.bean.home.HomeListBean
import com.zd.kotlinwanandroid.model.LiveDataTestModel
import kotlinx.android.synthetic.main.blank_fragment.*
import kotlinx.coroutines.*

class BlankFragment : Fragment(), SeekBar.OnSeekBarChangeListener, HomeListAdapter.ItemListener {

    companion object {
        fun newInstance() = BlankFragment()
    }

    private lateinit var viewModel: LiveDataTestModel
    private var liveData: MutableLiveData<Int>? = null
    private var adapter: HomeListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(it).get(LiveDataTestModel::class.java)
            liveData = viewModel.progressV
        }

        liveData?.observe(this, Observer {
            seekBar.progress = it
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                liveData?.postValue(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        rcv_list.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = HomeListAdapter()
        rcv_list.adapter = adapter

        var data = ArrayList<HomeListBean>()
        var listMore = ArrayList<Any>()

        for (i in 0 until 15) {
            data.add(HomeListBean("名字$i", "this is content $i"))
        }
        adapter?.setData(data)

        adapter?.listener = this


        runBlocking {
            Log.e(">>>>>>>>", "---------runBlocking ")
            withContext(Dispatchers.IO) {
                Log.e(">>>>>>>>", "---------runBlocking in IO")
            }
            Log.e(">>>>>>>>", "---------runBlocking in last")
        }

        Log.e(">>>>>>>>", "---------runBlocking out")

        GlobalScope.launch {
            getFile()
        }

        val async = GlobalScope.async {
            getFile()
        }

        GlobalScope.async {
            Thread.sleep(10000)
        }

    }

    suspend fun getFile() {
        Thread.sleep(5000)
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        liveData?.postValue(p1)
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }

    override fun itemClick(position: Int, string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

}