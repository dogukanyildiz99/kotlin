/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

#include "testlib_api.h"
#define __ testlib_symbols()->

#include "libkt36878_api.h"

int main(int argc, char** argv) {
    libkt36878_kref_ObjectForExample instance = __ kotlin.root.ObjectForExample._instance ();
    libkt36878_kref_ValueClass       value =    __ kotlin.root.ObjectForExample.get_nullableVal (instance);
    __ kotlin.root.ObjectForExample.fooValue             (instance, value);
    __ kotlin.root.ObjectForExample.fooUsual             (instance, (libkt36878_kref_UsualClass) {0});
    __ kotlin.root.ObjectForExample.fooUByteArray        (instance, (libkt36878_kref_kotlin_ByteArray){0});
    __ kotlin.root.ObjectForExample.fooUIntArrayNullable (instance, (libkt36878_kref_kotlin_IntArray) {0});
    __ kotlin.root.ObjectForExample.fooFooValue          (instance, (libkt36878_kref_Foo) {0});
    __ kotlin.root.ObjectForExample.fooFooUsual          (instance, (libkt36878_kref_Foo) {0});
}