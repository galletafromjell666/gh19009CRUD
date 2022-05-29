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
import ues.pruebacrud.controller.ControllerObjeto;
import ues.pruebacrud.entities.Objeto;

/**
 *
 * @author Sara
 */
@Path("v1/objeto")
@RequestScoped
public class ObjetoResource implements Serializable{
    
    @Inject
    ControllerObjeto toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    @Path("/All")
    public Response findAll(){
        List<Objeto> registros = toBean.findAll();
        Long total = toBean.contar();
        return Response.ok(registros).header("Total-registros", total).build();
    }
    
    @GET
    @Path("/{idObjeto}")
    @Produces({"application/json; charset=UTF-8"})
    public Objeto findById(@PathParam("idObjeto")Long id){
        Objeto registro = toBean.findById(id);
        return registro;
    }
    
    @GET
    @Path("/nombre/{nombre}")
    @Produces({"application/json; charset=UTF-8"})
    public Response findByName(@PathParam("nombre")String nombre){
        List<Objeto> registros = toBean.findByName(nombre);
        return Response.ok(registros).build();
    }
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findRange(
            @QueryParam(value="first")
            @DefaultValue(value="0") int first,
            @QueryParam(value="pageSize")
            @DefaultValue(value="30") int pageSize){
        List<Objeto> registros = toBean.findRange(first, pageSize);
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
    public Response crear(Objeto objeto, @Context UriInfo uriInfo){
        toBean.crear(objeto);
        Objeto registro = toBean.findById(objeto.getIdObjeto());
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(registro.getIdObjeto())).build();
        return Response.created(uri).entity(registro).build();
    }
    
    @PUT
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    public Response modificar(Objeto objeto, @Context UriInfo uriInfo){
        toBean.modificar(objeto);
        Objeto registro = toBean.findById(objeto.getIdObjeto());
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(registro.getIdObjeto())).build();
        return Response.created(uri).entity(registro).build();
    }
    
    @DELETE
    @Path("/{idObjeto}")
    public void eliminar(@PathParam("idObjeto")Long id){
        Objeto registro = toBean.findById(id);
        toBean.eliminar(registro);
    }
    
}
