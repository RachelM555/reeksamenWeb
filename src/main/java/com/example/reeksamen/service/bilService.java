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
    public List<Bil> fetchAll()
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

    public void deleteById(int bilId)
    {
        bilRepo.deleteById(bilId);
    }

    public void setBilUdlejet(int bilId)
    {
        bilRepo.setBilUdlejet(bilId);
    }
    public void setBilLedig(int bilId)
    {
        bilRepo.setBilLedig(bilId);
    }
    public List<Bil> getBilUdlejet()
    {
        return bilRepo.getBilUdlejet();
    }
    public List<Bil> getBilLedig()
    {
        return bilRepo.getBilLedig();
    }

    // Service til resterenee


}

