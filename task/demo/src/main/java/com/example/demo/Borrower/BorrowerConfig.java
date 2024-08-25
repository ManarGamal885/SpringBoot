//package com.example.demo.Borrower;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Configuration
//public class BorrowerConfig {
//    @Bean
//    CommandLineRunner borrowerCommandLineRunner(BorrowerRepository borrowerRepository) {
//        return args -> {
//            Borrower borrower1 = new Borrower("AHLAM@example.com", "AHLAM", LocalDate.now());
//            Borrower borrower2 = new Borrower("KAWSAR@example.com", "KAWSAR", LocalDate.now());
//
//            borrowerRepository.saveAll(List.of(borrower1, borrower2));
//        };
//    }
//}
