package by.flameksandr.books.services.impl;

import by.flameksandr.books.domain.Book;
import by.flameksandr.books.domain.BookEntity;
import by.flameksandr.books.repositories.BookRepository;
import by.flameksandr.books.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(final Book book) {
        BookEntity bookEntity = bookToBookEntity(book);
        final BookEntity savedBookEntity = bookRepository.save(bookEntity);
        return bookEntityToBook(bookEntity);
    }

    private BookEntity bookToBookEntity(Book book) {
        return BookEntity.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    private Book bookEntityToBook(BookEntity bookEntity) {
        return Book.builder()
                .isbn(bookEntity.getIsbn())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .build();
    }
}
