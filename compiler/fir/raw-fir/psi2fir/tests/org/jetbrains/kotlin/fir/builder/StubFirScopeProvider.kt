/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.builder

import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.declarations.FirClass
import org.jetbrains.kotlin.fir.declarations.FirResolvePhase
import org.jetbrains.kotlin.fir.declarations.FirTypeAlias
import org.jetbrains.kotlin.fir.resolve.ScopeSession
import org.jetbrains.kotlin.fir.scopes.FirContainingNamesAwareScope
import org.jetbrains.kotlin.fir.scopes.FirScope
import org.jetbrains.kotlin.fir.scopes.FirScopeProvider
import org.jetbrains.kotlin.fir.scopes.FirTypeScope

object StubFirScopeProvider : FirScopeProvider() {
    override fun getUseSiteMemberScope(
        klass: FirClass,
        useSiteSession: FirSession,
        scopeSession: ScopeSession,
        memberRequiredPhase: FirResolvePhase?,
    ): FirTypeScope = error("Stub")

    override fun getTypealiasConstructorScope(
        typeAlias: FirTypeAlias,
        useSiteSession: FirSession,
        scopeSession: ScopeSession,
    ): FirScope = error("Stub")

    override fun getStaticCallableMemberScope(
        klass: FirClass,
        useSiteSession: FirSession,
        scopeSession: ScopeSession
    ): FirContainingNamesAwareScope? = null

    override fun getStaticCallableMemberScopeForBackend(
        klass: FirClass,
        useSiteSession: FirSession,
        scopeSession: ScopeSession,
    ): FirContainingNamesAwareScope? = null

    override fun getNestedClassifierScope(
        klass: FirClass,
        useSiteSession: FirSession,
        scopeSession: ScopeSession,
    ): FirContainingNamesAwareScope? = null
}
