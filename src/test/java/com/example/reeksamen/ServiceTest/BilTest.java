package com.example.reeksamen.ServiceTest;

import com.example.reeksamen.model.Bil;
import com.example.reeksamen.service.bilService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*@SpringBootTest
class BilTest {

    @Autowired
    private bilService bilservice;


    @Test //Happyflow

    public void testAddBil() {
        System.out.println("Testen  testAddBil starter");
        Bil bil = new Bil(0, "VW", "Golf", "2020", "random", Bil.Status.LEDIG, 22.22, 22.22);
        bilservice.addBil(bil);
        System.out.println("Bilen er oprettet");

        List<Bil> biler = bilservice.fetchAll();
        System.out.println("bilen er tilføjet til listen");
        assertTrue(biler.size() > 0, "Bilen blev ikke tilføjet til listen");
    }


    @Test //Unhappyflow
    public void testAddBilMedTomtMaerke() {
        System.out.println("Testen testAddBilMedTomtMaerke starter");

        // Opretter bil med tomt mærke

        Bil bil = new Bil(0, "", "Golf", "2020", "random", Bil.Status.LEDIG, 22.22, 22.22);
        bilservice.addBil(bil);
        System.out.println("Bilen med tomt mærke er tilføjet");

        List<Bil> biler = bilservice.fetchAll();
        System.out.println("Listen over biler er hentet");

        // Tjek at bilen IKKE er tilføjet (bilen med tomt mærke burde ikke være i listen)
        boolean findes = false;
        for (int i = 0; i < biler.size(); i++) {
            if (biler.get(i).getMaerke().length() == 0) {  // tjek om mærket er tomt
                findes = true;

            }
        }
        assertTrue(!findes, "Bilen med tomt mærke burde ikke være tilføjet");
    }
}
*/
