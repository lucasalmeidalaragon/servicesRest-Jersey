/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service;

import com.genericrest.model.Chamado;
import java.util.Date;
import javax.ws.rs.core.Response;

/**
 *
 * @author Almeida
 */
public interface ChamadoService extends CRUDRestService<Chamado>{
    
     Response getBydata(Date data);
}