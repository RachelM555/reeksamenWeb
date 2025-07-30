package com.example.reeksamen.service;

import com.example.reeksamen.model.Lejekontrakt;
import com.example.reeksamen.repository.LejekontraktRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class lejekontraktService {
    @Autowired
    LejekontraktRepo lejekontraktRepo;

    @Autowired
    JdbcTemplate template;

    public List<Lejekontrakt> fetchAll() {
        return lejekontraktRepo.fetchAll();
    }

    public void addLejekontrakt(Lejekontrakt kontrakt)
    {
            // Opretter en lejekontrakt
            lejekontraktRepo.addLejekontrakt(kontrakt);

    }

    public void updateLejekontrakt(Lejekontrakt kontrakt)
    {
        lejekontraktRepo.updateLejekontrakt(kontrakt);
    }

    public void deleteLejekontrakt(int kontraktId, int bilId)
    {
        lejekontraktRepo.deleteLejekontrakt(kontraktId, bilId);
    }
}



