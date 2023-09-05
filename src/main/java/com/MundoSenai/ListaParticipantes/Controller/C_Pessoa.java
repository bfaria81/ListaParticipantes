package com.MundoSenai.ListaParticipantes.Controller;


import com.MundoSenai.ListaParticipantes.Model.M_Resposta;

import com.MundoSenai.ListaParticipantes.Service.S_Login;
import com.MundoSenai.ListaParticipantes.Service.S_Pessoa;

import jakarta.servlet.http.HttpSession;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigInteger;

@Controller
@SessionAttributes("usuario")
public class C_Pessoa {

@GetMapping("/")
public String landPage(){
    return "Login/login";
}

@PostMapping("/")
public String loginPessoa(@RequestParam("usuario")String usuario,
                          @RequestParam("senha")String senha,
                          HttpSession session){
    session.setAttribute("usuario", S_Login.validaLogin(usuario, senha));

    if(session.getAttribute("usuario") != null){
        return "Home/home";
    } else {
        return "redirect:/";
    }
}
@GetMapping("/cadastro")
    public String getCadastro(){
        return "Cadastro/cadastro";
    }




//@ModelAttribute("pessoa")
//public M_Pessoa getNome(HttpSession session) {return (M_Pessoa) session.getAttribute("nome");}
//@GetMapping("/cadastro")
//public String verPagina(HttpSession session) {
//
//    if (session.getAttribute("pessoa") == null) {
//            // A sessão existe, redirecionar para a página home
//            return "Cadastro/cadastro";
//    } else {
//            // A sessão não existe, redirecionar para a página de login
//            return "redirect:/login";
//        }
//    }


@PostMapping ("/cadastro")
public String getCadastro(@RequestParam("nome") String nome,
                          @RequestParam("cpf") String cpf,
                          @RequestParam("telefone") String telefone,
                          @RequestParam("email") String email,
                          @RequestParam("senha") String senha,
                          @RequestParam("conf_Senha") String conf_Senha,
                          RedirectAttributes redirectAttributes){

    M_Resposta m_resposta = S_Pessoa.inserirDados(nome, cpf, telefone, email, senha, conf_Senha);
    if(m_resposta.getStatus()){
        redirectAttributes.addFlashAttribute("mensagem", m_resposta.getMensagem());
        return "redirect:/"; //mudado de redirect:/
    } else {
        redirectAttributes.addFlashAttribute("mensagem", m_resposta.getMensagem());
        redirectAttributes.addFlashAttribute("nome", nome);
        redirectAttributes.addFlashAttribute("cpf", cpf);
        redirectAttributes.addFlashAttribute("telefone", telefone);
        redirectAttributes.addFlashAttribute("email", email);
        redirectAttributes.addFlashAttribute("senha", senha);
        return "redirect:/cadastro";
    }
}



}
