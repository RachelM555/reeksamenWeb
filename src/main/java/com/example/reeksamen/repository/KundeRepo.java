package com.example.reeksamen.repository;

import com.example.reeksamen.model.Kunde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Repository
public class KundeRepo {

    @Autowired
    private JdbcTemplate template;

    // Henter alle kunder
    public List<Kunde> fetchAll() {
        String sql = "SELECT * FROM kunde";
        RowMapper<Kunde> rowMapper = new BeanPropertyRowMapper<>(Kunde.class);
        return template.query(sql, rowMapper);
    }




    public void addKunde(Kunde kunde)
    {
        String sql ="INSERT INTO kunde (navn, adresse,telefonNr, email)" + " VALUES (?, ?,?,?)";
        template.update(sql, kunde.getNavn(), kunde.getAdresse(), kunde.getTelefonNr(),kunde.getEmail());
    }


    // Opdater eksisterende kunde
    public void updateKunde(Kunde kunde) {
        String sql = "UPDATE kunde SET navn = ?, adresse = ?, telefonNr = ?, email = ? WHERE kundeId = ?";
        template.update(sql, kunde.getNavn(), kunde.getAdresse(), kunde.getTelefonNr(), kunde.getEmail(), kunde.getKundeId());
    }

    // Slet kunde efter ID
    public void deleteById(int kundeId) {
        String sql = "DELETE FROM kunde WHERE kundeId = ?";
      template.update(sql, kundeId);
    }




}
