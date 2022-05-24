/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.resources;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Path("/All")
    public Response findAll(){
        List<Estado> registros = toBean.findAll();
        Long total = toBean.contar();
        return Response.ok(registros).header("Total-registros", total).build();
    }
    
    @GET
    @Path("/{idEstado}")
    @Produces({"application/json; charset=UTF-8"})
    public Estado findById(@PathParam("idEstado")int id){
        Estado registro = toBean.findById(id);
        return registro;
    }
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findRange(
            @QueryParam(value="first")
            @DefaultValue(value="0") int first,
            @QueryParam(value="pageSize")
            @DefaultValue(value="30") int pageSize){
        List<Estado> registros = toBean.findRange(first, pageSize);
        Long total = toBean.contar();
        return Response.ok(registros)
                .header("Total-registros", total)
                .build();
    }
    
    @GET
    @Path("/contar")
    public CompletableFuture<Long> contar(){
        return CompletableFuture.supplyAsync(toBean::contar);
    }
    
    @POST
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    public Response crear(Estado estado){
        toBean.crear(estado);
        Estado registro = toBean.findById(estado.getIdEstado());
        return Response.ok(registro).build();
    }
    
    @PUT
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    public Response modificar(Estado estado){
        toBean.modificar(estado);
        Estado registro = toBean.findById(estado.getIdEstado());
        return Response.ok(registro).build();
    }
    
    @DELETE
    @Path("/{idEstado}")
    public void eliminar(@PathParam("idEstado")int id){
        Estado registro = toBean.findById(id);
        toBean.eliminar(registro);
    }
}
