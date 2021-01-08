package com.zd.kotlinwanandroid.fragment

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zd.kotlinwanandroid.R
import com.zd.kotlinwanandroid.model.TestViewModel

/**
 * Package: com.zd.kotlinwanandroid.fragment
 * <p>
 * describe:
 *
 * @author zhangdong on 2020/12/7
 * @version 1.0
 * @see .
 * @since 1.0
 */
class HomeFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): HomeFragment {
            val arg = Bundle()
            arg.putString("tag", "this tag")
            val fragment = HomeFragment()
            fragment.arguments = arg
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        if (view is ViewGroup) {

            val childAt = view.getChildAt(0)

            childAt.post {
                val rect = Rect()
                childAt.getLocalVisibleRect(rect)

                println("this ${rect.left}, ${rect.top}, ${rect.right}, ${rect.bottom} ")

                println("this ${childAt.left}, ${childAt.top}, ${childAt.width}, ${childAt.height} ")

                childAt.animation =
                    RotateAnimation(
                        0f,
                        180f,
                        childAt.left + childAt.width / 2f,
                        childAt.top + childAt.height / 2f
                    )
                childAt.animation.duration = 10000
                childAt.animation.start()
            }
        }

        return view
    }

    override fun onResume() {
        super.onResume()
//        initData()
    }

    private fun initData() {
        val viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        val int = viewModel.getInt()
        Toast.makeText(context, int.toString(), Toast.LENGTH_SHORT).show()
    }


}