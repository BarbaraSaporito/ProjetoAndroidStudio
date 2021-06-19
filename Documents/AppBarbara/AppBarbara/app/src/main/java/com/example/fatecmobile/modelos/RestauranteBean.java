package com.example.fatecmobile.modelos;

import java.io.Serializable;

public class RestauranteBean implements Serializable {

    String id;
    String nome;
    String cep;
    String endereco;
    String bairro;
    String telefone;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Restaurante {" +
                " Id = '" + id + '\'' +
                ", Nome = '" + nome + '\'' +
                ", Cep ='" + cep + '\'' +
                ", Endereço = '" + endereco + '\'' +
                ", Bairro = '" + bairro + '\'' +
                ", Endereco = '" + endereco + '\'' +
                ", Telefone = '" + telefone + '\'' +
                '}';
    }
}
