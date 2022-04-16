/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

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
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import ues.pruebacrud.entities.Estado;

/**
 *
 * @author Sara
 */
@ExtendWith(ArquillianExtension.class)
@TestMethodOrder(OrderAnnotation.class)
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
    
    @Order(2)
    @Test
    public void testFindAll(){
        System.out.println("test findAll");
        Assertions.assertNotNull(cut);
        List<Estado> resultado = cut.findAll();
        assertNotNull(resultado);
        Assertions.assertTrue(!resultado.isEmpty());
        System.out.println("La lista posee " + resultado.size());
    }
    
    @Order(1)
    @Test
    public void testCrear(){
        System.out.println("test Crear");
        assertNotNull(cut);
        Estado nuevo = new Estado();
        nuevo.setFechaCreacion(new Date());
        nuevo.setNombre("Pendiente");
        nuevo.setObservaciones("Sin observacion");
        cut.crear(nuevo);
    }
    
    @Order(3)
    @Test
    public void testFindById(){
        System.out.println("test findById");
        assertNotNull(cut);
        Integer id=1;
        Estado resultado = cut.findById(id);
        assertNotNull(resultado);
        System.out.println("Se encontro "+resultado.toString());
    }
    
    @Order(4)
    @Test
    public void testFindRange(){
        System.out.println("test findRange");
        assertNotNull(cut);
        Integer first=0;
        Integer pageSize=1;
        List<Estado> resultado = cut.findRange(first,pageSize);
        assertNotNull(resultado);
        Assertions.assertTrue(!resultado.isEmpty());
        System.out.println("Tamaño de lista es "+resultado.size());
    }
    
    @Order(5)
    @Test
    public void testContar(){
        System.out.println("test contar");
        assertNotNull(cut);
        Long resultado = cut.contar();
        assertNotNull(resultado);
        System.out.println("Existen "+resultado.toString()+" elementos en la tabla");
    }
    
    @Order(6)
    @Test
    public void testModificar(){
        System.out.println("test modificar");
        assertNotNull(cut);
        Integer id=1;
        Estado modificacion = new Estado (id,"Pendiente", new Date(), "Ninguna");
        System.out.println("Anterior "+cut.findById(id).getIdEstado()+ cut.findById(id).getNombre()+ cut.findById(id).getFechaCreacion()+ cut.findById(id).getObservaciones());
        cut.modificar(modificacion);
        System.out.println("Actualizado "+cut.findById(id).getIdEstado()+ cut.findById(id).getNombre()+ cut.findById(id).getFechaCreacion()+ cut.findById(id).getObservaciones());
    }
    
    @Order(7)
    @Test
    public void testEliminar(){
        System.out.println("test eliminar");
        assertNotNull(cut);
        Integer id=1;
        Estado resultado = cut.findById(id);
        assertNotNull(resultado);
        System.out.println("Tamaño anterior de tabla "+cut.findAll().size());
        cut.eliminar(resultado);
        System.out.println("Registro eliminado, tamaño actual de tabla "+cut.findAll().size());
    }
}
