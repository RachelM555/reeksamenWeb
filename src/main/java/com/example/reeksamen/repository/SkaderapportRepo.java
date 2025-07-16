package com.example.reeksamen.repository;

import com.example.reeksamen.model.Skaderapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class SkaderapportRepo {

    @Autowired
    private JdbcTemplate template;

    public List<Skaderapport> fetchAll() {
        String sql = "SELECT * FROM skaderapport";
        RowMapper rowMapper = new BeanPropertyRowMapper(Skaderapport.class);
        return template.query(sql, rowMapper);
    }

    public void addSkaderapoort(Skaderapport skaderapport) {
        String sql = "INSERT INTO skaderapport (tilstandsrapportId, medarbejderId, antalSkader, prisPrSkade, prisTotal, beskrivelse)" + "VALUES (?,?,?,?,?,?)";
        template.update(sql, skaderapport.getTilstandsrapportId(), skaderapport.getMedarbejderId(), skaderapport.getAntalSkader(), skaderapport.getPrisPrSkade(), skaderapport.getPrisTotal(), skaderapport.getBeskrivelse());
    }


    public void updateSkaderapport(Skaderapport skaderapport) {
        String sql = " UDPATE skaderapport SET tilstandsrapportId = ?, medarbejderId = ?, antalSkader= ?, prisPrSkade= ?, prisTotal = ?, beskrivelse = ? WHERE skaderapportId = ?";
        template.update(sql, skaderapport.getTilstandsrapportId(), skaderapport.getMedarbejderId(), skaderapport.getAntalSkader(), skaderapport.getPrisPrSkade(), skaderapport.getPrisTotal(), skaderapport.getBeskrivelse());
    }

    // 5. Slet skaderapport efter id
    public int sletEfterId(int skaderapportId) {
        String sql = "DELETE FROM skaderapport WHERE skaderapport_id = ?";
        System.out.println("Sletter skaderapport med ID: " + skaderapportId);
        return template.update(sql, skaderapportId);
    }





}






