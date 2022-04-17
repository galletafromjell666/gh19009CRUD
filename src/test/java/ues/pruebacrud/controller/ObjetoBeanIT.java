/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import ues.pruebacrud.entities.TipoObjeto;
import ues.pruebacrud.entities.Objeto;

/**
 *
 * @author Sara
 */
@ExtendWith(ArquillianExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ObjetoBeanIT {
    
    @Deployment
    public static WebArchive crearDespliegue(){
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("ues.pruebacrud.entities")
                .addAsResource("persistence-arquillian.xml")
                .addClass(AbstractDataAcces.class)
                .addClass(ObjetoBean.class)
                .addAsResource("META-INF/persistence.xml","META-INF/persistence.xml")
                .addAsResource("META-INF/sql/datos.sql","META-INF/sql/datos.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml");
        System.out.println(salida.toString(true));
        return salida;
    }
    
    @Inject
    ObjetoBean cut;
   
    @Order(1)
    @Test
    public void testfindByIdTipoObjeto(){
        System.out.println("test findByIdTipoObjeto");
        Assertions.assertNotNull(cut);
        List<Objeto> resultado = cut.findByIdTipoObjeto(1, 0, 1);
        assertNotNull(resultado);
        Assertions.assertTrue(!resultado.isEmpty());
        System.out.println("La lista posee " + resultado.size());
    }
    
    @Order(2)
    @Test
    public void testcountByIdTipoObjeto(){
        System.out.println("test countByIdTipoObjeto");
        Assertions.assertNotNull(cut);
        int resultado = cut.countByIdTipoObjeto(1);
        assertNotNull(resultado);
        System.out.println("Hay " + resultado+" registros");
    }
    
}
