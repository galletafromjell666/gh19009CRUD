/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.resources;

import java.io.Serializable;
import java.util.Collections;
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
import ues.pruebacrud.controller.ControllerObjeto;
import ues.pruebacrud.controller.ControllerTipoObjeto;
import ues.pruebacrud.entities.Objeto;
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
    @Inject
    ControllerObjeto toBeanObjeto;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    @Path("/All")
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
            @DefaultValue(value="30") int pageSize){
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
    
    @GET
    @Path("/{idTipoObjeto}/objeto")
    @Produces({"application/json; charset=UTF-8"})
    public Response findByObjeto(@PathParam("idTipoObjeto")int id,
                                 @QueryParam(value="first")
                                 @DefaultValue(value="0") int first,
                                 @QueryParam(value="pageSize")
                                 @DefaultValue(value="30") int pageSize
                                 ){
        List<Objeto> registros = toBeanObjeto.findByIdTipoObjeto(id, first, pageSize);
        return Response.ok(registros).build();
    }
    
    @GET
    @Path("/{idTipoObjeto}/objeto/{idObjeto}")
    @Produces({"application/json; charset=UTF-8"})
    public Response findByIdObjeto(@PathParam("idObjeto")Long idObjeto, @PathParam("idTipoObjeto") int id){
        List<Objeto> registros = toBeanObjeto.findByIdTipoObjeto(id, 0, 10);
        
        for(int i=0; i<registros.size(); i++){
            if(registros.get(i).getIdObjeto()==idObjeto){
                Objeto registro = registros.get(i);
                return Response.ok(registro).build();
            }
        }
        return Response.ok(Collections.EMPTY_LIST).build();
    }
    
    @POST
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    @Path("/{idTipoObjeto}/objeto")
    public Response crearObjeto(Objeto objeto){
        toBeanObjeto.crear(objeto);
        Objeto registro = toBeanObjeto.findById(objeto.getIdObjeto());
        return Response.ok(registro).build();
    }
    
    @PUT
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    @Path("/{idTipoObjeto}/objeto")
    public Response modificarObjeto(Objeto objeto){
        toBeanObjeto.modificar(objeto);
        Objeto registro = toBeanObjeto.findById(objeto.getIdObjeto());
        return Response.ok(registro).build();
    }
    
    @DELETE
    @Path("/{idTipoObjeto}/objeto/{idObjeto}")
    public void eliminarObjeto(@PathParam("idObjeto")Long id){
        Objeto registro = toBeanObjeto.findById(id);
        toBeanObjeto.eliminar(registro);
    }
}
