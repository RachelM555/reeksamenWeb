package com.example.reeksamen.controller;
import com.example.reeksamen.model.Tilstandsrapport;
import com.example.reeksamen.service.tilstandsrapportService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    public class tilstandsrapportController {

        @Autowired
        tilstandsrapportService tilstandsrapportService;

        private boolean ikkeLoggedInd(HttpSession session) {
            Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
            return loggedIn == null || !loggedIn;
        }

        @GetMapping("/tilstandsrapportOverblik")
        public String tilstandsrapportOversigt(HttpSession session, Model model) {
            if (ikkeLoggedInd(session)) {
                return "redirect:/login";
            }
            List<Tilstandsrapport> tilstandsrapportList = tilstandsrapportService.fetchAll();
            model.addAttribute("tilstandsrapportOverblik", tilstandsrapportList);
            return "tilstandsrapportOverblik";
        }

        @GetMapping("/opretTilstandsrapport")
        public String OpretTilstandsrapport(HttpSession session, Model model) {
            if (ikkeLoggedInd(session)) {
                return "redirect:/login";
            }
            model.addAttribute("rapport", new Tilstandsrapport());
            return "opretTilstandsrapport";
        }

        @PostMapping("/opretTilstandsrapport")
        public String gemTilstandsrapport(HttpSession session, @ModelAttribute Tilstandsrapport tilstandsrapport) {
            if (ikkeLoggedInd(session)) {
                return "redirect:/login";
            }
         tilstandsrapportService.addTilstandsrapport(tilstandsrapport);
            return "redirect:/tilstandsrapportOverblik";
        }

        @PostMapping("/tilstandsrapport/slet/{id}")
        public String sletTilstandsrapport(HttpSession session, @PathVariable("id") int tilstandsrapportId) {
            if (ikkeLoggedInd(session)) {
                return "redirect:/login";
            }
           else tilstandsrapportService.deleteById(tilstandsrapportId);
            return "redirect:/tilstandsrapportOverblik";
        }
    }


