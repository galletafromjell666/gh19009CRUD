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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import ues.pruebacrud.controller.ControllerObjeto;
import ues.pruebacrud.entities.Objeto;

/**
 *
 * @author Sara
 */
@Path("objeto")
@RequestScoped
public class ObjetoResource implements Serializable{
    
    @Inject
    ControllerObjeto toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findAll(){
        List<Objeto> registros = toBean.findAll();
        Long total = toBean.contar();
        return Response.ok(registros).header("Total-registros", total).build();
    }
    
    @GET
    @Path("/{idObjeto}")
    @Produces({"application/json; charset=UTF-8"})
    public Objeto findById(@PathParam("idObjeto")int id){
        Objeto registro = toBean.findById(id);
        return registro;
    }
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    @Path("/contar")
    public Response contar(){
        Long resultado = toBean.contar();
        return Response.ok(resultado).build();
    }
    
    @POST
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    public Response crear(Objeto objeto){
        toBean.crear(objeto);
        Objeto registro = toBean.findById(objeto.getIdObjeto());
        return Response.ok(registro).build();
    }
    
    @PUT
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    public Response modificar(Objeto objeto){
        toBean.modificar(objeto);
        Objeto registro = toBean.findById(objeto.getIdObjeto());
        return Response.ok(registro).build();
    }
    
    @DELETE
    @Path("/{idObjeto}")
    public void eliminar(@PathParam("idObjeto")int id){
        Objeto registro = toBean.findById(id);
        toBean.eliminar(registro);
    }
    
}
