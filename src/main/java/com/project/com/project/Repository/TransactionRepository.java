package com.project.com.project.Repository;

import com.project.com.project.Entity.Expense;
import com.project.com.project.Entity.IncomeHead;
import com.project.com.project.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<IncomeHead> findIncomeHeadById(Long id);
    Optional<Expense> findExpenseHeadById(Long id);

}
