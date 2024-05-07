package com.project.com.project.Controller;

import com.project.com.project.Entity.IncomeHead;
import com.project.com.project.Entity.Item;
import com.project.com.project.Entity.Expense;
import com.project.com.project.Service.ExpenseService;
import com.project.com.project.Service.IncomeHeadService;
import com.project.com.project.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/reports")
@CrossOrigin("*")
public class ReportController {

    @Autowired
    private IncomeHeadService incomeService;

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ItemService inventoryItemService;

    @GetMapping("/income-head")
    public ResponseEntity<List<IncomeHead>> generateIncomeReport() {
        List<IncomeHead> incomeList = incomeService.getAllIncomeHeads();
        return ResponseEntity.ok(incomeList);
    }

    @GetMapping("/expenseHead")
    public ResponseEntity<List<Expense>> generateExpenseReport() {
        List<Expense> expenseList = expenseService.getAllExpenseHeads();
        return ResponseEntity.ok(expenseList);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> generateInventoryReport() {
        List<Item> inventoryItemList = inventoryItemService.getAllItems();
        return ResponseEntity.ok(inventoryItemList);
    }
}
