/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.resources;

import java.io.Serializable;
import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import ues.pruebacrud.controller.ControllerRuta;
import ues.pruebacrud.entities.Ruta;

/**
 *
 * @author Sara
 */
@Path("v1/ruta")
@RequestScoped
public class RutaResource implements Serializable{
    
    @Inject
    ControllerRuta toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    @Path("/All")
    public Response findAll(){
        List<Ruta> registros = toBean.findAll();
        Long total = toBean.contar();
        return Response.ok(registros).header("Total-registros", total).build();
    }
    
    @GET
    @Path("/{idRuta}")
    @Produces({"application/json; charset=UTF-8"})
    public Ruta findById(@PathParam("idRuta")Long id){
        Ruta registro = toBean.findById(id);
        return registro;
    }
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findRange(
            @QueryParam(value="first")
            @DefaultValue(value="0") int first,
            @QueryParam(value="pageSize")
            @DefaultValue(value="30") int pageSize){
        List<Ruta> registros = toBean.findRange(first, pageSize);
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
    public Response crear(Ruta ruta, @Context UriInfo uriInfo){
        toBean.crear(ruta);
        Ruta registro = toBean.findById(ruta.getIdRuta());
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(registro.getIdRuta())).build();
        return Response.created(uri).entity(registro).build();
    }
    
    @PUT
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    public Response modificar(Ruta ruta, @Context UriInfo uriInfo){
        toBean.modificar(ruta);
        Ruta registro = toBean.findById(ruta.getIdRuta());
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(registro.getIdRuta())).build();
        return Response.created(uri).entity(registro).build();
    }
    
    @DELETE
    @Path("/{idRuta}")
    public void eliminar(@PathParam("idRuta")Long id){
        Ruta registro = toBean.findById(id);
        toBean.eliminar(registro);
    }
    
}
