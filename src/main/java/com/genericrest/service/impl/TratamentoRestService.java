/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service.impl;

import com.genericrest.dao.DAO;
import com.genericrest.dao.TratamentoDAO;
import com.genericrest.model.Paciente;
import com.genericrest.model.Tratamento;
import com.genericrest.service.GenericCRUDRestService;
import com.genericrest.service.TratamentoService;
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
@Path("/tratamento")
public class TratamentoRestService extends GenericCRUDRestService<Tratamento> implements TratamentoService{

    private static final Logger LOG = LoggerFactory.getLogger(TratamentoRestService.class); 
    
    public TratamentoRestService() {
        super(Tratamento.class);
    }
    

    @Inject
    private TratamentoDAO tratamentoDAO;
    
    /**
     * 
     * @param list
     * @return 
     */
    @GET
    @Path("/nome/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
        
    @Override
    public GenericEntity listToGenericEntity(List<Tratamento> list) {
        return new GenericEntity<List<Tratamento>>(list){}; 
    }
    
    public Response getByNome(@PathParam("param") String nome) {
        getLogger().debug("Pesquise o Tratamento: {}", nome);
        Tratamento achar = tratamentoDAO.findByNome(nome);
        if (achar == null){
            return Response.noContent().build();
        }
        return Response.ok().entity(achar).build();
    }


    @Override
    public DAO getDao() {
        return tratamentoDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
    
    
    
}
