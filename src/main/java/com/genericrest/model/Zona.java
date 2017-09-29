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
@Table(name = "zonas")
@NamedQueries({
    @NamedQuery(name = "Zona.findByNome", query = "select z from Paciente z where z.nome = :nome")
})
@XmlRootElement(name = "zonas")
public class Zona extends AbstractEntity{
    
    @Column(length = 255, nullable = false)
    private String nome;

    @ManyToOne
    private Hospital hospital;
    
    public Zona() {
    }

    public Zona(String nome, Hospital hospital) {
        this.nome = nome;
        this.hospital = hospital;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    
    
   
    @Override
    public void updateParameters(Object entity) {
        final Zona zona = (Zona) entity;
        this.nome = zona.getNome(); 
    }
    

    @Override
    public String toString() {
        return "Zona{" + "nome=" + nome + '}';
    }

}