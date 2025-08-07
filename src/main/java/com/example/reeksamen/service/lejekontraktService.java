package com.example.reeksamen.service;

import com.example.reeksamen.model.Lejekontrakt;
import com.example.reeksamen.repository.LejekontraktRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // Opretter en lejekontrakt
        lejekontraktRepo.addLejekontrakt(kontrakt);

    }

    public void updateLejekontrakt(Lejekontrakt kontrakt) {
        lejekontraktRepo.updateLejekontrakt(kontrakt);
    }

    public void deleteById(int kontraktId, int bilId) {
        lejekontraktRepo.deleteLejekontrakt(kontraktId, bilId);
    }


    public double beregnSamletPris() {

        List<Lejekontrakt> lejekontrakt = lejekontraktRepo.fetchAll();
        // Opretter en HashMap til at gemme kontraktId og pris (Double)
        Map<Integer, Double> samletPris = new HashMap<>();

        // Går igennem alle lejekontrakter og lægger dem ind i mappen
        for (int i = 0; i < lejekontrakt.size(); i++) {
            Lejekontrakt kontrakt = lejekontrakt.get(i); // Henter en kontrakt ad gangen
            samletPris.put(kontrakt.getKontraktId(), kontrakt.getPris()); // Gemmer kontraktId og pris
        }

        // Variabel til at holde den samlede pris
        double prisSum = 0.0;

        // Henter alle værdierne kun altså priserne fra mappen som en liste
        List<Double> priser = new ArrayList<>(samletPris.values());

        for (int i = 0; i < priser.size(); i++) {
            prisSum += priser.get(i); // Lægger prisen til den samlede sum
        }

        // Returnerer den samlede pris for alle lejekontrakter
        return prisSum;
    }
}








