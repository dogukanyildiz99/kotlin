// LANGUAGE: +GenerateIndyLambdasOnJvmByDefault
// FIR_IDENTICAL
// WITH_STDLIB

import kotlin.jvm.JvmSerializableLambda

val good1 = @JvmSerializableLambda { -> 1}
val good2 = @JvmSerializableLambda fun () = 1
val good3 = @JvmSerializableLambda fun Any.() = 1


<!BAD_JVM_SERIALIZABLE_LAMBDA, BAD_JVM_SERIALIZABLE_LAMBDA!>val bad1 = @JvmSerializableLambda 1<!>
<!BAD_JVM_SERIALIZABLE_LAMBDA, BAD_JVM_SERIALIZABLE_LAMBDA!>val bad2 = @JvmSerializableLambda object {}<!>
<!BAD_JVM_SERIALIZABLE_LAMBDA, BAD_JVM_SERIALIZABLE_LAMBDA!>val bad3 = @JvmSerializableLambda ::<!UNRESOLVED_REFERENCE!>foo<!><!>
