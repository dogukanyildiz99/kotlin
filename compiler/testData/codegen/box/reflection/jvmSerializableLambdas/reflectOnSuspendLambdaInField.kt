// !OPT_IN: kotlin.reflect.jvm.ExperimentalReflectionOnLambdas
// LANGUAGE: +GenerateIndyLambdasOnJvmByDefault
// TARGET_BACKEND: JVM_IR

// WITH_STDLIB
// WITH_REFLECT

import kotlin.reflect.jvm.reflect

class C {
    val x: suspend (String) -> Unit = { OK: String -> }
}

fun box(): String {
    return C().x.reflect()?.parameters?.singleOrNull()?.name ?: "null"
}