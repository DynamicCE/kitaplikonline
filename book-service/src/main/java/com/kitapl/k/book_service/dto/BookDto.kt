package com.kitapl.k.book_service.dto

import com.kitapl.k.book_service.model.Book

data class BookDto
@JvmOverloads
constructor(
        val id: BookIdDto? = null,
        val title: String?,
        val bookYear: String,
        val author: String,
        val pressName: String
) {
    companion object {
        @JvmStatic
        fun convert(from: Book): BookDto {
            return BookDto(
                    from.id?.let { BookIdDto.convert(it, from.isbn) },
                    from.title,
                    from.bookYear,
                    from.author,
                    from.pressName
            )
        }
    }
}