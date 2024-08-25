package com.example.demo.Author;

import com.example.demo.Exceptions.AuthorHasBooksException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //Retrieve all authors.
    public List<Author> getAuthor(){
        return authorRepository.findAll();
    }

    //Create a new author.
    public void addNewAuthor(Author author) {
        authorRepository.save(author);
    }

    //Delete an author.
    public void deleteAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException(
                        "Author with id " + authorId + " does not exist"
                ));
        if (!author.getBooks().isEmpty()) {
            throw new AuthorHasBooksException("Cannot delete author with id " + authorId + " because they still have books in the catalog");
        }
        authorRepository.deleteById(authorId);
    }

    //Update an author.
    public void updateAuthor(Long authorId, String name, String nationality) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException(
                        "Author with id " + authorId + " does not exist"
                ));

        if (name != null && name.length() > 0 && !author.getName().equals(name)) {
            author.setName(name);
        }

        if (nationality != null && nationality.length() > 0 && !author.getNationality().equals(nationality)) {
            author.setNationality(nationality);
        }
    }
}
