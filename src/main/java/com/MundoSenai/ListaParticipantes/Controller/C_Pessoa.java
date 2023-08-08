package com.MundoSenai.ListaParticipantes.Controller;

import com.MundoSenai.ListaParticipantes.Model.M_Pessoa;
import com.MundoSenai.ListaParticipantes.Service.S_Pessoa;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
@SessionAttributes("pessoa")
public class C_Pessoa {

@GetMapping("/")
public String landPage(){
    return "Login/login";
}

@PostMapping("/")
public String loginPessoa(@RequestParam("usuario")String usuario,
                          @RequestParam("senha")String senha){
    return "Home/home";
}

@ModelAttribute("pessoa")
public M_Pessoa getNome(HttpSession session) {return (M_Pessoa) session.getAttribute("nome");}
@GetMapping("/cadastro")
public String verPagina(HttpSession session) {

    if (session.getAttribute("pessoa") == null) {
            // A sessão existe, redirecionar para a página home
            return "Cadastro/cadastro";
    } else {
            // A sessão não existe, redirecionar para a página de login
            return "redirect:/login";
        }
    }
@PostMapping ("/cadastro")
public String getCadastro(@RequestParam("nome") String nome,
                                 @RequestParam("cpf") String cpf,
                                 @RequestParam("telefone") String telefone,
                                 @RequestParam("email") String email,
                                 @RequestParam("senha") String senha,
                                 @RequestParam("conf_Senha") String conf_Senha, HttpSession session) {

    S_Pessoa.inserirDados(nome, cpf, telefone, email, senha, conf_Senha);
    return "redirect:/";
}



}
