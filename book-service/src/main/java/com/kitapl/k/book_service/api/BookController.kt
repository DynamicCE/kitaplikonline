package com.kitapl.k.book_service.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController{
private final BookService bookService;

public BookController(BookService bookService){
    this.bookService = bookService;
}

@GetMapping
public ResponseEntity<List<BookDto>> getAllBooks(){
    return ResponseEntity.ok(bookService.getAllBooks());
}

@GetMapping("/isbn/{isbn}")
public ResponseEntity<BookDto> getBookByIsbn(@PathVariable @NotEmpty String isbn){
    return ResponseEntity.ok(bookService.findByIsbn(isbn));
}

@GetMapping("/book/{id}")
public ResponseEntity<BookDto> getBookyId(@PathVariable @NotEmpty String id){
    return ResponseEntity.ok(bookService.findBookDetailsById(id));
}


}