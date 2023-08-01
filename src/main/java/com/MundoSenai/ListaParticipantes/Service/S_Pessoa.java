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


    public static String inserirDados(String nome, BigInteger cpf, BigInteger telefone,
                                      String email){
        M_Pessoa mPessoa = new M_Pessoa();
        mPessoa.setNome(nome);
        mPessoa.setCpf(cpf);
        mPessoa.setTelefone(telefone);
        mPessoa.setEmail(email);
        pessoa.save(mPessoa);
        return  "Inserido com sucesso";
    }



    public S_Pessoa(R_Pessoa pessoa)
    {this.pessoa = pessoa;}


    public static M_Pessoa cadastraPessoa(String nome, BigInteger cpf, BigInteger telefone,
                                          String email) {
        return pessoa.cadastrarPessoa(nome, cpf, telefone, email);
    }

}
