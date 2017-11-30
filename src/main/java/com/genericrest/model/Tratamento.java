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
@Table(name = "tratamentos")
@NamedQueries({
    @NamedQuery(name = "Tratamentos.findByNome", query = "select t from Tratamento t where t.nome = :nome")
})
@XmlRootElement(name = "tratamentos")
public class Tratamento extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String nome;

    
    public Tratamento() {
    }

    public Tratamento(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Tratamento{" + "nome=" + nome + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void updateParameters(Object entity) {
        final Tratamento other = (Tratamento) entity;
        this.nome = other.nome;
    }
    
}
