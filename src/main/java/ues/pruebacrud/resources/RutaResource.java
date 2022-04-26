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
import ues.pruebacrud.controller.ControllerRuta;
import ues.pruebacrud.entities.Ruta;

/**
 *
 * @author Sara
 */
@Path("ruta")
@RequestScoped
public class RutaResource implements Serializable{
    
    @Inject
    ControllerRuta toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findAll(){
        List<Ruta> registros = toBean.findAll();
        Long total = toBean.contar();
        return Response.ok(registros).header("Total-registros", total).build();
    }
    
    @GET
    @Path("/{idRuta}")
    @Produces({"application/json; charset=UTF-8"})
    public Ruta findById(@PathParam("idRuta")int id){
        Ruta registro = toBean.findById(id);
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
    public Response crear(Ruta ruta){
        toBean.crear(ruta);
        Ruta registro = toBean.findById(ruta.getIdRuta());
        return Response.ok(registro).build();
    }
    
    @PUT
    @Consumes({"application/json; charset=UTF-8"})
    @Produces({"application/json; charset=UTF-8"})
    public Response modificar(Ruta ruta){
        toBean.modificar(ruta);
        Ruta registro = toBean.findById(ruta.getIdRuta());
        return Response.ok(registro).build();
    }
    
    @DELETE
    @Path("/{idRuta}")
    public void eliminar(@PathParam("idRuta")int id){
        Ruta registro = toBean.findById(id);
        toBean.eliminar(registro);
    }
    
}
