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
        println(foo)
    }
    fun fooUsual(foo: UsualClass?) {
        println(foo)
    }
    fun fooUByteArray(foo: UByteArray) {
        println(foo)
    }
    fun fooUIntArrayNullable(foo: UIntArray?) {
        println(foo)
    }
    fun fooFooValue(foo: Foo<ValueClass>) {
        println(foo)
    }
    fun fooFooUsual(foo: Foo<UsualClass>) {
        println(foo)
    }
}