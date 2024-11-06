package com.kitapl.k.book_service.repository;

public interface BookRepository extends JpaRepository<Book, String>{
    Optional<Book> findBookByIsbn(String isbn)
}
