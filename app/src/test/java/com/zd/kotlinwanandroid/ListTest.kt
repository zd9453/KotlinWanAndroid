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

        listAbout()
//        setAbout()


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
        //不可变
        val listT = listOf<Int>(1, 2, 3, 45, 6, 7)
        println(listT)

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