/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.backend.js.checkers

import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.ir.IrDiagnosticReporter
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.backend.js.checkers.declarations.JsKlibEsModuleExportsChecker
import org.jetbrains.kotlin.ir.backend.js.checkers.declarations.JsKlibFileClashChecker
import org.jetbrains.kotlin.ir.backend.js.checkers.declarations.JsKlibOtherModuleExportsChecker
import org.jetbrains.kotlin.ir.backend.js.checkers.expressions.JsKlibJsCodeCallChecker
import org.jetbrains.kotlin.ir.declarations.IrDeclaration
import org.jetbrains.kotlin.ir.declarations.IrDeclarationWithName
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.visitors.IrVisitorVoid
import org.jetbrains.kotlin.ir.visitors.acceptChildrenVoid
import org.jetbrains.kotlin.library.SerializedIrFile

object JsKlibCheckers {
    private val moduleChecker = listOf(JsKlibFileClashChecker)

    private val exportedDeclarationsCheckers = listOf(
        JsKlibEsModuleExportsChecker,
        JsKlibOtherModuleExportsChecker
    )

    private val callCheckers = listOf(
        JsKlibJsCodeCallChecker
    )

    fun makeChecker(
        diagnosticReporter: IrDiagnosticReporter,
        configuration: CompilerConfiguration,
        doCheckCalls: Boolean,
        doModuleLevelChecks: Boolean,
        cleanFiles: List<SerializedIrFile> = listOf(),
        exportedNames: Map<IrFile, Map<IrDeclarationWithName, String>> = mapOf(),
    ): IrVisitorVoid {
        return object : IrVisitorVoid() {
            private val diagnosticContext = JsKlibDiagnosticContext(configuration)

            override fun visitElement(element: IrElement) {
                if (element is IrDeclaration) {
                    diagnosticContext.withDeclarationScope(element) {
                        element.acceptChildrenVoid(this)
                    }
                } else {
                    element.acceptChildrenVoid(this)
                }
            }

            override fun visitModuleFragment(declaration: IrModuleFragment) {
                if (doModuleLevelChecks) {
                    val exportedDeclarations = JsKlibExportingDeclaration.collectDeclarations(cleanFiles, declaration.files, exportedNames)
                    for (checker in exportedDeclarationsCheckers) {
                        checker.check(exportedDeclarations, this.diagnosticContext, diagnosticReporter)
                    }
                    for (checker in moduleChecker) {
                        checker.check(declaration, this.diagnosticContext, diagnosticReporter)
                    }
                }
                super.visitModuleFragment(declaration)
            }

            override fun visitFile(declaration: IrFile) {
                diagnosticContext.withFileScope(declaration) {
                    super.visitFile(declaration)
                }
            }

            override fun visitCall(expression: IrCall) {
                if (doCheckCalls)
                    for (checker in callCheckers) {
                        checker.check(expression, this.diagnosticContext, diagnosticReporter)
                    }
                super.visitCall(expression)
            }
        }
    }
}
