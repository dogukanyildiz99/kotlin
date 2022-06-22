/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

#include "testlib_api.h"
#define __ testlib_symbols()->


int main(int argc, char** argv) {
    dynamic_kref_Example ex(null);
    __ kotlin.root.ObjectForExample.hello(null, 1);
}