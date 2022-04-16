/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.resources;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import ues.pruebacrud.controller.ControllerEstado;
import ues.pruebacrud.entities.Estado;

/**
 *
 * @author Sara
 */
@Path("estado")
@RequestScoped
public class EstadoResource implements Serializable{
    
    @Inject
    ControllerEstado toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findAll(){
        List<Estado> registros = toBean.findAll();
        Long total = toBean.contar();
        return Response.ok(registros).header("Total registros", total).build();
    }
    
}
