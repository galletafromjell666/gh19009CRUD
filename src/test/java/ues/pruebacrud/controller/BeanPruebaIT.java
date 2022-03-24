/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author Sara
 */
@ExtendWith(ArquillianExtension.class)
public class BeanPruebaIT {
    
    @Deployment
    public static WebArchive crearDespliegue(){
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addClass(AbstractDataAcces.class).addClass(ControllerEstado.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml");
        System.out.println(salida.toString(true));
        return salida;
    }
    
    @Test
    public void testGetNombre() throws Exception{
        System.out.println("getnombre IT");
        
        //fail("La prueba fallara");
    
    }
    
}
