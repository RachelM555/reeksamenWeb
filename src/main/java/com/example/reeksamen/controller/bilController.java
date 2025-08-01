package com.example.reeksamen.controller;

import com.example.reeksamen.service.bilService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class bilController {

    @Autowired

    bilService bilService;

    // Metode til at tjekke om en bruger ikke er loggede ind, true hvis brugeren ikke er loggede ind.
    private boolean ikkeLoggedInd(HttpSession session)
    {
        Boolean loggedeInd = (Boolean) session.getAttribute("loggedeInd");

        return loggedeInd == null || !loggedeInd;
    }





}
