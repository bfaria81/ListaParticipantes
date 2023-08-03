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
    private static R_Pessoa pessoa;


    public static String inserirDados(String nome, String cpf, String telefone,
                                      String email, String senha){
        M_Pessoa mPessoa = new M_Pessoa();
        mPessoa.setNome(nome);
        mPessoa.setCpf(Long.valueOf(cpf));
        mPessoa.setTelefone(Long.valueOf(telefone));
        mPessoa.setEmail(email);
        mPessoa.setSenha(senha);
        pessoa.save(mPessoa);
        return  "Cadastrado com sucesso";
    }



    public S_Pessoa(R_Pessoa pessoa)
    {this.pessoa = pessoa;}


    public static M_Pessoa cadastrarPessoa(String nome, String cpf, String telefone,
                                          String email, String senha) {
        return pessoa.cadastrarPessoa(nome, cpf, telefone, email, senha);
    }



}
