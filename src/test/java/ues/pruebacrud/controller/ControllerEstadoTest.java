/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.controller;

import java.util.Date;
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
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Date fecha = new Date();
        
        Estado esperado = new Estado(1,"nuevo",fecha,"ninguna");
        ControllerEstado cut = new ControllerEstado();
        assertThrows(IllegalArgumentException.class, () ->{
            cut.crear(null);
        });
        assertThrows(IllegalStateException.class, () ->{
            cut.crear(esperado);
        });

        cut.em = mockEM;
        cut.crear(esperado);
        
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.crear(esperado);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();

    }

    /**
     * Test of modificar method, of class ControllerEstado.
     */
    
    @org.junit.jupiter.api.Test
    public void testModificar() throws Exception {
        System.out.println("modificar");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Date fecha = new Date();
        
        Estado esperado = new Estado(1,"nuevo",fecha,"ninguna");
        ControllerEstado cut = new ControllerEstado();
        assertThrows(IllegalArgumentException.class, () ->{
            cut.modificar(null);
        });
        assertThrows(IllegalStateException.class, () ->{
            cut.modificar(esperado);
        });

        cut.em = mockEM;
        cut.modificar(esperado);
        
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.modificar(esperado);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of eliminar method, of class ControllerEstado.
     */
    @org.junit.jupiter.api.Test
    public void testEliminar() throws Exception {
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Date fecha = new Date();
        
        Estado esperado = new Estado(1,"nuevo",fecha,"ninguna");
        ControllerEstado cut = new ControllerEstado();
        assertThrows(IllegalArgumentException.class, () ->{
            cut.eliminar(null);
        });
        assertThrows(IllegalStateException.class, () ->{
            cut.eliminar(esperado);
        });

        cut.em = mockEM;
        cut.eliminar(esperado);
        
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.eliminar(esperado);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of findById method, of class ControllerEstado.
     */
    @org.junit.jupiter.api.Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Integer id = 1;
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        
        ControllerEstado cut = new ControllerEstado();
        Estado esperado = new Estado();
        Mockito.when(mockEM.find(Estado.class, id)).thenReturn(esperado);
        assertThrows(IllegalArgumentException.class, ()->{
            cut.findById(null);
        });
        assertThrows(IllegalStateException.class, ()->{
            cut.findById(id);
        });
        cut.em = mockEM;
        Estado encontrado = cut.findById(id);
        assertNotNull(encontrado);
        assertEquals(esperado, encontrado);
        
        ControllerEstado espia = Mockito.spy(ControllerEstado.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.findById(id);
        } catch (Exception e) {
        }
        Mockito.verify(espia,Mockito.times(1)).getEntityManager();
        
        
    }

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
