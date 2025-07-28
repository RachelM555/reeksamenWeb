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








}
