package com.example.reeksamen.controller;
import com.example.reeksamen.model.Kunde;
import com.example.reeksamen.model.Skaderapport;
import com.example.reeksamen.service.skaderapportService;
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
public class skaderapportController
{
    @Autowired
   skaderapportService skaderapportService;

    // Tjekker om brugeren er logget ind
    private boolean ikkeLoggedInd(HttpSession session) {
        Boolean loggedeInd = (Boolean) session.getAttribute("loggedIn");
        return loggedeInd == null || !loggedeInd;
    }

    @GetMapping("/opretSkaderapport")
    public String opretSkaderapport(HttpSession session, Model model) {
        if (ikkeLoggedInd(session)) return "redirect:/login";

        model.addAttribute("skaderapport", new Skaderapport());
        return "opretSkaderapport";
    }

    @PostMapping("/opretSkaderapport")
    public String gemSkaderapport(@ModelAttribute Skaderapport skaderapport, HttpSession session) {
        if (ikkeLoggedInd(session)) return "redirect:/login";

        skaderapportService.addSkaderapport(skaderapport);
        return "redirect:/skaderapportOverblik";
    }

    @GetMapping("/skaderapportOverblik")
    public String skaderapportOversigt(HttpSession session, Model model) {
        if (ikkeLoggedInd(session)) return "redirect:/login";

        List<Skaderapport> skaderapportList = skaderapportService.fetchAll();
        model.addAttribute("skaderapportOverblik", skaderapportList);
        return "skaderapportOverblik";
    }

    @PostMapping("/skaderapport/slet/{id}")
    public String sletKunde(HttpSession session, @PathVariable("id") int skadeId) {
        if (ikkeLoggedInd(session)) {
            return "redirect:/login";
        }
        skaderapportService.deleteById(skadeId);
        return "redirect:/skaderapportOverblik";
    }
//bb

}
