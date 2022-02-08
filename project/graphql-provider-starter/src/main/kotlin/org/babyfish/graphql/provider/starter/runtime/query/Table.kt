package org.babyfish.graphql.provider.starter.runtime.query

import org.babyfish.kimmer.Immutable
import kotlin.reflect.KProperty1

interface Table<T: Immutable> {

    operator fun <X> get(
        prop: KProperty1<T, X?>
    ): Expression<X>
}