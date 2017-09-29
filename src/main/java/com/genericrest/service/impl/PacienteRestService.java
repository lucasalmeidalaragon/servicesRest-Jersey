/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service.impl;

import com.genericrest.dao.DAO;
import com.genericrest.dao.PacienteDAO;
import com.genericrest.model.Paciente;
import com.genericrest.service.GenericCRUDRestService;
import com.genericrest.service.PacienteService;
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
@Path("/paciente")
public class PacienteRestService extends GenericCRUDRestService<Paciente> implements PacienteService {

    private static final Logger LOG = LoggerFactory.getLogger(PacienteRestService.class);

    @Inject
    private PacienteDAO pacienteDAO;

    public PacienteRestService() {
        super(Paciente.class);
    }
    
   /**
     *
     * @param nome
     * @return
     */
    @GET
    @Path("/nome/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
        

    @Override
    public GenericEntity listToGenericEntity(List<Paciente> list) {
        return new GenericEntity<List<Paciente>>(list){};
    }
    

    @Override
    public Response getByNome(@PathParam("param") String nome) {
        getLogger().debug("Pesquise Paciente: {}", nome);
        Paciente achar = pacienteDAO.findByNome(nome);
        if (achar == null){
            return Response.noContent().build();
        }
        return Response.ok().entity(achar).build();
    }

        @Override
    public DAO getDao() {
        return pacienteDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}  