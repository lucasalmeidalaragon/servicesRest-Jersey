/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.TratamentoDAO;
import com.genericrest.model.Paciente;
import com.genericrest.model.Tratamento;
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
public class TratamentoDAOImpl extends GenericDAO<Tratamento, Long> implements TratamentoDAO{
    
    private static final Logger LOG = LoggerFactory.getLogger(TratamentoDAOImpl.class);

    public TratamentoDAOImpl() {
        super(Tratamento.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Tratamento findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Tratamento.findByNome", Tratamento.class);
        query.setParameter("nome", nome);
        List<Tratamento> tratamentos = query.getResultList();

        if (tratamentos == null || tratamentos.isEmpty()) {
            return null;
        } else if (tratamentos.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return tratamentos.get(0);
        }
    }
    
}
