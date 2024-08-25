package com.example.demo.BorrowRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/BorrowRecord")
public class BorrowRecordController {
    private BorrowRecordService borrowerRecordService;

    @Autowired
    public BorrowRecordController(BorrowRecordService borrowerRecordService) {
        this.borrowerRecordService = borrowerRecordService;
    }

    @GetMapping
    public List<BorrowRecord> getBorrowRecord(){
        return borrowerRecordService.getAllBorrowRecord();
    }

    @GetMapping("/borrower/{borrowerId}")
    public List<BorrowRecord> getBorrowRecordByBorrowerId(@PathVariable Long borrowerId){
        return borrowerRecordService.getBorrowRecordByBorrowerId(borrowerId);
    }

    @GetMapping("/book/{bookId}")
    public List<BorrowRecord> getBorrowRecordByBookId(@PathVariable Long bookId){
        return borrowerRecordService.getBorrowRecordByBookId(bookId);
    }

    @PostMapping
    public BorrowRecord addBorrowBook(@RequestBody BorrowRecord borrowRecord){
        return borrowerRecordService.addBorrowBook(borrowRecord);
    }

    @PutMapping("/{borrowRecordId}")
    public BorrowRecord updateBorrowRecord(@PathVariable Long borrowRecordId, @RequestBody LocalDate returnDate){
        return borrowerRecordService.updateBorrowRecord(borrowRecordId, returnDate);
    }

    @DeleteMapping("/{borrowRecordId}")
    public void deleteBorrowRecord(@PathVariable Long borrowRecordId){
        borrowerRecordService.deleteBorrowRecord(borrowRecordId);
    }
}