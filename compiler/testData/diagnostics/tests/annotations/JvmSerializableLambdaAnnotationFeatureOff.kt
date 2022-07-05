// LANGUAGE: -GenerateIndyLambdasOnJvmByDefault
// FIR_IDENTICAL
// WITH_STDLIB

import kotlin.jvm.JvmSerializableLambda

fun foo {}

val good1 = @JvmSerializableLambda { -> 1}
val good2 = @JvmSerializableLambda fun () = 1
val good3 = @JvmSerializableLambda fun Any.() = 1

val bad1 = @JvmSerializableLambda 1
val bad2 = @JvmSerializableLambda object {}
val bad3 = @JvmSerializableLambda ::foo

