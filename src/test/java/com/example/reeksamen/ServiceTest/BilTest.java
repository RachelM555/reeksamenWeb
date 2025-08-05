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

}
*/