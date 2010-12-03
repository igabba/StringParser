/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.stringparser.stringparser.entities;

/**
 *
 * @author igabbarini
 */
public class ObjetoUno {

   private double altura;
   private String nombre;
   private String apellido;
   private int peso;
   public int hijos;
   private Persona persona;

   public double getAltura() {
      return altura;
   }

   public void setAltura(double altura) {
      this.altura = altura;
   }

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   public Persona getPersona() {
      return persona;
   }

   public void setPersona(Persona persona) {
      this.persona = persona;
   }

   public int getHijos() {
      return hijos;
   }

   public void setHijos(int hijos) {
      this.hijos = hijos;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public int getPeso() {
      return peso;
   }

   public void setPeso(int peso) {
      this.peso = peso;
   }

   @Override
   public String toString() {
      return "ObjetoUno{" + "altura=" + altura + ", nombre=" + nombre + ", apellido=" + apellido + ", peso=" + peso + ", hijos=" + hijos + ", persona=" + persona + '}';
   }
}
