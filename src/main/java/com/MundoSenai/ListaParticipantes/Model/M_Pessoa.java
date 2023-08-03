package com.MundoSenai.ListaParticipantes.Model;

import jakarta.persistence.*;

import java.math.BigInteger;


@Entity
@Table(name = "pessoa")
public class M_Pessoa {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nome;
 private Long cpf;
 private Long telefone;
 private String email;
 private String senha;


 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public Long getCpf() {
  return cpf;
 }

 public void setCpf(Long cpf) {
  this.cpf = cpf;
 }

 public Long getTelefone() {
  return telefone;
 }

 public void setTelefone(Long telefone) {
  this.telefone = telefone;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getSenha() {
  return senha;
 }

 public void setSenha(String senha) {
  this.senha = senha;
 }
}




