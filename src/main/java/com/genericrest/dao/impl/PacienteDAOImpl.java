/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.PacienteDAO;
import com.genericrest.model.Hospital;
import com.genericrest.model.Paciente;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Almeida
 */
@ApplicationScoped
public class PacienteDAOImpl extends GenericDAO<Paciente, Long> implements PacienteDAO{

    private static final Logger LOG = LoggerFactory.getLogger(PacienteDAOImpl.class);
    
    public PacienteDAOImpl() {
        super(Paciente.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Paciente findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Paciente.findByNome", Paciente.class);
        query.setParameter("nome", nome);
        List<Paciente> pacientes = query.getResultList();

        if (pacientes == null || pacientes.isEmpty()) {
            return null;
        } else if (pacientes.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return pacientes.get(0);
        }
    }

}