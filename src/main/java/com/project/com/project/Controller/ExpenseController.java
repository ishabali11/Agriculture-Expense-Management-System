package com.project.com.project.Controller;

import com.project.com.project.Entity.Expense;
import com.project.com.project.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenseHead")
@CrossOrigin("*")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseHeadService;

   @PostMapping
    public ResponseEntity<Expense> createExpenseHead(@RequestBody Expense expenseHead) {
        return ResponseEntity.ok(expenseHeadService.saveExpenseHead(expenseHead));
    }

   @GetMapping("/{id}")
    public ResponseEntity<List<Expense>> getAllExpenseHeads() {
        return ResponseEntity.ok(expenseHeadService.getAllExpenseHeads());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseHeadById(@PathVariable Long id) {
        expenseHeadService.deleteExpenseHeadById(id);
        return ResponseEntity.noContent().build();
    }
}