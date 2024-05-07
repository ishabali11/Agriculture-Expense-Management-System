package com.project.com.project.Service;

import com.project.com.project.Entity.IncomeHead;
import com.project.com.project.Repository.IncomeHeadRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeHeadService {

    private final IncomeHeadRepository repository;

    @Autowired
    public IncomeHeadService(IncomeHeadRepository repository) {
        this.repository = repository;
    }

    public List<IncomeHead> getAllIncomeHeads() {
        return repository.findAll();
    }

    public IncomeHead getIncomeHead(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("IncomeHead not found with ID: " + id));
    }

    public IncomeHead addIncomeHead(IncomeHead incomeHead) {
        System.out.println("Adding income head: " + incomeHead);
        return repository.save(incomeHead);
    }

    public IncomeHead updateIncomeHead(Long id, IncomeHead newIncomeHead) {
        return repository.findById(id)
                .map(incomeHead -> {
                    incomeHead.setName(newIncomeHead.getName());
                    return repository.save(incomeHead);
                })
                .orElseThrow(() -> new EntityNotFoundException("IncomeHead not found with ID: " + id));
    }

    public void deleteIncomeHead(Long id) {
        IncomeHead incomeHead = getIncomeHead(id);
        repository.delete(incomeHead);
    }


}
