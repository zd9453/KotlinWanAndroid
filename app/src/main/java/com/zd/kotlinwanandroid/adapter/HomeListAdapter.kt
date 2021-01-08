package com.zd.kotlinwanandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zd.kotlinwanandroid.R
import com.zd.kotlinwanandroid.bean.home.HomeListBean

/**
 * Package: com.zd.kotlinwanandroid.adapter
 * <p>
 * describe:
 *
 * @author zhangdong on 2021/1/8
 * @version 1.0
 * @see .
 * @since 1.0
 */
class HomeListAdapter : RecyclerView.Adapter<HomeListAdapter.Holder>() {

    private var listData: ArrayList<HomeListBean>? = null

    fun setData(list: ArrayList<HomeListBean>) {
        this.listData = list
        notifyDataSetChanged()
    }

    fun addData(list: ArrayList<HomeListBean>) {
        if (null == listData)
            listData = ArrayList()
        listData?.addAll(list)
        notifyDataSetChanged()
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val head: ImageView = itemView.findViewById(R.id.head_img)
        val name: TextView = itemView.findViewById(R.id.name)
        val content: TextView = itemView.findViewById(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return if (listData.isNullOrEmpty()) 0 else listData!!.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val bean = listData?.get(position)

        holder.content.text = bean?.content
        holder.name.text = bean?.name

        holder.head.setImageResource(bean!!.headImg)

    }

}