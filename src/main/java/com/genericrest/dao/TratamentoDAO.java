/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao;


import com.genericrest.model.Tratamento;

/**
 *
 * @author Almeida
 */
public interface TratamentoDAO extends DAO<Tratamento, Long>{
    
     Tratamento findByNome(String nome);  
}
