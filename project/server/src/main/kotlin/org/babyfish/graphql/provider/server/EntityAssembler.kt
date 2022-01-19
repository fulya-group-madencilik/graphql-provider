package org.babyfish.graphql.provider.server

import org.babyfish.kimmer.Immutable
import org.babyfish.graphql.provider.server.dsl.EntityTypeDSL
import org.babyfish.graphql.provider.server.dsl.FilterDSL
import kotlin.reflect.KProperty1

interface EntityAssembler<E: Immutable> {

    fun EntityTypeDSL<E>.assemble()
}