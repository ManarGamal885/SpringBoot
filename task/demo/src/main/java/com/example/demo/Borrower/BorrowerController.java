package com.example.demo.Borrower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Borrower")
public class BorrowerController {
    private final BorrowerService borrowerService;

    @Autowired
    public BorrowerController(BorrowerService borrowerService){
        this.borrowerService = borrowerService;
    }

    @GetMapping
    public List<Borrower> getBorrower(){
        return borrowerService.getAllBorrower();
    }

    @GetMapping("/{borrowerId}")
    public Borrower getBorrowerById(@PathVariable Long borrowerId){
        return borrowerService.getBorrowerById(borrowerId);
    }

    @PostMapping
    public void addNewBorrower(@RequestBody Borrower borrower){
        borrowerService.addNewBorrower(borrower);
    }

    @DeleteMapping("/{borrowerId}")
    public void deleteBorrower(@PathVariable Long borrowerId){
        borrowerService.deleteBorrower(borrowerId);
    }

    @PutMapping("/{borrowerId}")
    public void updateBorrower(@PathVariable Long borrowerId, @RequestBody Borrower borrower){
        borrowerService.updateBorrower(borrowerId, borrower.getName(), borrower.getEmail());
    }
}