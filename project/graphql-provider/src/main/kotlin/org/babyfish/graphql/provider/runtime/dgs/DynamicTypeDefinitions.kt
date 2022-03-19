package org.babyfish.graphql.provider.runtime.dgs

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsTypeDefinitionRegistry
import graphql.schema.idl.TypeDefinitionRegistry
import org.babyfish.graphql.provider.meta.MetaProvider
import org.babyfish.graphql.provider.runtime.createTypeDefinitionRegistry

@DgsComponent
internal open class DynamicTypeDefinitions(
    private val metaProvider: MetaProvider
) {

    @DgsTypeDefinitionRegistry
    open fun registry(): TypeDefinitionRegistry =
        metaProvider.createTypeDefinitionRegistry()
}