/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.TratamentoDAO;
import com.genericrest.model.Tratamento;
import javax.enterprise.context.ApplicationScoped;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
