/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.stringparser.stringparser;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;

/**
 *
 * @author igabbarini
 */
public class XMLToObjectParser {

   private static String message;
   private static int length;

   /**
    * El metodo devuelve un objeto creado a partir de los valores obtenidos en el String que se pasa como parametro.
    * @param fileName El nombre del archivo que contiene la estructura de los datos que vendran en el String. Es un xml 
    * que debe estar ubicado en el classpath del proyecto.
    * @param mensaje El mensaje que contiene los valores con los cuales rellenar el objeto
    * @param parserName El nombre del parser a utilizar.
    * @return
    */
   public static Object obtenerObjeto(String fileName, String mensaje, String parserName) {
      XMLToObjectParser.message = mensaje;
      Object o = null;
      InputStream file = ClassLoader.getSystemResourceAsStream(fileName);
      try {
         CmdLoadXML cmdLoadXML = new CmdLoadXML(file);
         Document serversDocument = (Document) cmdLoadXML.execute();
         Element parsers = serversDocument.getRootElement();
         Iterator iteratorParsers = parsers.getChildren().iterator();
         while (iteratorParsers.hasNext()) {
            Element parser = (Element) iteratorParsers.next();
            if (parser.getAttributeValue("parserName").equals(parserName)) {
               o = createObject(parser);
            }
         }
      } catch (Exception ex) {
         Logger.getLogger(XMLToObjectParser.class.getName()).log(Level.SEVERE, null, ex);
      }
      return o;
   }

   private static Object parse(Element elemento, Object fatherObject) {
      Iterator iteratorParser = elemento.getChildren().iterator();
      while (iteratorParser.hasNext()) {
         Element temp = (Element) iteratorParser.next();
         if (temp.getName().equals("complexField")) {
            Object complexField = createObject(temp);
            fatherObject = setField(fatherObject, complexField, temp.getAttribute("name").getValue());
         } else {
            length = Integer.parseInt(temp.getChildText("length"));
            setField(fatherObject, message.substring(0, length).trim(), temp.getAttribute("name").getValue());
            message = message.substring(length);
         }
      }
      return fatherObject;
   }

   private static Object createObject(Element element) {
      Class clase = null;
      Object o = null;
      Constructor co = null;
      try {
         clase = Class.forName(element.getAttributeValue("type"));
         co = clase.getConstructor();
         o = co.newInstance();
         parse(element, o);
      } catch (NoSuchMethodException ex) {
         try {
            length = Integer.parseInt(element.getChildText("length"));
            co = clase.getConstructor(String.class);
            o = co.newInstance(message.substring(0, length));
         } catch (Exception ex1) {
            Logger.getLogger(XMLToObjectParser.class.getName()).log(Level.SEVERE, null, ex1);
         } finally {
            message = message.substring(length);

         }
      } catch (Exception ex) {
         Logger.getLogger(XMLToObjectParser.class.getName()).log(Level.SEVERE, null, ex);
      }
      return o;
   }

   private static Object setField(Object object, Object field, String fieldName) {
      try {
         Field privateStringField = object.getClass().getDeclaredField(fieldName);
         privateStringField.setAccessible(true);
         privateStringField.set(object, field);
      } catch (NoSuchFieldException ex) {
         Logger.getLogger(XMLToObjectParser.class.getName()).log(Level.SEVERE, "the field [{0}] does not exist in the class [{1}]", new Object[]{fieldName, object.getClass().getName()});
      } catch (Exception ex) {
         Logger.getLogger(XMLToObjectParser.class.getName()).log(Level.SEVERE, null, ex);
      }
      return object;
   }
}
