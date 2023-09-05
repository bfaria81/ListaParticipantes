package com.MundoSenai.ListaParticipantes.Service;

import com.MundoSenai.ListaParticipantes.Model.M_Pessoa;
import com.MundoSenai.ListaParticipantes.Model.M_Resposta;
import com.MundoSenai.ListaParticipantes.Repository.R_Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.time.LocalDate;

@Service
@Component
public class S_Pessoa {
    @Autowired
    private static R_Pessoa r_pessoa;


    public static M_Resposta inserirDados(String nome, String cpf, String telefone,
                                      String email, String senha, String conf_Senha){
        String mensagem = "";
        boolean podeSalvar = true;

        if(!senha.equals(conf_Senha) || senha == null || senha.trim().equals("")){
            mensagem += "Senha e confirmação devem ser iguais e a senha deve ser informada !<br/>";
            podeSalvar = false;
        }
        if(!S_ValidadorCPF.validarCPF(cpf)){
            mensagem += "CPF inválido !<br/>";
            podeSalvar = false;
        }
        if(nome == null || nome.trim().equals("")){
            mensagem += "O Nome precisa ser informado !<br/>";
            podeSalvar = false;
        }
        if ((email == null || email.trim().equals("")) && (telefone == null || telefone.trim().equals(""))){
            mensagem += "E-mail ou Telefone precisa ser informado !<br/>";
            podeSalvar = false;
        }


        if(podeSalvar){
            M_Pessoa mPessoa = new M_Pessoa();
            mPessoa.setNome(nome);
            mPessoa.setCpf(Long.valueOf(S_LimpaNumero.limpar(cpf)));
            telefone = S_LimpaNumero.limpar(telefone);

            if(telefone == ""){
                mPessoa.setTelefone(null);
            }else {
                mPessoa.setTelefone(Long.valueOf(telefone));
            }

            mPessoa.setEmail(email);
            mPessoa.setSenha(senha);

            try {
                r_pessoa.save(mPessoa);
                mensagem += "Pessoa Cadastrada com Sucesso !<br/>";
            }catch (DataIntegrityViolationException e){ //DataIntegrity é a exceção do Spring
                if(e.getMessage().contains("u_cpf")){
                    mensagem += "O CPF informado já foi cadastrado!";
                } else {
                    mensagem += "Erro ao cadastrar";
                }
                podeSalvar = false;
            }
        }
        M_Resposta m_resposta = new M_Resposta(podeSalvar, mensagem);
        return m_resposta;
    }




    public S_Pessoa(R_Pessoa r_pessoa)
    {this.r_pessoa = r_pessoa;}


//    public static M_Pessoa cadastrarPessoa(String nome, String cpf, String telefone,
//                                          String email, String senha) {
//        return r_pessoa.cadastrarPessoa(nome, cpf, telefone, email, senha);
//    }



}
