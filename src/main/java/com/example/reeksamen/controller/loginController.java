package com.example.reeksamen.controller;
import com.example.reeksamen.model.Login;
import com.example.reeksamen.model.Medarbejder;
import com.example.reeksamen.service.medarbejderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    @Autowired
    medarbejderService medarbejderService;

    @GetMapping("/login")
    public String visLogin(Model model)
    {
        model.addAttribute("login", new Login());
        return "login";
    }


    @PostMapping("/Login")
    public String tjekLogin(@RequestParam String email, @RequestParam String adgangskode, HttpSession session, Model model)
    {
        Medarbejder medarbejder = medarbejderService.findByEmail(email);

        if (medarbejder != null && medarbejderService.validateLogin(email, adgangskode)) {
            session.setAttribute("medarbejderId", medarbejder.getMedarbejderId());
            session.setAttribute("medarbejderNavn", medarbejder.getNavn());
            session.setAttribute("medarbejderRolle", medarbejder.getRolle());
            session.setAttribute("loggedInd", true);
            return "redirect:/dashboard";
        }
        else model.addAttribute("fejl","Forkert email eller adgangskode");
        return "login";




    }




}
