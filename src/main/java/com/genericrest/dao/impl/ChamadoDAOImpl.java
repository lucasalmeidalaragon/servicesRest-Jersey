/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.ChamadoDAO;
import com.genericrest.dao.GenericDAO;
import com.genericrest.model.Chamado;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Almeida
 */
@ApplicationScoped
public class ChamadoDAOImpl extends GenericDAO<Chamado, Long> implements ChamadoDAO{
    
    private static final Logger LOG = LoggerFactory.getLogger(ChamadoDAOImpl.class);

    public ChamadoDAOImpl() {
        super(Chamado.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<Chamado> findByData(Date data) {
        Query query = getEntityManager().createNamedQuery("Chamado.findByData", Chamado.class);
        query.setParameter("data", data);
        
        List<Chamado> chamados = query.getResultList();
        if (chamados == null || chamados.isEmpty()){
            return null;
        } else {
            return chamados;
        }
    }
    
}
