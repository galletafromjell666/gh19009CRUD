/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ues.pruebacrud.entities.Estado;

/**
 *
 * @author Sara
 */
@ExtendWith(ArquillianExtension.class)
public class EstadoIT {
    
    @Deployment
    public static WebArchive crearDespliegue(){
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("ues.pruebacrud.entities")
                .addAsResource("persistence-arquillian.xml")
                .addClass(AbstractDataAcces.class)
                .addClass(ControllerEstado.class)
                .addAsResource("META-INF/persistence.xml","META-INF/persistence.xml")
                .addAsResource("META-INF/sql/datos.sql","META-INF/sql/datos.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml");
        System.out.println(salida.toString(true));
        return salida;
    }
    
    @Inject
    ControllerEstado cut;
    
    @Test
    public void testFindAll(){
        System.out.println("findAll");
        Assertions.assertNotNull(cut);
        List<Estado> resultado = cut.findAll();
        Assertions.assertNotNull(resultado);
        Assertions.assertTrue(!resultado.isEmpty());
        System.out.println("La lista posee" + resultado.size());
    }
    
}
