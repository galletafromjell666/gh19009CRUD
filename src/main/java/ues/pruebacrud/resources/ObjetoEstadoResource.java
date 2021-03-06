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
import ues.pruebacrud.controller.ControllerObjetoEstado;
import ues.pruebacrud.entities.ObjetoEstado;

/**
 *
 * @author Sara
 */
@Path("v1/objetoEstado")
@RequestScoped
public class ObjetoEstadoResource implements Serializable{
    
    @Inject
    ControllerObjetoEstado toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    @Path("/All")
    public Response findAll(){
        List<ObjetoEstado> registros = toBean.findAll();
        Long total = toBean.contar();
        return Response.ok(registros).header("Total-registros", total).build();
    }
    
    @GET
    @Path("/{idObjetoEstado}")
    @Produces({"application/json; charset=UTF-8"})
    public ObjetoEstado findById(@PathParam("idObjetoEstado")Long id){
        ObjetoEstado registro = toBean.findById(id);
        return registro;
    }
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findRange(
            @QueryParam(value="first")
            @DefaultValue(value="0") int first,
            @QueryParam(value="pageSize")
            @DefaultValue(value="30") int pageSize){
        List<ObjetoEstado> registros = toBean.findRange(first, pageSize);
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
    public Response crear(ObjetoEstado objetoEstado, @Context UriInfo uriInfo){
        toBean.crear(objetoEstado);
        ObjetoEstado registro = toBean.findById(objetoEstado.getIdObjetoEstado());
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(registro.getIdObjetoEstado())).build();
        return Response.created(uri).entity(registro).build();
    }
    
    @PUT
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    public Response modificar(ObjetoEstado objetoEstado, @Context UriInfo uriInfo){
        toBean.modificar(objetoEstado);
        ObjetoEstado registro = toBean.findById(objetoEstado.getIdObjetoEstado());
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(registro.getIdObjetoEstado())).build();
        return Response.created(uri).entity(registro).build();
    }
    
    @DELETE
    @Path("/{idObjetoEstado}")
    public void eliminar(@PathParam("idObjetoEstado")Long id){
        ObjetoEstado registro = toBean.findById(id);
        toBean.eliminar(registro);
    }
    
}
