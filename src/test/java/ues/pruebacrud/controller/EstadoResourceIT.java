/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import java.io.StringReader;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ues.pruebacrud.resources.EstadoResource;
import ues.pruebacrud.resources.JAXRSConfiguration;

/**
 *
 * @author Sara
 */
@ExtendWith(ArquillianExtension.class)
public class EstadoResourceIT {
    
    @Deployment
    public static WebArchive crearDespliegue(){
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("ues.pruebacrud.entities")
                .addAsResource("persistence-arquillian.xml")
                .addClass(AbstractDataAcces.class)
                .addClass(ControllerEstado.class)
                .addClass(JAXRSConfiguration.class)
                .addClass(EstadoResource.class)
                .addAsResource("META-INF/persistence.xml","META-INF/persistence.xml")
                .addAsResource("META-INF/sql/datos.sql","META-INF/sql/datos.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml");
        System.out.println(salida.toString(true));
        return salida;
    }
    
    @ArquillianResource
    URL url;
    
    @Test
    @RunAsClient
    public void testFindAll(){
        System.out.println("findAll");
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString()+"resources/");
        Response respuesta = target.path("estado").request("application/json").get();
        Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        String totalTexto = respuesta.getHeaderString("Total-registros");
        Assertions.assertNotEquals(Integer.valueOf(0), Integer.valueOf(totalTexto));
        String cuerpoString = respuesta.readEntity(String.class);
        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        JsonArray listaJson = lector.readArray();
        int totalRegistros = listaJson.size();
        Assertions.assertTrue(totalRegistros>0);
        for(int i=0; i< listaJson.size(); i++){
            JsonObject objeto = listaJson.getJsonObject(i);
            System.out.println("ID: "+objeto.getInt("idEstado"));
        }
    }
}
