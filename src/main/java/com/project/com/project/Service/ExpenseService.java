package com.project.com.project.Service;

import com.project.com.project.Entity.Expense;
import com.project.com.project.Entity.IncomeHead;
import com.project.com.project.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseHeadRepository;

    public Expense saveExpenseHead(Expense expenseHead) {
        return expenseHeadRepository.save(expenseHead);
    }

    public List<Expense> getAllExpenseHeads() {
        return expenseHeadRepository.findAll();
    }

    public void deleteExpenseHeadById(Long id) {
        expenseHeadRepository.deleteById(id);
    }
}