package com.example.reeksamen.service;
import com.example.reeksamen.model.Kunde;
import com.example.reeksamen.repository.KundeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class kundeService
{
    @Autowired
    private KundeRepo kundeRepo;

    @Autowired
    private JdbcTemplate template;

    // Service til CRUD metoder

    public List<Kunde> fetchAll()
    {
        return kundeRepo.fetchAll();
    }

    public void addKunde(Kunde kunde)
    {
        kundeRepo.addKunde(kunde);
    }

    public void updateKunde(Kunde kunde)
    {
        kundeRepo.updateKunde(kunde);
    }

    public void deleteById(int kundeId)
    {
        kundeRepo.deleteById(kundeId);
    }


}
