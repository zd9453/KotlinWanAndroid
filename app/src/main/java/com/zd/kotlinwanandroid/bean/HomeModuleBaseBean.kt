package com.zd.kotlinwanandroid.bean

/**
 * Package: com.zd.kotlinwanandroid.bean
 * <p>
 * describe:
 *
 * @author zhangdong on 2021/1/8
 * @version 1.0
 * @see .
 * @since 1.0
 */
open class HomeModuleBaseBean : BaseBean() {

    override fun set(value: String) {
        moduleName = "首页模块Bean"
    }

}