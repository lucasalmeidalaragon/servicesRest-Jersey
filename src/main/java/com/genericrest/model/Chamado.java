/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Almeida
 */
@Entity
@Table(name = "chamados")
@NamedQueries({
    @NamedQuery(name = "Chamado.findByData", query = "select c from Chamado c where c.data = :data")
})
@XmlRootElement(name = "chamados")
public class Chamado extends AbstractEntity{
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;

    @ManyToOne
    private Paciente paciente;
    
    @ManyToOne
    private Tratamento tratamento;
    
    @Column(length = 255, nullable = false)
    private String detalhes;

    public Chamado() {
    }

    public Chamado(Date data, Paciente paciente, Tratamento tratamento, String detalhes) {
        this.data = data;
        this.paciente = paciente;
        this.tratamento = tratamento;
        this.detalhes = detalhes;
    }
    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    @Override
    public String toString() {
        return "Chamado{" + "data=" + data + ", paciente=" + paciente + ", tratamento=" + tratamento + 
        ", detalhes=" + detalhes + '}';
    }

    @Override
    public void updateParameters(Object entity) {
       final Chamado other = (Chamado) entity;
       this.data = other.data; 
       this.paciente = other.paciente;
       this.tratamento = other.tratamento;
       this.detalhes = other.detalhes;
    }

   
}