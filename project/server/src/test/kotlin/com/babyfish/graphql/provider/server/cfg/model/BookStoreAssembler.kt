package com.babyfish.graphql.provider.server.cfg.model

import com.babyfish.graphql.provider.server.cfg.Book
import com.babyfish.graphql.provider.server.cfg.BookStore
import org.babyfish.graphql.provider.server.EntityAssembler
import org.babyfish.graphql.provider.server.dsl.EntityTypeDSL
import org.babyfish.graphql.provider.server.runtime.ilike
import org.springframework.stereotype.Component

@Component
class BookStoreAssembler(
    private val bookRepository: BookRepository
): EntityAssembler<BookStore> {

    override fun EntityTypeDSL<BookStore>.assemble() {

        id(BookStore::id)

        mappedList(BookStore::books, Book::store) {

            optionalArgument("name", String::class) {
                where(table[Book::name] ilike it)
            }
            filter {
                orderBy(Book::name)
                redis {
                    dependsOn(Book::name)
                }
            }
        }

        computed(BookStore::avgPrice) {

            batchImplementation {
                bookRepository.findAvgPrices(rows.map { it.id })
            }

            redis {
                dependsOnList(BookStore::books) {
                    dependsOn(Book::price)
                }
            }
        }
    }
}

