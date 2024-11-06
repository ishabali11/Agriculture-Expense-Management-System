package com.project.com.project.Controller;

import com.project.com.project.Entity.Expense;
import com.project.com.project.Entity.IncomeHead;
import com.project.com.project.Entity.Transaction;
import com.project.com.project.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
@CrossOrigin("*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


   @GetMapping("/income-head")
   public List<IncomeHead> getIncomeTypes() {
       return transactionService.getAllIncomes();
   }

    @GetMapping("/expenseHead")
    public List<Expense> getExpenseTypes() {
        return transactionService.getAllExpenses();
    }
    @PostMapping
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction) {
        try {
            // Determine whether it's an income or expense
            if (transaction.getType() == Transaction.TransactionType.Income) {
                // Here, transaction.getIncome() will contain the selected IncomeHead object
                transaction.setIncome(transaction.getIncome());
            } else {
                // Here, transaction.getExpense() will contain the selected Expense object
                transaction.setExpense(transaction.getExpense());
            }

            // Save the transaction
            Transaction savedTransaction = transactionService.addTransaction(transaction);
            return ResponseEntity.ok(savedTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

   


}