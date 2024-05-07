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
    public void deleteIncomeHead(@PathVariable Long id) {
        incomeHeadService.deleteIncomeHead(id);
    }




}
