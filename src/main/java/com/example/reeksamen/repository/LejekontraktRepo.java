package com.example.reeksamen.repository;

import com.example.reeksamen.model.Kunde;
import com.example.reeksamen.model.Lejekontrakt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LejekontraktRepo {

    @Autowired
    JdbcTemplate template;

    public List<Lejekontrakt> fetchAll()
    {
        String sql = "SELECT * FROM lejekontrakt";
        RowMapper<Lejekontrakt> rowMapper = new BeanPropertyRowMapper<>(Lejekontrakt.class);
        return template.query(sql, rowMapper);
    }

    public void addLejekontrakt(Lejekontrakt l)
    {
        String sql = "INSERT INTO lejekontrakt(kundeId, bilId, startDato, slutDato,abonnementType, pris, medarbejderId)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, l.getKundeId(),l.getBilId(), l.getStartDato(), l.getSlutDato(), l.getAbonnementType(),l.getPris(), l.getMedarbejderId());

    }

    public void updateLejekontrakt(Lejekontrakt l)
    {
        String sql = "UPDATE lejekontrakt SET kundeId = ?, bilId = ?, startDato = ?, slutDato = ?, abonnementType = ?, pris = ?, medarbejderId = ? WHERE kontraktId = ?" ;
        template.update(sql, l.getKundeId(),l.getBilId(), l.getStartDato(), l.getSlutDato(), l.getAbonnementType(),l.getPris(), l.getMedarbejderId());
    }



    public void deleteLejekontrakt(int kontraktId) {
        String sql = "DELETE FROM lejekontrakt WHERE kontrakt_id = ?";
        template.update(sql, kontraktId);
    }



    }

