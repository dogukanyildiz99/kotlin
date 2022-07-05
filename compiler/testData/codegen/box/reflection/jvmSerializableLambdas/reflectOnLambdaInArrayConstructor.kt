// !OPT_IN: kotlin.reflect.jvm.ExperimentalReflectionOnLambdas
// LANGUAGE: +GenerateIndyLambdasOnJvmByDefault
// TARGET_BACKEND: JVM_IR

// WITH_STDLIB
// WITH_REFLECT

import kotlin.jvm.JvmSerializableLambda

import kotlin.reflect.jvm.*
import kotlin.test.assertNotNull

fun box(): String {
    assertNotNull((@JvmSerializableLambda {}).reflect())
    assertNotNull(Array(1) {@JvmSerializableLambda {} }.single().reflect())

    return "OK"
}
