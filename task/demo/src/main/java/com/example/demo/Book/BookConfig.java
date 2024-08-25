//package com.example.demo.Book;
//
//import com.example.demo.Author.Author;
//import com.example.demo.Author.AuthorRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Configuration
//public class BookConfig {
//    @Bean
//    CommandLineRunner bookCommandLineRunner(
//            BookRepository bookRepository, AuthorRepository authorRepository){
//        return args -> {
//            List<Author> authors = authorRepository.findAll();
//            Book book1 = new Book(authors.get(0), 123456, "Power Book","NamePower", LocalDate.now());
//            Book book2 = new Book(authors.get(0), 789012, "Joy Book","NameJoy", LocalDate.now());
//            Book book3 = new Book(authors.get(1), 346364, "Anger Book","NameAnger", LocalDate.now());
//            Book book4 = new Book(authors.get(2), 790889, "Happiness Book","NameHappiness", LocalDate.now());
//            Book book5 = new Book(authors.get(3), 13214, "Hate Book","NameHate", LocalDate.now());
//            Book book6 = new Book(authors.get(4), 547575, "Control Book","NameControl", LocalDate.now());
//            bookRepository.saveAll(List.of(book1, book2, book3, book4, book5, book6));
//        };
//    }
//}
