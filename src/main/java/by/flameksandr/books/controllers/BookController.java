package by.flameksandr.books.controllers;

import by.flameksandr.books.domain.Book;
import by.flameksandr.books.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<Book> createBook(
            @PathVariable final String isbn,
            @RequestBody final Book book){
        book.setIsbn(isbn);
        final Book savedBook = bookService.create(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
}
