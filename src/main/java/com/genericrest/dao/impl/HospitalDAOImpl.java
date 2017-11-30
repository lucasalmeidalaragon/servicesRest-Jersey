/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.HospitalDAO;
import com.genericrest.model.Hospital;
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
public class HospitalDAOImpl extends GenericDAO<Hospital, Long> implements HospitalDAO{

    private static final Logger LOG = LoggerFactory.getLogger(HospitalDAOImpl.class);

    
    
    public HospitalDAOImpl() {
        super(Hospital.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Hospital findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Hospital.findByNome", Hospital.class);
        query.setParameter("nome", nome);
        List<Hospital> hospitals = query.getResultList();

        if (hospitals == null || hospitals.isEmpty()) {
            return null;
        } else if (hospitals.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return hospitals.get(0);
        }
    }
    
    
    
}
