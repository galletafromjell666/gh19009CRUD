/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.pruebacrud.entities.Objeto;

/**
 *
 * @author Sara
 */
@Stateless
@LocalBean
public class ControllerObjeto extends AbstractDataAcces<Objeto> implements Serializable{
    
        @PersistenceContext(unitName = "bachePU")
        EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public ControllerObjeto(){
        super(Objeto.class);
    }
}
