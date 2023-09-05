package com.MundoSenai.ListaParticipantes.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class C_Home {


    @GetMapping("/Home")
    public String getHome(HttpSession session){
        if(session.getAttribute("usuario") != null){
            return "Home/home";
        }
        return "redirect:/";
    }






}
