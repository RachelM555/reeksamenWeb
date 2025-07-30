package com.example.reeksamen.ServiceTest;


import com.example.reeksamen.model.Lejekontrakt;
import com.example.reeksamen.service.bilService;
import com.example.reeksamen.service.lejekontraktService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ReeksamenApplicationTests {

    @Autowired
    private bilService bilservice;

    @Autowired
    private lejekontraktService lejekontraktService;



    @Test
    public void testAddLejekontrakt()
    {
        System.out.println("Testen addLejekontrakt starter");
        Lejekontrakt lejekontrakt = new Lejekontrakt(0,1,3, 1, LocalDate.of(2025,7,28),LocalDate.of(2025,8,28), Lejekontrakt.AbonnementType.LIMITED, 2999.00);
        lejekontraktService.addLejekontrakt(lejekontrakt);

        System.out.println("Lejekontrakt er oprettet");

        System.out.println("Bil" +" "+ lejekontrakt.getBilId()+ " " + "sat til UDLEJET");

        List<Lejekontrakt> lejekontrakter = lejekontraktService.fetchAll();
        System.out.println("Lejekontrakten er tilføjet til listen");

        assertTrue(lejekontrakter.size() > 0,"Lejekontrakt blev ikke tilføjet til listen");

    }


    @Test
    public void testDeleteKontrakt()
    {
        System.out.println("Testen deleteKontrakt starter");

        int kontraktId = 4;
        int bilId = 1;

        lejekontraktService.deleteLejekontrakt(kontraktId,bilId);

        List<Lejekontrakt> lejekontrakt = lejekontraktService.fetchAll();

        boolean fundet = false;
        for (int i = 0; i < lejekontrakt.size(); i++) {
            if (lejekontrakt.get(i).getKontraktId() == kontraktId) {
                fundet = true;
                break;
            }
        }
        assertFalse(fundet, "lejekontraktden er ikke slettet");
    }


    @Test
    public void testBeregningSum()
    {
        System.out.println("pris testen starter");
        double samletPris = lejekontraktService.beregnSamletPris();
        System.out.println("Samlet pris af alle lejekontrakterne er"+ " " + samletPris + " " + "DKK");
    }
}

