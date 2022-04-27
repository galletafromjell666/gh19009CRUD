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
import ues.pruebacrud.entities.TipoObjeto;

/**
 *
 * @author Sara
 */
@Stateless
@LocalBean
public class ControllerTipoObjeto extends AbstractDataAcces<TipoObjeto> implements Serializable{
    
        @PersistenceContext(unitName = "bachePU")
        EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public ControllerTipoObjeto(){
        super(TipoObjeto.class);
    }
    
    @Override
    public Long contar() throws IllegalStateException{
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        return super.contar();
    }
    
}
