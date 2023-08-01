package com.MundoSenai.ListaParticipantes.Model;

import jakarta.persistence.*;

import java.math.BigInteger;


@Entity
@Table(name = "pessoa")
public class M_Pessoa {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String nome;
 private BigInteger cpf;
 private BigInteger telefone;
 private String email;


 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public BigInteger getCpf() {
  return cpf;
 }

 public void setCpf(BigInteger cpf) {
  this.cpf = cpf;
 }

 public BigInteger getTelefone() {
  return telefone;
 }

 public void setTelefone(BigInteger telefone) {
  this.telefone = telefone;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }
}




