package com.example.reeksamen.service;

import com.example.reeksamen.model.Skaderapport;
import com.example.reeksamen.repository.SkaderapportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class skaderapportService {

   @Autowired
   SkaderapportRepo skaderapportRepo;

   @Autowired
   JdbcTemplate template;


   public List<Skaderapport> fetchAll()
   {
       return skaderapportRepo.fetchAll();
   }

   public void addSkaderapport(Skaderapport skaderapport)
   {
       skaderapportRepo.addSkaderapport(skaderapport);
   }

   public void updateSkaderapport(Skaderapport skaderapport)
   {
       skaderapportRepo.updateSkaderapport(skaderapport);
   }

   public int deleteById(int skadeId)
   {
       return skaderapportRepo.deleteById(skadeId);
   }
   // random

}
