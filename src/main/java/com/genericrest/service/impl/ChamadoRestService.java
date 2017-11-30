/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service.impl;

import com.genericrest.dao.ChamadoDAO;
import com.genericrest.dao.DAO;
import com.genericrest.model.Chamado;
import com.genericrest.service.ChamadoService;
import com.genericrest.service.GenericCRUDRestService;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Almeida
 */
@ManagedBean
@Path("/chamado")
public class ChamadoRestService extends GenericCRUDRestService<Chamado> implements ChamadoService{

    private static final Logger LOG = LoggerFactory.getLogger(ChamadoRestService.class);
    
    @Inject
    private ChamadoDAO chamadoDAO;
    
    public ChamadoRestService() {
        super(Chamado.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Chamado> list) {
        return new GenericEntity<List<Chamado>>(list){};
    }

    @Override
    public DAO getDao() {
        return chamadoDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
    
    @GET
    @Path("/data/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    
    public Response findByData(@PathParam("param") Date data) {
        getLogger().debug("Pesquise o chamado: {}", data);
        Chamado found = chamadoDAO.findByData(data);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

    @Override
    public Response getBydata(Date data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
