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


    private boolean ikkeLoggedInd(HttpSession session)
    {
        Boolean loggedeInd = (Boolean) session.getAttribute("loggedeInd");

        // Returner true hvis: "loggedInd" ikke findes i sessionen (dvs. null fx, når man besøger en hjemmeside og session ikke har gemt nogle oplysninger) eller "loggedInd" findes men er false, altså brugeren er ikke logget ind
        return loggedeInd == null || !loggedeInd;
    }

    @GetMapping("/login")
    public String visLogin(Model model)
    {
        model.addAttribute("login", new Login());
        return "login";
    }


    @PostMapping("/login")
    public String tjekLogin(@RequestParam String email, @RequestParam String adgangskode, HttpSession session, Model model)
    {
        Medarbejder medarbejder = medarbejderService.findByEmail(email);

        if (medarbejder != null && medarbejderService.validateLogin(email, adgangskode)) {
            session.setAttribute("medarbejderId", medarbejder.getMedarbejderId());
            session.setAttribute("medarbejderNavn", medarbejder.getNavn());
            session.setAttribute("medarbejderRolle", medarbejder.getRolle());
            session.setAttribute("loggedeInd", true);
            return "redirect:/dashboard";
        }
        model.addAttribute("fejl","Forkert email eller adgangskode");
        return "login";
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session)
    {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/")
     public String home(HttpSession session) {
        if (ikkeLoggedInd(session))
        {
            return "redirect:/login";
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model)
    {
        if(ikkeLoggedInd(session))
        {
            return "redirect:/login";
        }
        model.addAttribute("medarbejderNavn",session.getAttribute("medarbejderNavn"));
        model.addAttribute("medarbejderRolle",session.getAttribute("medarbejderRolle"));

        return "dashboard";
    }




}
