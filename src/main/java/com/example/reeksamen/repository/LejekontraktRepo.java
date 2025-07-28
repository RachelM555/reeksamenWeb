package com.example.reeksamen.repository;

import com.example.reeksamen.model.Bil;
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
    @Autowired
    BilRepo bilRepo;

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

        bilRepo.updateBilStatus(l.getBilId(), Bil.Status.UDLEJET);

    }

    public void updateLejekontrakt(Lejekontrakt l)
    {
        String sql = "UPDATE lejekontrakt SET kundeId = ?, bilId = ?, startDato = ?, slutDato = ?, abonnementType = ?, pris = ?, medarbejderId = ? WHERE kontraktId = ?" ;
        template.update(sql, l.getKundeId(),l.getBilId(), l.getStartDato(), l.getSlutDato(), l.getAbonnementType(),l.getPris(), l.getMedarbejderId(), l.getKontraktId());
    }


    public void deleteLejekontrakt(int kontraktId, int bilId) {
        String sql = "DELETE FROM lejekontrakt WHERE kontraktId = ?";
        template.update(sql, kontraktId);

        bilRepo.updateBilStatus(bilId, Bil.Status.LEDIG);
    }



    }

