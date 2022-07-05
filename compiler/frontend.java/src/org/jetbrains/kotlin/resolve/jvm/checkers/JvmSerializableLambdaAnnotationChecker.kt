/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.resolve.jvm.checkers

import org.jetbrains.kotlin.config.LanguageFeature
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.diagnostics.Errors
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.BindingContext.ANNOTATION
import org.jetbrains.kotlin.resolve.checkers.DeclarationChecker
import org.jetbrains.kotlin.resolve.checkers.DeclarationCheckerContext
import org.jetbrains.kotlin.resolve.jvm.annotations.JVM_SERIALIZABLE_LAMBDA_ANNOTATION_FQ_NAME
import org.jetbrains.kotlin.resolve.jvm.diagnostics.ErrorsJvm

object JvmSerializableLambdaAnnotationChecker : DeclarationChecker {
    override fun check(declaration: KtDeclaration, descriptor: DeclarationDescriptor, context: DeclarationCheckerContext) {
        declaration.accept(object : KtTreeVisitorVoid() {
            override fun visitAnnotatedExpression(expression: KtAnnotatedExpression) {
                expression.annotationEntries.firstOrNull {
                    context.trace.bindingContext.get(ANNOTATION, it)?.fqName == JVM_SERIALIZABLE_LAMBDA_ANNOTATION_FQ_NAME
                }?.let { annotationEntry ->
                    if (!context.languageVersionSettings.supportsFeature(LanguageFeature.GenerateIndyLambdasOnJvmByDefault)) {
                        context.trace.report(
                            Errors.UNSUPPORTED_FEATURE.on(
                                annotationEntry,
                                LanguageFeature.GenerateIndyLambdasOnJvmByDefault to context.languageVersionSettings
                            )
                        )
                    } else if (expression.baseExpression.let { (it !is KtLambdaExpression) && !(it is KtNamedFunction && it.name == null) }) {
                        context.trace.report(ErrorsJvm.BAD_JVM_SERIALIZABLE_LAMBDA.on(declaration))
                    }
                }
                super.visitAnnotatedExpression(expression)
            }
        }, null)
    }
}