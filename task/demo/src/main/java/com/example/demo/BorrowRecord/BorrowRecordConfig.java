//package com.example.demo.BorrowRecord;
//
//import com.example.demo.Book.Book;
//import com.example.demo.Book.BookRepository;
//import com.example.demo.Borrower.Borrower;
//import com.example.demo.Borrower.BorrowerRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//
//@Configuration
//public class BorrowRecordConfig {
//    @Bean
//    CommandLineRunner borrowerRecordCommandLineRunner(
//            BorrowRecordRepository borrowRecordRepository,
//            BorrowerRepository borrowerRepository,
//            BookRepository bookRepository) {
//        return args -> {
//            List<Borrower> borrowers = borrowerRepository.findAll();
//            List<Book> books = bookRepository.findAll();
//
//            BorrowRecord borrowRecord1 = new BorrowRecord(borrowers.get(0), books.get(0), LocalDate.now(), LocalDate.now().plusDays(14));
//            BorrowRecord borrowRecord2 = new BorrowRecord(borrowers.get(1), books.get(1), LocalDate.now(), LocalDate.now().plusDays(14));
//            BorrowRecord borrowRecord3 = new BorrowRecord(borrowers.get(1), books.get(2), LocalDate.now(), LocalDate.now().plusDays(14));
//            BorrowRecord borrowRecord4 = new BorrowRecord(borrowers.get(1), books.get(3), LocalDate.now(), LocalDate.now().plusDays(14));
//
//            borrowRecordRepository.saveAll(Arrays.asList(borrowRecord1, borrowRecord2, borrowRecord3, borrowRecord4));
//        };
//    }
//}
