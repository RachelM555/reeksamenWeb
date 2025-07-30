package com.example.reeksamen.ServiceTest;


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
        Lejekontrakt testkontrakt= new Lejekontrakt(0, 1,2,1, LocalDate.of(2025,6,12), LocalDate.of(2025,12,12), Lejekontrakt.AbonnementType.LIMITED, 3000.00);

        lejekontraktService.addLejekontrakt(testkontrakt);

        lejekontraktService.deleteLejekontrakt(0,2);
        List<Lejekontrakt> lejekontrakt = lejekontraktService.fetchAll();
        assertTrue(lejekontrakt.size()==0, "den er ikke slettet");
    }
}

