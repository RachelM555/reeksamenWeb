package com.example.reeksamen.service;

import com.example.reeksamen.model.Medarbejder;
import com.example.reeksamen.repository.MedarbejderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class medarbejderService {

    @Autowired

        MedarbejderRepo medarbejderRepo;

    @Autowired
    JdbcTemplate template;


    public  List<Medarbejder> fetchAll()
    {
        return medarbejderRepo.fetchAll();

    }

    public Medarbejder findByEmail(String email)
    {
        return medarbejderRepo.findByEmail(email);
    }

    public boolean validateLogin(String email, String adgangskode)
    {
        return medarbejderRepo.validateLogin(email,adgangskode);
    }

}
