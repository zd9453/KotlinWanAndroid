package com.zd.kotlinwanandroid

import org.junit.Test

/**
 * Package: com.zd.kotlinwanandroid
 * <p>
 * describe: kotlin集合相关的test
 *
 * @author zhangdong on 2021/5/25
 * @version 1.0
 * @see .
 * @since 1.0
 */
class ListTest {

    @Test
    fun mainTest() {
        println("this is ListTest mainTest")

//        listAbout()
//        setAbout()
//        regexAbout()
        functionAbout()

    }

    /**
     * 自定义函数
     */
    private fun functionAbout() {
        displayMsg()
        displayMsg("this is show")
        displayMsg(cont = 2)
        displayMsg("test information", 6)


    }

    private infix fun show(msg: String) {
        println(msg)
    }

    private fun displayMsg(content: String = "default message", cont: Int = 1) {
        println("displayMsg $cont ->: $content ")
    }

    /**
     * 正在表达式相关测试
     */
    private fun regexAbout() {
        val contentStr = "MMTest007"
        val phone = "12345678901"

        val split = contentStr.split("[t|T]".toRegex())
        println(split)

        println("MMTest(\\d){3}".toRegex().matches(contentStr))

        println(contentStr.matches("^MM.+".toRegex()))
        println(contentStr.matches("(\\w)*007$".toRegex()))
        println(contentStr.matches("^[a-zA-Z]+007$".toRegex()))

        println(phone.matches("(\\d){8,11}".toRegex()))

        //替换中间的为****
        println(phone.replace("(\\d{3})(\\d{4})(\\d{4})".toRegex(), "$1****$3"))

    }

    /**
     * set去重通过hashCode值判断
     */
    private fun setAbout() {
        val of = setOf("this", 1, 'c')
        println(of)

        val mutableSetOf = mutableSetOf<Any>()
        mutableSetOf.add("text")
        mutableSetOf.add(1.0)
        mutableSetOf.add(6)
        mutableSetOf.add(6)

        println(mutableSetOf.size)
        mutableSetOf.add(H("zhang", 10))
        mutableSetOf.add(H("zhang", 10))
        mutableSetOf.add(H("zhang", 1))
        println(mutableSetOf.size)
        println(mutableSetOf)

        println(mutableSetOf.contains(H("zhang", 1)))
        mutableSetOf.remove(1.0)
        println(mutableSetOf)
    }

    /**
     * list查找equals判断
     */
    private fun listAbout() {
        //不可变集合
        val listT = listOf<Int>(1, 2, 3, 45, 6, 7)

        for ((i, item) in listT.withIndex()) {
            println("$i  $item")
            if (item % 2 == 0)
                println(item shr 1)     //右移1为 相当于/2
            else
                println(item shl 1)     //左移1位 相当于*2
        }

        //反转
        val reversed = listT.reversed()
        println("反转：$reversed")
        //升序
        val sorted = listT.sorted()
        println(sorted)
        //降序
        val sortedDescending = listT.sortedDescending()
        println(sortedDescending)

        //可变
        val listR = mutableListOf<Any>()
        val mutableListOf = mutableListOf(1, 2, 3)
        listR.add(1)
        listR.add(2)
        listR.add(3)
        listR.add(3)
        listR.add(H("zhang", 1))
        println(listR.contains(H("zhang", 1)))
        println(listR)
        listR.remove(3)
        println(listR)

        //空集合
        val emptyList = emptyList<Int>()

        //用分割集合 用map来装
        val groupBy = mutableListOf.groupBy {
            if (it % 3 == 0) "test"
            else "other"
        }
        println(groupBy)

        //拆分集合 true的为一组 first  false的为一组 second
        val partition = listR.partition {
            //true的为一组 first  false的为一组 second
            (it is Int)
        }
        println(partition.first)
        println(partition.second)


    }

    class H(val name: String, val age: Int) {

        /*override fun equals(other: Any?): Boolean {
            if (other is H)
                return (other.age == this.age && other.name == this.name)
            return super.equals(other)
        }*/

    }
}