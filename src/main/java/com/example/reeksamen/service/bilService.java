package com.example.reeksamen.service;
import com.example.reeksamen.model.Bil;
import com.example.reeksamen.repository.BilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class bilService

{
    @Autowired
    private BilRepo bilRepo;

    @Autowired
    private JdbcTemplate template;

    // Service til CRUD metoderne
    public List<Bil> getAllBil()
    {
        return bilRepo.fetchAll();
    }
    public void addBil (Bil bil)
    {
        bilRepo.addBil(bil);
    }

    public void updateBil(Bil bil)
    {
        bilRepo.updateBil(bil);
    }

    public void deleteBil(int bilId)
    {
        bilRepo.deleteById(bilId);
    }

    // Service til resterenee


}

