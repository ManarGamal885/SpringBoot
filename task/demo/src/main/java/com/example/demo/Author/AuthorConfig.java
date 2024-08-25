//package com.example.demo.Author;
//
//import com.example.demo.Book.Book;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//
//@Configuration
//public class AuthorConfig {
//
//    @Bean
//    @Transactional // Ensure that this method is transactional
//    CommandLineRunner authorCommandLineRunner(AuthorRepository authorRepository) {
//        return args -> {
//            Author author1 = new Author(
//                    LocalDate.of(2000, 1, 1),
//                    "MANAR",
//                    "Egyptian",
//                    null
//            );
//            Author author2 = new Author(
//                    LocalDate.of(2001, 1, 1),
//                    "RAHMA",
//                    "Irani",
//                    null
//            );
//            Author author3 = new Author(
//                    LocalDate.of(2006, 1, 1),
//                    "MOHAMED",
//                    "Irani",
//                    null
//            );
//            Author author4 = new Author(
//                    LocalDate.of(1984, 1, 1),
//                    "ALEX",
//                    "Irani",
//                    null
//            );
//            Author author5 = new Author(
//                    LocalDate.of(1950, 1, 1),
//                    "NOOR",
//                    "Irani",
//                    null
//            );
//
//            // Use java.util.List and pass the list of authors to saveAll
//            List<Author> authors = Arrays.asList(author1, author2, author3, author4, author5);
//
//            // Save all authors
//            authorRepository.saveAll(authors);
//        };
//    }
//}
