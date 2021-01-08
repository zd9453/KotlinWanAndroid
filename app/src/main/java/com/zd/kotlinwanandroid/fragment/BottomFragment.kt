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
import com.zd.kotlinwanandroid.R
import com.zd.kotlinwanandroid.model.LiveDataTestModel
import kotlinx.android.synthetic.main.blank_fragment.*

class BottomFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

    companion object {
        fun newInstance(name: String): BottomFragment {
            val fragment = BottomFragment()
            val bundle = Bundle()
            bundle.putString("", name)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var viewModel: LiveDataTestModel
    private var liveData: MutableLiveData<Int>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(activity!!).get(LiveDataTestModel::class.java)
        liveData = viewModel.progressV

        liveData?.observe(this, Observer {
            seekBar.progress = it
        })

        seekBar.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        liveData?.postValue(p1)
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }

}