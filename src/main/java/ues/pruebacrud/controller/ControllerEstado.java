/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import ues.pruebacrud.entities.Estado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sara
 */
@Stateless
@LocalBean
public class ControllerEstado extends AbstractDataAcces<Estado> implements Serializable{
    
       @PersistenceContext(unitName = "bachePU")
       EntityManager em;

    public ControllerEstado() {
        super(Estado.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
      
     
}
