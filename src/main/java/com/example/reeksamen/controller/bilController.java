package com.example.reeksamen.controller;


import com.example.reeksamen.model.Bil;
import com.example.reeksamen.service.bilService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class bilController {

    @Autowired

    bilService bilService;

    // Metode til at tjekke om en bruger ikke er loggede ind, true hvis brugeren ikke er loggede ind.
    private boolean ikkeLoggedInd(HttpSession session)
    {
        Boolean loggedeInd = (Boolean) session.getAttribute("loggedeInd");

        // Returner true hvis: "loggedInd" ikke findes i sessionen (dvs. null fx, når man besøger en hjemmeside og session ikke har gemt nogle oplysninger) eller "loggedInd" findes men er false, altså brugeren er ikke logget ind
        return loggedeInd == null || !loggedeInd;
    }

    @GetMapping("/opretBil") // viser/henter formularen til oprettelsen af biler
    public String opretBil(HttpSession session, Model model)
    {

        if (ikkeLoggedInd(session))
        {
            return "redirect:/login";
        }
        else model.addAttribute("bil", new Bil());
        return "opretBil";
    }

    @PostMapping("/opretBil") // gemmer bilen
    public String gemBil(HttpSession session, @ModelAttribute Bil bil) // @ModelAttribute Bil bil referer til den forrige metode hvor man adder bilen til model og her bruges den til at gemme den oprettet bil
    {
        if(ikkeLoggedInd(session))
        {
            return "redirect:/login";
        }
        else bilService.addBil(bil);


        return "redirect/bilOverblik";
    }

    @GetMapping("/bilOverblik")
    public String bilOversigt(HttpSession session, Model model)
    {
        if (ikkeLoggedInd(session))
        {
            return "redirect:/login";
        }
        List<Bil> bilList = bilService.fetchAll();

        // Bilerne fra bilList som bliver hentet fra bilService.fetchAll()
        //bliver tilføjet som en attribut i metode model.addAttribute, så HTML siden "bilOverblik.html" kan få adgang til bilList
        model.addAttribute("bilOverblik",bilList);

        return "bilOverblik";
    }

//noteee

}
