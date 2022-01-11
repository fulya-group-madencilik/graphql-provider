package org.babyfish.graphql.prodiver.kimmer

import org.babyfish.graphql.provider.kimmer.Abstract
import org.babyfish.graphql.provider.kimmer.Immutable
import java.math.BigDecimal

interface Node: Immutable {
    val id: String
}

interface BookStore: Node {
    val name: String
    val books: List<Book>
    val avgPrice: BigDecimal
}

@Abstract
interface Book: Node {
    val name: String
    val price: BigDecimal
    val store: BookStore?
    val authors: List<Author>
}

interface ElectronicBook: Book

interface PaperBook: Book

interface Author: Node {
    val name: String
    val books: List<Book>
}
