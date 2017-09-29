/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.HospitalDAO;
import com.genericrest.model.Hospital;
import javax.enterprise.context.ApplicationScoped;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
