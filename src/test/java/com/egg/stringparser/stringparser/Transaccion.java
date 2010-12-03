/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.stringparser.stringparser;

import java.math.BigInteger;

/**
 *
 * @author igabbarini
 */
public class Transaccion {

   private String idTransaccion;
   protected double mtcn;
   private String fechaEmision;
   private String montoTransaccion;
   private String monedaTransaccion;
   private String estadoTransaccion;
   private String cholo;
   private BigInteger monto;
   private Emisor emisor;
   private Beneficiario beneficiario;

   public Emisor getEmisor() {
      return emisor;
   }

   public BigInteger getMonto() {
      return monto;
   }

   public void setMonto(BigInteger monto) {
      this.monto = monto;
      
   }
   
   

   public void setEmisor(Emisor emisor) {
      this.emisor = emisor;
   }

   public String getCholo() {
      return cholo;
   }

   public void setCholo(String cholo) {
      this.cholo = cholo;
   }

   public String getEstadoTransaccion() {
      return estadoTransaccion;
   }

   public void setEstadoTransaccion(String estadoTransaccion) {
      this.estadoTransaccion = estadoTransaccion;
   }

   public String getFechaEmision() {
      return fechaEmision;
   }

   public void setFechaEmision(String fechaEmision) {
      this.fechaEmision = fechaEmision;
   }

   public String getIdTransaccion() {
      return idTransaccion;
   }

   public void setIdTransaccion(String idTransaccion) {
      this.idTransaccion = idTransaccion;
   }

   public String getMonedaTransaccion() {
      return monedaTransaccion;
   }

   public void setMonedaTransaccion(String monedaTransaccion) {
      this.monedaTransaccion = monedaTransaccion;
   }

   public String getMontoTransaccion() {
      return montoTransaccion;
   }

   public void setMontoTransaccion(String montoTransaccion) {
      this.montoTransaccion = montoTransaccion;
   }

//   public String getMtcn() {
//      return mtcn;
//   }
//
//   public void setMtcn(String mtcn) {
//      this.mtcn = mtcn;
//   }

   
   @Override
   public String toString() {
      return "Transaccion{" + "idTransaccion=" + idTransaccion + ", mtcn=" + new Double(mtcn).toString() + ", nombreBeneficiario=" +  beneficiario.getNombre()+ ", apellidoBeneficiario=" + beneficiario.getApellido() + ", nombreEmisor=" + emisor.getNombre() + ", apellidoEmisor=" + emisor.getApellido() + ", fechaEmision=" + fechaEmision + ", montoTransaccion=" + montoTransaccion + ", monedaTransaccion=" + monedaTransaccion + ", estadoTransaccion=" + estadoTransaccion + ", monto=" + monto + '}';
   }
}
