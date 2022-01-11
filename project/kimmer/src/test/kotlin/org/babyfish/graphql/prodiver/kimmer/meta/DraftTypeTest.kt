package org.babyfish.graphql.prodiver.kimmer.meta

import org.babyfish.graphql.prodiver.kimmer.*
import org.babyfish.graphql.provider.kimmer.meta.ImmutableType
import kotlin.test.Test
import kotlin.test.expect

class DraftTypeTest {

    @Test
    fun testNodeDraft() {
        val immutableType = ImmutableType.of(Node::class)
        expect(immutableType) {
            ImmutableType.fromDraftType(NodeDraft::class)
        }
        expect(immutableType) {
            ImmutableType.fromDraftType(NodeDraft.Sync::class)
        }
        expect(immutableType) {
            ImmutableType.fromDraftType(NodeDraft.Async::class)
        }
    }

    @Test
    fun testBookStoreDraft() {
        val immutableType = ImmutableType.of(BookStore::class)
        expect(immutableType) {
            ImmutableType.fromDraftType(BookStoreDraft::class)
        }
        expect(immutableType) {
            ImmutableType.fromDraftType(BookStoreDraft.Sync::class)
        }
        expect(immutableType) {
            ImmutableType.fromDraftType(BookStoreDraft.Async::class)
        }
    }

    @Test
    fun testBookDraft() {
        val immutableType = ImmutableType.of(Book::class)
        expect(immutableType) {
            ImmutableType.fromDraftType(BookDraft::class)
        }
    }

    @Test
    fun testAuthorDraft() {
        val immutableType = ImmutableType.of(Author::class)
        expect(immutableType) {
            ImmutableType.fromDraftType(AuthorDraft::class)
        }
        expect(immutableType) {
            ImmutableType.fromDraftType(AuthorDraft.Sync::class)
        }
        expect(immutableType) {
            ImmutableType.fromDraftType(AuthorDraft.Async::class)
        }
    }
}