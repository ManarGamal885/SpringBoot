package com.example.demo.BorrowRecord;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class BorrowRecordService {
    private BorrowRecordRepository borrowRecordRepository;
    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository){
        this.borrowRecordRepository = borrowRecordRepository;
    }

    //Retrieve all borrowing records.
    public List<BorrowRecord> getAllBorrowRecord(){
        return borrowRecordRepository.findAll();
    }

    //Retrieve all borrowing records by borrower id.
    public List<BorrowRecord> getBorrowRecordByBorrowerId(Long borrowerId){
        List<BorrowRecord> borrowRecords = borrowRecordRepository.findAll();
        List<BorrowRecord> borrowRecordsByBorrowerId = new ArrayList<>();
        for(BorrowRecord borrowRecord : borrowRecords){
            if(borrowRecord.getBorrower().getId().equals(borrowerId)){
                borrowRecordsByBorrowerId.add(borrowRecord);
            }
        }
        return borrowRecordsByBorrowerId;
    }

    //Retrieve all borrowing records by book id.
    public List<BorrowRecord> getBorrowRecordByBookId(Long bookId){
        List<BorrowRecord> borrowRecords = borrowRecordRepository.findAll();
        List<BorrowRecord> borrowRecordsByBookId = new ArrayList<>();
        for(BorrowRecord borrowRecord : borrowRecords){
            if(borrowRecord.getBook().getId().equals(bookId)){
                borrowRecordsByBookId.add(borrowRecord);
            }
        }
        return borrowRecordsByBookId;
    }

    //Record the borrowing of a book by a borrower.
    public BorrowRecord addBorrowBook(BorrowRecord borrowRecord){
        return borrowRecordRepository.save(borrowRecord);
    }

    //Update the return date when a book is returned.
    public BorrowRecord updateBorrowRecord(Long borrowRecordId, LocalDate returnDate){
        BorrowRecord borrowRecord = borrowRecordRepository.findById(borrowRecordId).orElseThrow(() -> new IllegalStateException("Borrow Record with id " + borrowRecordId + " does not exist"));
        borrowRecord.setReturnDate(returnDate);
        return borrowRecordRepository.save(borrowRecord);
    }

    //Delete a borrowing record.
    public void deleteBorrowRecord(Long borrowRecordId){
        boolean exists = borrowRecordRepository.existsById(borrowRecordId);
        if(!exists){
            throw new IllegalStateException("Borrow Record with id " + borrowRecordId + " does not exist");
        }
        borrowRecordRepository.deleteById(borrowRecordId);
    }
}
