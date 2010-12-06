/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.stringparser.stringparser;

import com.egg.stringparser.stringparser.entities.ObjetoUno;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author igabbarini
 */
public class XMLToObjectParserTest {

   public XMLToObjectParserTest() {
   }

   @BeforeClass
   public static void setUpClass() throws Exception {
   }

   @AfterClass
   public static void tearDownClass() throws Exception {
   }

   @Before
   public void setUp() {
   }

   @After
   public void tearDown() {
   }

   /**
    * Test of obtenerObjeto method, of class ProcesadorRespuesta.
    */
   @Test
   public void testObtenerObjeto() {
      Transaccion t = (Transaccion) XMLToObjectParser.getObjectFromString("dmtParser.xml", "12345678912345671234567899Juan Manuel              Fernandez Iraola Mendez                                Maria Angelica           Fernandez Iraola Mendez                                06/10/20090000020050", "RespuestaConsultaEstado");
      System.out.println(t);
      assertEquals("20050", t.getMonto().toString());
   }
   
   /**
    * Test of obtenerObjeto method, of class ProcesadorRespuesta.
    */
   @Test
   public void testObtenerObjetoUno() {
      ObjetoUno t = (ObjetoUno) XMLToObjectParser.getObjectFromString("dmtParser.xml", "0001501.85Juan Manuel         Fernandez Lopez               11606Manuel Carlos Jose  Martinez                      ", "RespuestaObjetoUno");
      System.out.println(t);
      assertEquals(6, t.hijos);
   }
}
