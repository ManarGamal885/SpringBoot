package com.example.demo.Book;

import com.example.demo.Author.Author;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Retrieve all books.
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //Create a new book
    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    //Retrieve a single book by ID.
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException("Book with ID " + bookId + " does not exist."));
    }

    //Update a book by ID.
    public void updateBook(Long bookId, String title, Author author, LocalDate publishedDate) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException("Book with ID " + bookId + " does not exist."));
        if (title != null && title.length() > 0 && !title.equals(book.getTitle())) {
            book.setTitle(title);
        }
        if (author != null && !author.getId().equals(book.getAuthor().getId())) {
            book.setAuthor(author);
        }
        if (publishedDate != null && !publishedDate.equals(book.getPublishedDate())) {
            book.setPublishedDate(publishedDate);
        }
        bookRepository.save(book);
    }

    //Delete a book by ID.
    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists) {
            throw new IllegalStateException("Book with ID " + bookId + " does not exist.");
        }
        bookRepository.deleteById(bookId);
    }
}
