/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

#include "testlib_api.h"
#define __ testlib_symbols()->

#include "libkt36878_api.h"

int main(int argc, char** argv) {
    libkt36878_kref_ObjectForExample   instance = __ kotlin.root.ObjectForExample._instance ();
    libkt36878_kref_ValueClass            value = __ kotlin.root.ObjectForExample.get_nullableVal (instance);
    libkt36878_kref_UsualClass            usual = __ kotlin.root.ObjectForExample.get_usual (instance);
    libkt36878_kref_kotlin_ByteArray uByteArray = __ kotlin.root.ObjectForExample.get_uByteArray (instance);
    libkt36878_kref_kotlin_IntArray   uIntArray = __ kotlin.root.ObjectForExample.get_uIntArray (instance);
    libkt36878_kref_Foo           fooValueClass = __ kotlin.root.ObjectForExample.get_fooValueClass (instance);
    libkt36878_kref_Foo           fooUsualClass = __ kotlin.root.ObjectForExample.get_fooValueClass (instance);
    __ kotlin.root.ObjectForExample.fooValue             (instance, value);
    __ kotlin.root.ObjectForExample.fooUsual             (instance, usual);
    __ kotlin.root.ObjectForExample.fooUByteArray        (instance, uByteArray);
    __ kotlin.root.ObjectForExample.fooUIntArrayNullable (instance, uIntArray);
    __ kotlin.root.ObjectForExample.fooFooValue          (instance, fooValueClass);
    __ kotlin.root.ObjectForExample.fooFooUsual          (instance, fooUsualClass);
}