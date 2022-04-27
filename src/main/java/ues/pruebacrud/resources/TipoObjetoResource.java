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
import ues.pruebacrud.controller.ControllerTipoObjeto;
import ues.pruebacrud.entities.TipoObjeto;

/**
 *
 * @author Sara
 */
@Path("tipoObjeto")
@RequestScoped
public class TipoObjetoResource implements Serializable{
    
    @Inject
    ControllerTipoObjeto toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findAll(){
        List<TipoObjeto> registros = toBean.findAll();
        Long total = toBean.contar();
        return Response.ok(registros).header("Total-registros", total).build();
    }
    
    @GET
    @Path("/{idTipoObjeto}")
    @Produces({"application/json; charset=UTF-8"})
    public TipoObjeto findById(@PathParam("idTipoObjeto")int id){
        TipoObjeto registro = toBean.findById(id);
        return registro;
    }
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findRange(
            @QueryParam(value="first")
            @DefaultValue(value="0") int first,
            @QueryParam(value="pageSize")
            @DefaultValue(value="10") int pageSize){
        List<TipoObjeto> registros = toBean.findRange(first, pageSize);
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
    public Response crear(TipoObjeto tipoObjeto){
        toBean.crear(tipoObjeto);
        TipoObjeto registro = toBean.findById(tipoObjeto.getIdTipoObjeto());
        return Response.ok(registro).build();
    }
    
    @PUT
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    public Response modificar(TipoObjeto tipoObjeto){
        toBean.modificar(tipoObjeto);
        TipoObjeto registro = toBean.findById(tipoObjeto.getIdTipoObjeto());
        return Response.ok(registro).build();
    }
    
    @DELETE
    @Path("/{idTipoObjeto}")
    public void eliminar(@PathParam("idTipoObjeto")int id){
        TipoObjeto registro = toBean.findById(id);
        toBean.eliminar(registro);
    }
    
}
