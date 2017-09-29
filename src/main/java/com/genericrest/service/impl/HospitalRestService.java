/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service.impl;

import com.genericrest.dao.DAO;
import com.genericrest.dao.HospitalDAO;
import com.genericrest.model.Hospital;
import com.genericrest.service.GenericCRUDRestService;
import com.genericrest.service.HospitalService;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Almeida
 */
@ManagedBean
@Path("/hospital")
public class HospitalRestService extends GenericCRUDRestService<Hospital> implements HospitalService{

    private static final Logger LOG = LoggerFactory.getLogger(HospitalRestService.class);
    
    @Inject
    private HospitalDAO hospitalDAO;
    
    public HospitalRestService() {
        super(Hospital.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Hospital> list) {
        return new GenericEntity<List<Hospital>>(list){};
    }

    @Override
    public DAO getDao() {
        return hospitalDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Response getByNome(String nome) {
      getLogger().debug("Pesquise Hospital: {}", nome);
        Hospital achar = hospitalDAO.findByNome(nome);
        if (achar == null){
            return Response.noContent().build();
        }
        return Response.ok().entity(achar).build();
    }
    
}
