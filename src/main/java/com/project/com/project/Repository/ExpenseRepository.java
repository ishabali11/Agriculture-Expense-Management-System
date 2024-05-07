package com.project.com.project.Repository;

import com.project.com.project.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAll();

    Expense findByName(String name);
}