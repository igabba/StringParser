/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.stringparser.stringparser;

/**
 *
 * @author igabbarini
 */
public class Emisor {

   private String nombre;
   private String apellido;

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   @Override
   public String toString() {
      return "Emisor{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
   }
}
