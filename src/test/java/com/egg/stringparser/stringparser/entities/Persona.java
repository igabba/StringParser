/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.stringparser.stringparser.entities;

import com.egg.stringparser.stringparser.Emisor;

/**
 *
 * @author igabbarini
 */
public class Persona {

   private Emisor emisor;

   public Emisor getEmisor() {
      return emisor;
   }

   public void setEmisor(Emisor emisor) {
      this.emisor = emisor;
   }

   @Override
   public String toString() {
      return "Persona{" + "emisor=" + emisor + '}';
   }
}
