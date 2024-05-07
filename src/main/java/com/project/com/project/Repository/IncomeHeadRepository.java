package com.project.com.project.Repository;

import com.project.com.project.Entity.Expense;
import com.project.com.project.Entity.IncomeHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IncomeHeadRepository extends JpaRepository<IncomeHead, Long> {
    List<IncomeHead> findByNameContainingIgnoreCase(String query);


    List<IncomeHead> findAll();
    IncomeHead findByName(String name);
    @Override
    IncomeHead save(IncomeHead incomeHead);
}
