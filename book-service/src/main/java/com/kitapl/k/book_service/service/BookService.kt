package com.kitapl.k.book_service.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
            .stream()
            .map(BookDto::convert)
            .collect(Collectors.toList())
        }

     
   public BookDto findByIsbn(String isbn){
    return bookRepository.findBookByIsbn(isbn)
    .map(book -> new BookIdDto(book.getId, book.getIsbn()))
    .orElseThrow{() -> new BookNotFoundException("Book not found with isbn $isbn")}
   }         

   public BookDto findBookDetailsById(String id){
    return bookRepository.findById(id)
    .map(BookDto::convert)
    .orElseThrow{() -> new BookNotFoundException("Book not found with id $id")}

}


