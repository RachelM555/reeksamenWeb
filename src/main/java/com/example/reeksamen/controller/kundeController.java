package com.example.reeksamen.controller;
import com.example.reeksamen.model.Kunde;
import com.example.reeksamen.service.kundeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class kundeController
{
    @Autowired
    private kundeService kundeService;

    // Tjekker om brugeren er logget ind
    private boolean ikkeLoggedInd(HttpSession session) {
        Boolean loggedeInd = (Boolean) session.getAttribute("loggedIn");
        return loggedeInd == null || !loggedeInd;
    }

    @GetMapping("/opretKunde")
    public String visOpretKunde(HttpSession session, Model model) {
        if (ikkeLoggedInd(session)) return "redirect:/login";

        model.addAttribute("kunde", new Kunde());
        return "opretKunde";
    }

    @PostMapping("/opretKunde")
    public String opretKunde(@ModelAttribute Kunde kunde, HttpSession session) {
        if (ikkeLoggedInd(session)) return "redirect:/login";

        kundeService.addKunde(kunde);
        return "redirect:/kundeOverblik";
    }

    @GetMapping("/kundeOverblik")
    public String visKunder(HttpSession session, Model model) {
        if (ikkeLoggedInd(session)) return "redirect:/login";

        List<Kunde> kunder = kundeService.fetchAll();
        model.addAttribute("kundeListe", kunder);
        return "kundeOverblik";
    }


}
