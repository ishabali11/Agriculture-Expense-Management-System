package com.project.com.project.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "income_id")
    private IncomeHead income;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;




    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private double amount;
    private String description;

    public enum TransactionType {
        Income,
        Expense
    }

    public Transaction() {
        // Default constructor
    }

    public Transaction(Long id, TransactionType type, IncomeHead income, Expense expense, Date date, double amount, String description) {
        this.id = id;
        this.type = type;
        this.income = income;
        this.expense = expense;

        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Long getIncomeId() {
        return this.income != null ? this.income.getId() : null;
    }

    public Long getExpenseId() {
        return this.expense != null ? this.expense.getId() : null;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public IncomeHead getIncome() {
        return income;
    }

    public void setIncome(IncomeHead income) {
        this.income = income;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}



