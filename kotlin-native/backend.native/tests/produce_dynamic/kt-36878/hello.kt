/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

value class ValueClass(val number: Int) {}
class UsualClass(val number: UInt) {}
class Foo<T>

object ObjectForExample {
    val nullableVal: ValueClass? = ValueClass(153)
    fun fooValue(foo: ValueClass?) {
        println("ValueClass? = $foo")
    }
    fun fooUsual(foo: UsualClass?) {
        println("UsualClass? = $foo")
    }
    fun fooUByteArray(foo: UByteArray) {
        println("UByteArray = $foo")
    }
    fun fooUIntArrayNullable(foo: UIntArray?) {
        println("UIntArray? = $foo")
    }
    fun fooFooValue(foo: Foo<ValueClass>) {
        println("Foo<ValueClass> = $foo")
    }
    fun fooFooUsual(foo: Foo<UsualClass>) {
        println("Foo<UsualClass> = $foo")
    }
}