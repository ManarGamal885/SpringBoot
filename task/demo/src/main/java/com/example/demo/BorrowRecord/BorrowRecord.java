package com.example.demo.BorrowRecord;

import com.example.demo.Book.Book;
import com.example.demo.Borrower.Borrower;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
@Table(name = "borrow_records")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    @JsonBackReference
    @NotNull(message = "Borrower is mandatory")
    private Borrower borrower;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference
    @NotNull(message = "Book is mandatory")
    private Book book;

    @PastOrPresent(message = "Borrow date should be in the past or present")
    private LocalDate borrowDate;
    @PastOrPresent(message = "Return date should be in the past or present")
    private LocalDate returnDate;

    public BorrowRecord() {}

    public BorrowRecord(Borrower borrower, Book book, LocalDate borrowDate, LocalDate returnDate) {
        this.borrower = borrower;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
