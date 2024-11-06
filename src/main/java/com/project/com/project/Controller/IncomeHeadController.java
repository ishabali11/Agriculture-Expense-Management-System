package com.project.com.project.Controller;

import com.project.com.project.Entity.IncomeHead;
import com.project.com.project.Service.IncomeHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income-head")
@CrossOrigin("*")
public class IncomeHeadController {

    @Autowired
    private IncomeHeadService incomeHeadService;

    @GetMapping
    public List<IncomeHead> getAllIncomeHeads()
    {
        return incomeHeadService.getAllIncomeHeads();
    }

    @PostMapping
    public IncomeHead addIncomeHead(@RequestBody IncomeHead incomeHead)
    {
        return incomeHeadService.addIncomeHead(incomeHead);
    }

    @GetMapping("/{id}")
    public IncomeHead getIncomeHead(@PathVariable Long id){
        return incomeHeadService.getIncomeHead(id);
    }

    @PutMapping("/{id}")
    public IncomeHead updatedIncomeHead(@PathVariable Long id, @RequestBody IncomeHead incomeHead)
        {
            return incomeHeadService.updateIncomeHead(id, incomeHead);
        }



   @DeleteMapping("/{id}")
public ResponseEntity<?> deleteIncomeHead(@PathVariable Long id) {
    try {
        // Attempt to delete the income head
        incomeHeadService.deleteIncomeHead(id);
        return ResponseEntity.ok("Income Head deleted successfully");
    } catch (Exception e) {
        // Log the error (optional, but recommended for production environments)
        e.printStackTrace();
        
        // Return an error response if the deletion failed
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while trying to delete the Income Head");
    }
}




}
