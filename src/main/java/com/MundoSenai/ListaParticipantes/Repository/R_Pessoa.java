package com.MundoSenai.ListaParticipantes.Repository;

import com.MundoSenai.ListaParticipantes.Model.M_Pessoa;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDate;

@Repository
public interface R_Pessoa extends JpaRepository<M_Pessoa, Long> {

//    @Query(value = "INSERT INTO pessoa (nome, cpf, telefone, email, senha)" +
//            "Values (:nome, :cpf, :telefone, :email, :senha)", nativeQuery = true)
//    M_Pessoa cadastrarPessoa (@Param("nome")String nome,
//                              @Param("cpf") String cpf,
//                              @Param("telefone")String telefone,
//                              @Param("email")String email,
//                              @Param("senha")String senha);

    @Query(value = "SELECT * FROM pessoa WHERE id = :id", nativeQuery = true)
    M_Pessoa findById(@Param("id")String id);


}





