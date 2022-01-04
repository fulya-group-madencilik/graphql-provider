package org.babyfish.graphql.provider.kimmer.meta

import kotlin.reflect.KProperty1

interface ImmutableProp {

    val declaringType: ImmutableType

    val kotlinProp: KProperty1<*, *>

    val isNullable: Boolean

    val isAssociation: Boolean

    val isReference: Boolean

    val isList: Boolean

    val isConnection: Boolean

    val targetType: ImmutableType?

    val isTargetNullable: Boolean

    val name: String
        get() = kotlinProp.name
}