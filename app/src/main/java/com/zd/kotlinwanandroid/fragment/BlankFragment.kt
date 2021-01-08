package com.zd.kotlinwanandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
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

class BlankFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

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
        viewModel = ViewModelProvider(activity!!).get(LiveDataTestModel::class.java)
        liveData = viewModel.progressV

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

        for (i in 0..15) {
            data.add(HomeListBean("名字$i", "this is content $i"))
        }
        adapter?.setData(data)

    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        liveData?.postValue(p1)
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }

}