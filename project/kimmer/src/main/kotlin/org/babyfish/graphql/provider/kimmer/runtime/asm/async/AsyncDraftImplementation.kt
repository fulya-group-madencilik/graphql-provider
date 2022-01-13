package org.babyfish.graphql.provider.kimmer.runtime.asm.async

import org.babyfish.graphql.provider.kimmer.AsyncDraft
import org.babyfish.graphql.provider.kimmer.Immutable
import org.babyfish.graphql.provider.kimmer.meta.ImmutableType
import org.babyfish.graphql.provider.kimmer.runtime.asm.defineClass
import org.springframework.asm.ClassWriter
import java.util.*
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

internal fun asyncDraftImplementationOf(modelType: Class<out Immutable>): Class<out AsyncDraft<*>> =
    cacheLock.read {
        cacheMap[modelType]
    } ?: cacheLock.write {
        cacheMap[modelType]
            ?: createAsyncDraftImplementation(modelType).let {
                cacheMap[modelType] = it
                it
            }
    }

private val cacheMap = WeakHashMap<Class<out Immutable>, Class<out AsyncDraft<*>>>()

private val cacheLock = ReentrantReadWriteLock()

internal fun createAsyncDraftImplementation(
    modelType: Class<out Immutable>
): Class<out AsyncDraft<*>> {
    return ClassWriter(ClassWriter.COMPUTE_MAXS or ClassWriter.COMPUTE_FRAMES).apply {
        writeType(ImmutableType.of(modelType))
    }.toByteArray().let {
        modelType.classLoader.defineClass(it)
    } as Class<out AsyncDraft<*>>
}