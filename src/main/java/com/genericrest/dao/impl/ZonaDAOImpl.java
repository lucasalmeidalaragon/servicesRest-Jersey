/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.ZonaDAO;
import com.genericrest.model.Paciente;
import com.genericrest.model.Zona;
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
public class ZonaDAOImpl extends GenericDAO<Zona, Long> implements ZonaDAO{

    private static final Logger LOG = LoggerFactory.getLogger(ZonaDAOImpl.class);
    
    public ZonaDAOImpl() {
        super(Zona.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Zona findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Zona.findByNome", Zona.class);
        query.setParameter("nome", nome);
        List<Zona> zonas = query.getResultList();

        if (zonas == null || zonas.isEmpty()) {
            return null;
        } else if (zonas.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return zonas.get(0);
        }
    }
    



    
    
    
}
