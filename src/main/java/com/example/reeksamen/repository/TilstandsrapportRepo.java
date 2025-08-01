package com.example.reeksamen.repository;

import com.example.reeksamen.model.Tilstandsrapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TilstandsrapportRepo {

    @Autowired
    private JdbcTemplate template;

    public List<Tilstandsrapport> fetchAll() {
        String sql = "SELECT * FROM tilstandsrapport";
        RowMapper rowMapper = new BeanPropertyRowMapper(Tilstandsrapport.class);
        return template.query(sql, rowMapper);

    }

    public void addTilstandsrapport(Tilstandsrapport tilstandsrapport)
    {
        String sql = " INSERT INTO tilstandsrapport(bilId, kontraktId, tilstandsrapportDato, medarbejderId, erSKadet ) " + "VALUES (?,?,?,?,?)";
        template.update(sql, tilstandsrapport.getBilId(), tilstandsrapport.getKontraktId(), tilstandsrapport.getTilstandsrapportDato(), tilstandsrapport.getMedarbejderId(), tilstandsrapport.isErSkadet());
    }

    public void updateTilstandsrapport ( Tilstandsrapport tilstandsrapport)
    {
        String sql = "UPDATE tilstandsrapport SET bilId = ?, kontraktId= ?, tilstandsrapportDato = ?, medarbejderId= ?, erSkadet = ? WHERE tilstandsrapportId = ?";
        template.update(sql, tilstandsrapport.getBilId(), tilstandsrapport.getKontraktId(), tilstandsrapport.getTilstandsrapportDato(), tilstandsrapport.getMedarbejderId(), tilstandsrapport.isErSkadet());
    }

    public int deleteById(int tilstandsrapportId) {
        String sql = "DELETE FROM tilstandsrapport WHERE tilstandsrapport_id = ?";
        return template.update(sql, tilstandsrapportId);
    }
}
