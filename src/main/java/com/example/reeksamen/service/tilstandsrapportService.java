package com.example.reeksamen.service;

import com.example.reeksamen.model.Tilstandsrapport;
import com.example.reeksamen.repository.TilstandsrapportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tilstandsrapportService
{

    @Autowired
    TilstandsrapportRepo tilstandsrapportRepo;

    @Autowired
    JdbcTemplate template;

    public List<Tilstandsrapport> fetchAll()
    {
        return tilstandsrapportRepo.fetchAll();
    }

    public void addTilstandsrapport(Tilstandsrapport tilstandsrapport)
    {
        tilstandsrapportRepo.addTilstandsrapport(tilstandsrapport);
    }

    public void updateTilstandsrapport(Tilstandsrapport tilstandsrapport)
    {
        tilstandsrapportRepo.updateTilstandsrapport(tilstandsrapport);
    }

    public int deleteById(int tilstandsrapportId)
    {
        return tilstandsrapportRepo.deleteById(tilstandsrapportId);
    }

}
