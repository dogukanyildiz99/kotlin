/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

#include "testlib_api.h"
#define __ testlib_symbols()->

#include <stdio.h>

int main(int argc, char** argv) {
    __ kotlin.root.helloChar   ((libkt39496_kref_kotlin_Char)   {NULL});
    __ kotlin.root.helloByte   ((libkt39496_kref_kotlin_Byte)   {NULL});
    __ kotlin.root.helloShort  ((libkt39496_kref_kotlin_Short)  {NULL});
    __ kotlin.root.helloInt    ((libkt39496_kref_kotlin_Int)    {NULL});
    __ kotlin.root.helloLong   ((libkt39496_kref_kotlin_Long)   {NULL});
    __ kotlin.root.helloUByte  ((libkt39496_kref_kotlin_UByte)  {NULL});
    __ kotlin.root.helloUShort ((libkt39496_kref_kotlin_UShort) {NULL});
    __ kotlin.root.helloUInt   ((libkt39496_kref_kotlin_UInt)   {NULL});
    __ kotlin.root.helloULong  ((libkt39496_kref_kotlin_ULong)  {NULL});
    __ kotlin.root.helloFloat  ((libkt39496_kref_kotlin_Float)  {NULL});
    __ kotlin.root.helloDouble ((libkt39496_kref_kotlin_Double) {NULL});
}
