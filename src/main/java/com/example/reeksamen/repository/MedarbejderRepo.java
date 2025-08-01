package com.example.reeksamen.repository;

import com.example.reeksamen.model.Medarbejder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class MedarbejderRepo
{
@Autowired
    JdbcTemplate template;


// Henter en liste over alle medarbejdere
public List <Medarbejder> fetchAll()
{
    String sql = "SELECT * FROM medarbejder";
    RowMapper<Medarbejder> rowMapper = new BeanPropertyRowMapper<>(Medarbejder.class);
    return template.query(sql,rowMapper);
}

// Finder en medarbejder via email
public Medarbejder findByEmail (String email)
{
    String sql = "SELECT * FROM medarbejder WHERE email = ?";
    RowMapper<Medarbejder> rowMapper = new BeanPropertyRowMapper<>(Medarbejder.class);
    return template.queryForObject(sql,rowMapper,email);



}

    public boolean validateLogin(String email, String adgangskode) {
        // SQL-spørgsmål der tæller, hvor mange medarbejdere matcher e-mail og kodeord
        String sql = "SELECT COUNT(*) FROM medarbejder WHERE email = ? AND adgangskode = ?";

        // Kører SQL'en og gemmer resultatet i en variabel kaldet 'count'
        // Vi forventer et helt tal (Integer) som resultat
        Integer count = template.queryForObject(sql, Integer.class, email, adgangskode);

        // Tjekker at count ikke er null, og at det er større end 0
        // Hvis begge er sande, betyder det at login er gyldigt → returner true
        // Ellers returner false (ugyldigt login)
        return count != null && count > 0;
    }


}
