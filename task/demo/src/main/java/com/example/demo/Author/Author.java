package com.example.demo.Author;

import com.example.demo.Book.Book;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Past(message = "Birth date should be in the past")
    private LocalDate birthDate;
    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name should not be longer than 255 characters")
    private String name;
    @NotBlank(message = "Nationality is mandatory")
    @Size(max = 255, message = "Nationality should not be longer than 255 characters")
    private String nationality;

    public Author(LocalDate birthDate, String name, String nationality, Set<Book> books) {
        this.birthDate = birthDate;
        this.name = name;
        this.nationality = nationality;
        this.books = books;
    }

    public Author(Long id, LocalDate birthDate, String name, String nationality, Set<Book> books) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.nationality = nationality;
        this.books = books;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private Set<Book> books;

    public Author() {}

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public Author(Long id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public Author(Long id, Set<Book> books) {
        this.id = id;
        this.books = books;
    }

    public Author(LocalDate birthDate, String name, String nationality) {
        this.birthDate = birthDate;
        this.name = name;
        this.nationality = nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
