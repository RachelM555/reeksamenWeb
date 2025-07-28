package com.example.reeksamen;

import com.example.reeksamen.model.Bil;
import com.example.reeksamen.model.Lejekontrakt;
import com.example.reeksamen.service.bilService;
import com.example.reeksamen.service.lejekontraktService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ReeksamenApplicationTests {

    @Autowired
    private bilService bilservice;

    @Autowired
    private lejekontraktService lejekontraktService;

    @Test

    public void testAddBil() {
        System.out.println("Testen  testAddBil starter");
        Bil bil = new Bil(0, "VW", "Golf", "2020", "random", Bil.Status.LEDIG, 22.22, 22.22);
        bilservice.addBil(bil);
        System.out.println("Bilen er oprettet");

        List<Bil> biler = bilservice.fetchAll();
        System.out.println("bilen er tilføjet til listen");
        assertTrue(biler.size() > 0, "Bilen blev ikke tilføjet til listen");
    }

@Test
    public void testAddLejekontrakt()
    {
        System.out.println("Testen addLejekontrakt starter");
        Lejekontrakt lejekontrakt = new Lejekontrakt(0,2,1, 1, LocalDate.of(2025,7,28),LocalDate.of(2025,8,28), Lejekontrakt.AbonnementType.LIMITED, 2999.00);
        lejekontraktService.addLejekontrakt(lejekontrakt);
        System.out.println("Lejekontrakt er oprettet");

        List<Lejekontrakt> lejekontrakter = lejekontraktService.fetchAll();
        System.out.println("Lejekontrakten er tilføjet til listen");
        assertTrue(lejekontrakter.size() > 0,"Lejekontrakt blev ikke tilføjet til listen");
    }
}


