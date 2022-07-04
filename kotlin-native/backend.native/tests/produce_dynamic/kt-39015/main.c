/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

#include "testlib_api.h"
#define __ testlib_symbols()->

#include "libkt39015_api.h"
#include <stdio.h>

int main(int argc, char** argv) {
    libkt39015_kref_ObjectForExample instance = __ kotlin.root.ObjectForExample._instance ();
    libkt39015_kref_Example          value =    __ kotlin.root.ObjectForExample.get_example (instance);
    printf("%x\n", value.pinned);
}
