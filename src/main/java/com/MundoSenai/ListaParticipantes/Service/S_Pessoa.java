package com.MundoSenai.ListaParticipantes.Service;

import com.MundoSenai.ListaParticipantes.Model.M_Pessoa;
import com.MundoSenai.ListaParticipantes.Repository.R_Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;

@Service
@Component
public class S_Pessoa {
    @Autowired
    private static R_Pessoa r_pessoa;


    public static String inserirDados(String nome, String cpf, String telefone,
                                      String email, String senha, String conf_Senha){
        String mensagem = "";
        boolean podeSalvar = true;

        if(!senha.equals(conf_Senha) || senha == null || senha.trim().equals("")){
            mensagem += "Senha e confirmação devem ser iguais e a senha deve ser informada!";
            podeSalvar = false;
        }
        if(!S_ValidadorCPF.validarCPF(cpf)){
            mensagem += "CPF inválido!";
            podeSalvar = false;
        }
        if(nome == null || nome.trim().equals("")){
            mensagem += "O Nome precisa ser informado!";
            podeSalvar = false;
        }
        if ((email == null || email.trim().equals("")) && (telefone == null || telefone.trim().equals(""))){
            mensagem += "E-mail ou Telefone precisa ser informado!";
            podeSalvar = false;
        }

        if(podeSalvar) {
            M_Pessoa mPessoa = new M_Pessoa();
            mPessoa.setNome(nome);
            mPessoa.setCpf(Long.valueOf(S_LimpaNumero.limpar(cpf)));
            mPessoa.setTelefone(Long.valueOf(S_LimpaNumero.limpar(telefone)));
            mPessoa.setEmail(email);
            mPessoa.setSenha(senha);
            r_pessoa.save(mPessoa);
            mensagem += "Pessoa Cadastrada com Sucesso!";
        }
        return mensagem;
    }

    public S_Pessoa(R_Pessoa r_pessoa)
    {this.r_pessoa = r_pessoa;}


    public static M_Pessoa cadastrarPessoa(String nome, String cpf, String telefone,
                                          String email, String senha) {
        return r_pessoa.cadastrarPessoa(nome, cpf, telefone, email, senha);
    }



}
