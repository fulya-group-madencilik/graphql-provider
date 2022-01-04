package org.babyfish.graphql.provider.kimmer

import kotlinx.coroutines.delay
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1

interface Immutable {

    companion object {

        fun <T: Immutable> isLoaded(o: T, prop: KProperty1<T, *>): Boolean {
            return true
        }

        fun <T: Immutable> isUnloaded(o: T, prop: KProperty1<T, *>): Boolean {
            return false
        }

        fun <T: Immutable> getThrowable(o: T, prop: KProperty1<T, *>): Throwable? {
            return null
        }
    }
}

interface Connection<N> {

    val edges: List<Edge<N>>

    interface Edge<N> {
        val node: N
        val cursor: String
    }
}

@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class DraftDsl

@DraftDsl
interface Draft<out T: Immutable>

interface SyncDraft<out T: Immutable>: Draft<T> {

    fun <X: Any, D: SyncDraft<X>> new(
        draftType: KClass<D>,
        base: X? = null,
        block: D.() -> Unit
    ): D
}

@DraftDsl
interface AsyncDraft<out T: Immutable>: Draft<T> {

    suspend fun <X: Any, D: AsyncDraft<X>> new(
        draftType: KClass<D>,
        base: X? = null,
        block: suspend D.() -> Unit
    ): D
}

fun <T: Any, D: SyncDraft<T>> new(
    draftType: KClass<D>,
    base: T? = null,
    block: D.() -> Unit
): T {
    TODO()
}

suspend fun <T: Any, D: AsyncDraft<T>> new(
    draftType: KClass<D>,
    base: T? = null,
    block: suspend D.() -> Unit
): T {

    delay(1000)
    TODO()
}
