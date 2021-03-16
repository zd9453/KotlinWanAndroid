package com.zd.kotlinwanandroid

import android.app.Application

/**
 * Package: com.zd.kotlinwanandroid
 * <p>
 * describe:
 *
 * @author zhangdong on 2021/1/28
 * @version 1.0
 * @see .
 * @since 1.0
 */
class App : Application() {

    companion object {
        var appContext: App? = null
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

}