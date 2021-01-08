package com.zd.kotlinwanandroid.bean

/**
 * Package: com.zd.kotlinwanandroid.bean
 * <p>
 * describe: 顶层基类
 *
 * @author zhangdong on 2021/1/8
 * @version 1.0
 * @see .
 * @since 1.0
 */
abstract class BaseBean {

    //模块名
    var moduleName = ""

    abstract fun set(value: String)

}