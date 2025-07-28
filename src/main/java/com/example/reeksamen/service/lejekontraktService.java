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

    public void addLejekontrakt(Lejekontrakt kontrakt) {
        try {
            // Opretter en lejekontrakt
            lejekontraktRepo.addLejekontrakt(kontrakt);
            System.out.println("Lejekontrakt oprettet");

            // Opdater bilens status i databasen

            if (kontrakt.getBilId() > 0) {
                String sql = "UPDATE bil SET status = 'UDLEJET' WHERE bilID = ?";
                int rowsAffedted = template.update(sql, kontrakt.getBilId());
                // Konfirmerer at status er blevet opdateret
                System.out.println("Bil" + kontrakt.getBilId() + "sat til UDLEJET");
            }
            //Hvis der sker en fejl
        } catch (Exception e) {
            System.out.println("Fejl ved oprettelse af lejekontrakt");
            e.printStackTrace();
        }
    }

    public void updateLejekontrakt(Lejekontrakt kontrakt) {
        lejekontraktRepo.updateLejekontrakt(kontrakt);
    }
}

 /*public void deleteLejekontrakt (int konidjijdiejdtraktId)
{
    try {

        // Hent bilens ID


    }
}
    }

*/