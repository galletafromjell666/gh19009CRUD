/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import ues.pruebacrud.model.ErrorMessage;

/**
 *
 * @author Sara
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{
    
    @Override
    public Response toResponse(DataNotFoundException ex){
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "https://docs.oracle.com/cd/E19798-01/821-1841/6nmq2cp1v/index.html");
        return Response.status(Status.NOT_FOUND).entity(errorMessage).header("Error", "Entidad no existe").build();
    }
    
}

