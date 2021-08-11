package com.example.demo.models;

import lombok.Data;

@Data
public class Usuario {
    private String nome;
    private int id;
    private String email;
    private long cep;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
}