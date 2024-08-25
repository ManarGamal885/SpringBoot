package com.example.demo.Book;

import com.example.demo.Author.Author;
import com.example.demo.BorrowRecord.BorrowRecord;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Book(Author author, String title, Integer isbn, String name, LocalDate publishedDate, Set<BorrowRecord> borrowRecords) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.name = name;
        this.publishedDate = publishedDate;
        this.borrowRecords = borrowRecords;
    }

    public Book(Long id, Author author, String title, Integer isbn, String name, LocalDate publishedDate, Set<BorrowRecord> borrowRecords) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.name = name;
        this.publishedDate = publishedDate;
        this.borrowRecords = borrowRecords;
    }

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    @NotNull(message = "Author is mandatory")
    private Author author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title should not be longer than 255 characters")
    private String title;
    @NotNull(message = "ISBN is mandatory")
    private Integer isbn;
    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name should not be longer than 255 characters")
    private String name;
    @PastOrPresent(message = "Published date should be in the past or present")
    private LocalDate publishedDate;

    @OneToMany(mappedBy = "book")
    @JsonManagedReference
    private Set<BorrowRecord> borrowRecords;

    public Book() {}

    public Book(Author author, Integer isbn, String title, String name, LocalDate publishedDate) {
        this.author = author;
        this.isbn = isbn;
        this.name = name;
        this.publishedDate = publishedDate;
        this.title = title;
    }

    public Book(Long id, Author author, Integer isbn, String name, LocalDate publishedDate) {
        this.id = id;
        this.author = author;
        this.isbn = isbn;
        this.name = name;
        this.publishedDate = publishedDate;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Set<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    public void setBorrowRecords(Set<BorrowRecord> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }
}
