package com.example.demo.Borrower;

import com.example.demo.BorrowRecord.BorrowRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "borrowers")
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")private String email;
    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name should not be longer than 255 characters")
    private String name;
    @PastOrPresent(message = "Membership date should be in the past or present")
    private LocalDate membershipDate;

    @OneToMany(mappedBy = "borrower")
    private Set<BorrowRecord> borrowRecords;

    public Borrower() {}

    public Borrower(String email, String name, LocalDate membershipDate) {
        this.email = email;
        this.name = name;
        this.membershipDate = membershipDate;
    }

    public Borrower(Long id, String email, String name, LocalDate membershipDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.membershipDate = membershipDate;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public Set<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    public void setBorrowRecords(Set<BorrowRecord> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }
}
