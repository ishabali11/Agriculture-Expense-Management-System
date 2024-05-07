package com.project.com.project.Service;

import com.project.com.project.Entity.Expense;
import com.project.com.project.Entity.IncomeHead;
import com.project.com.project.Entity.Transaction;
import com.project.com.project.Repository.ExpenseRepository;
import com.project.com.project.Repository.IncomeHeadRepository;
import com.project.com.project.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private IncomeHeadRepository incomeHeadRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<IncomeHead> getAllIncomes() {
        return incomeHeadRepository.findAll();
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    public IncomeHead getIncomeById(Long id) {
        return incomeHeadRepository.findById(id).orElse(null);
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

}