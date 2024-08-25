package com.example.demo.Borrower;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService {
    private final BorrowerRepository borrowerRepository;

    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    //Retrieve all borrowers.
    public List<Borrower> getAllBorrower(){
        return borrowerRepository.findAll();
    }

    //Add a new borrower.
    public void addNewBorrower(Borrower borrower){
        borrowerRepository.save(borrower);
    }

    //Delete a borrower.
    public void deleteBorrower(Long borrowerId){
        boolean exists = borrowerRepository.existsById(borrowerId);
        if(!exists){
            throw new IllegalStateException("Borrower with id " + borrowerId + " does not exist");
        }
        borrowerRepository.deleteById(borrowerId);
    }

    //Update a borrower’s details.
    public void updateBorrower(Long borrowerId, String name, String email){
        Borrower borrower = borrowerRepository.findById(borrowerId).orElseThrow(() -> new IllegalStateException("Borrower with id " + borrowerId + " does not exist"));
        if(name != null && name.length() > 0 && !name.equals(borrower.getName())){
            borrower.setName(name);
        }
        if(email != null && email.length() > 0 && !email.equals(borrower.getEmail())){
            borrower.setEmail(email);
        }
        borrowerRepository.save(borrower);
    }

    //Retrieve a single borrower by ID.
    public Borrower getBorrowerById(Long borrowerId){
        return borrowerRepository.findById(borrowerId).orElseThrow(() -> new IllegalStateException("Borrower with id " + borrowerId + " does not exist"));
    }
}
