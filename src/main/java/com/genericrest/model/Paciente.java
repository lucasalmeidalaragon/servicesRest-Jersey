/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Almeida
 */
@Entity
@Table(name = "pacientes")
@NamedQueries({
    @NamedQuery(name = "Paciente.findByNome", query = "select p from Paciente p where p.nome = :nome")
})
@XmlRootElement(name = "pacientes")
public class Paciente extends AbstractEntity{
    
    @Column(length = 255, nullable = false)
    private String nome;
      
    @ManyToOne
    private Zona zona;

    public Paciente() {
    }

    public Paciente(String nome, Zona zona) {
        this.nome = nome;
        this.zona = zona;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

   
    @Override
    public void updateParameters(Object entity) {
        final Paciente other = (Paciente) entity;
        this.nome = other.nome; 
        this.zona = other.zona;
    }
    
      @Override
    public String toString() {
        return "Paciente{" + "nome=" + nome + ", zona=" + zona + '}';
    }

}


