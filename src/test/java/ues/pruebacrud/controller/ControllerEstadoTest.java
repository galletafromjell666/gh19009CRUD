/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import java.util.List;
import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import ues.pruebacrud.entities.Estado;

/**
 *
 * @author Sara
 */
public class ControllerEstadoTest {
    
    public ControllerEstadoTest() {
    }

    /**
     * Test of crear method, of class ControllerEstado.
     */
    @org.junit.jupiter.api.Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        Estado nuevo = new Estado();
        ControllerEstado cut = new ControllerEstado();
        assertThrows(IllegalArgumentException.class, () ->{
            cut.crear(null);
        });
        assertThrows(IllegalArgumentException.class, () ->{
            cut.crear(nuevo);
        });
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        cut.em = mockEM;
        cut.crear(nuevo);
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        //ControllerEstado instance = (ControllerEstado)container.getContext().lookup("java:global/classes/ControllerEstado");
        //instance.crear(nuevo);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class ControllerEstado.
     */
    
    /**@org.junit.jupiter.api.Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        Estado modificacion = null;
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of eliminar method, of class ControllerEstado.
     */
    /**@org.junit.jupiter.api.Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        Estado id = null;
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findById method, of class ControllerEstado.
     */
    /**@org.junit.jupiter.api.Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Object id = null;
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findAll method, of class ControllerEstado.
     */
    /**@org.junit.jupiter.api.Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ControllerEstado instance = (ControllerEstado)container.getContext().lookup("java:global/classes/ControllerEstado");
        List<Estado> expResult = null;
        List<Estado> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findRange method, of class ControllerEstado.
     */
    /**@org.junit.jupiter.api.Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int first = 0;
        int pageSize = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ControllerEstado instance = (ControllerEstado)container.getContext().lookup("java:global/classes/ControllerEstado");
        List<Estado> expResult = null;
        List<Estado> result = instance.findRange(first, pageSize);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of contar method, of class ControllerEstado.
     */
    /**@org.junit.jupiter.api.Test
    public void testContar() throws Exception {
        System.out.println("contar");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ControllerEstado instance = (ControllerEstado)container.getContext().lookup("java:global/classes/ControllerEstado");
        Long expResult = null;
        Long result = instance.contar();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getEntityManager method, of class ControllerEstado.
     */
    /**@org.junit.jupiter.api.Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ControllerEstado instance = (ControllerEstado)container.getContext().lookup("java:global/classes/ControllerEstado");
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
