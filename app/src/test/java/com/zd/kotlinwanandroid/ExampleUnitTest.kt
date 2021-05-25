package com.zd.kotlinwanandroid

import androidx.annotation.StringDef
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testMethod() {

        val arrayListOf = arrayListOf(8, 1, 2, 34, 5)

//        arrayListOf.forEach {
//            print("$it ")
//        }
//        println()
//
//        start@
//        for ((index, item) in arrayListOf.withIndex()) {
//            if (index==2) {
//                continue@start
//            }
//            println("$index  ->  $item")
//        }

//        for (item in arrayListOf.indices)
//            println(arrayListOf[item])

//        for (item in arrayListOf)
//            println(item)

//        println(arrayListOf.lastIndex)

//        showMsg("小明", 2)
//        showMsg("Tom", 3, "男二")
//        showMsg(name = "Sum", sex = "那么", age = 10)

//        showChangeMsg("this", "thisCreate", "thisTest", "thisIs")

//        val em = Em("jack")
//        em display 18
//        em.display(9)

//        val em = Em("tom")
//        em.display(90)

//        val testF = { list: ArrayList<Int> ->
//            list.forEach {
//                print("$it ")
//            }
//        }
//        kotlin.run { testF(arrayListOf) }
//        testF(arrayListOf)

//        val funT: (Int, Int) -> Int
//        funT = { a, b -> a + b }
//        println(funT(4, 1))

//        comp(1, 5)
//        comp("a", "b")
//        comp(1f, 4f)
//        comp(6, 1)


//        val m: Main = Em("12")
//        println("${m.type}  ${m.hi}")
//        m.eat()
//        m.logMsg()
//        showMsg(TypeA.TYPE1, 1)

        val a = M("呵呵")
        a.show()

        val b = M(10)
        b.show()

        val c = M("jack", 18)
        c.show()

        showMsg(name = "fairytale", age = 100)

    }

    private fun showMsg(@TypeA name: String, age: Int, sex: String = "男") {
        println("$name age:$age  sex:$sex")
    }


    private fun showChangeMsg(vararg str: String) {
        str.forEach { println(it) }
    }

    open class Em(@TypeA var name: String) : Main {

        private var age: Int = 0

        constructor(a: Int) : this("tom") {
            this.age = a
        }

        infix fun display(num: Int) {
            println("$name ->  $num")
        }

        override val type: String
            get() = "$name Type"

        override fun eat() {
            println("$name eat something")
        }
    }

    private fun <T> comp(a: T, b: T): Unit where T : Comparable<T>, T : Any {
        if (a > b) {
            println("$a > $b")
        } else
            println("$a <= $b")
    }

    interface Main {
        val type: String
        val hi: Int
            get() = 1

        fun eat()

        fun logMsg() {
            println("$type $hi")
        }
    }

    enum class Day {
        Day1, Day2
    }


    @Retention(AnnotationRetention.SOURCE)
    @Target(
        AnnotationTarget.PROPERTY,
        AnnotationTarget.VALUE_PARAMETER
    )
    @StringDef(TypeA.TYPE1, TypeA.TYPE2, TypeA.TYPE3)
    annotation class TypeA {
        companion object {
            const val TYPE1 = "jack"
            const val TYPE2 = "Tony"
            const val TYPE3 = "Tom"
        }
    }

    class M : Em {
        private var age = 1

        constructor(name: String) : super(name) {
            this.name = name
        }

        constructor(name: String, age: Int) : super(name) {
            this.name = name
            this.age = age
        }


        constructor(age: Int) : super("tom") {
            this.age = age
        }

        fun show() {
            println("$name $age")
        }
    }

    open class A {
        open fun eat() {}
    }

    open class B {
        open fun eat() {}
    }

    class C : A(), Main {
        override val type: String
            get() = ""

    }

    class FG : A, Main {

        constructor() : super() {}

        override val type: String
            get() = "superType"

    }
}
