package com.example.reeksamen.controller;

import com.example.reeksamen.model.Lejekontrakt;
import com.example.reeksamen.service.lejekontraktService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class lejekontraktController {

    @Autowired
    lejekontraktService lejekontraktService;

    // Tjekker om brugeren er logget ind
    private boolean ikkeLoggedInd(HttpSession session) {
        Boolean loggedeInd = (Boolean) session.getAttribute("loggedeInd");
        return loggedeInd == null || !loggedeInd;
    }

    @GetMapping("/opretLejekontrakt")
    public String opretLejekontrakt(HttpSession session, Model model)
    {
        if(ikkeLoggedInd(session))
        {
            return "redirect:/login";
        }

        else model.addAttribute("lejekontrakt", new Lejekontrakt());
        return "opretLejekontrakt";

    }

    @PostMapping("/opretLejekontrakt")
    public String gemLejekontrakt(HttpSession session, @ModelAttribute Lejekontrakt lejekontrakt)
    {
        if(ikkeLoggedInd(session))
        {
            return "redirect:/login";
        }

        lejekontraktService.addLejekontrakt(lejekontrakt);

        return "redirect:/lejekontraktOverblik";
    }

    @GetMapping("/lejekontraktOverblik")
    public String lejekontraktOversigt(HttpSession session, Model model)
    {
        if (ikkeLoggedInd(session)) {
            return "redirect:/login";
        }

        List<Lejekontrakt> lejekontraktList = lejekontraktService.fetchAll();
        model.addAttribute("lejekontraktOverblik", lejekontraktList);

        // Beregn samlet pris metode
        double samletPris = lejekontraktService.beregnSamletPris();
        model.addAttribute("samletPris", samletPris);

        return "lejekontraktOverblik";
    }


    @PostMapping("/lejekontrakt/slet/{id}")
    public String sletLejekontrakt(HttpSession session,
                                   @PathVariable("id") int lejekontraktId,
                                   @RequestParam("bilId") int bilId) {
        if (ikkeLoggedInd(session)) {
            return "redirect:/login";
        }

        lejekontraktService.deleteById(lejekontraktId, bilId);
        return "redirect:/lejekontraktOverblik";
    }






}
