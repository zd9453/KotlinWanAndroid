package com.zd.kotlinwanandroid.utils

/**
 * Package: com.zd.kotlinwanandroid.utils
 * <p>
 * describe:
 *
 * @author zhangdong on 2021/1/11
 * @version 1.0
 * @see .
 * @since 1.0
 */
object DisplayUtil {

    fun stringGet(content: String, len: Int): String {
        if (content.isNotEmpty() || content.length <= len)
            return "${content}呵呵"

        return content
    }
}