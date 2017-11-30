/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Almeida
 */
@Entity
@Table(name = "hospitais")
@NamedQueries({
        @NamedQuery(name =  "Hospital.findByNome", query = "select h from Hospital h where h.nome = :nome") 
})
@XmlRootElement(name = "hospitais")
public class Hospital extends AbstractEntity{
    
    @Column(length = 255, nullable = false)
    private String nome;
    
    @Column(length = 255, nullable = false, updatable = false)
    private String endereco; 
    
    @Column(length = 20, nullable = false, updatable = false)
    private String telefone;

    public Hospital() {
    }

    public Hospital(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Hospital{" + "nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }

    @Override
    public void updateParameters(Object entity) {
        final Hospital other = (Hospital) entity;
       this.endereco = other.endereco; 
       this.nome = other.nome;
       this.telefone = other.telefone;
    }
    
}
