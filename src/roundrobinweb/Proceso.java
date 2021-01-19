/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobinweb;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Proceso {
    private int PID;
    private String nombre;
    private int prioridad;
    private String caracteres;
    private int Th;
    private int Quantum;
    private int ejecucion;
    
    private String estado;
    private int Rafaga;
    private int ResiduoRafaga;
    private int Turnaround;
   private int  tiempodellegada;
        private int tiempodefinalizacion;
    public Proceso(){
        PID=0;
        Quantum=0;
        ejecucion=0;
        nombre="";
        caracteres="";
        prioridad=0;
         nombre="";
        caracteres="";
        Rafaga=0;
        prioridad=0;
        tiempodellegada=0;
        tiempodefinalizacion=0;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRafaga() {
        return Rafaga;
    }

    public void setRafaga(int Rafaga) {
        this.Rafaga = Rafaga;
    }

    public int getResiduoRafaga() {
        return ResiduoRafaga;
    }

    public void setResiduoRafaga(int ResiduoRafaga) {
        this.ResiduoRafaga = ResiduoRafaga;
    }

    public int getTurnaround() {
        return Turnaround;
    }

    public void setTurnaround(int Turnaround) {
        this.Turnaround = Turnaround;
    }

    public int getTiempodellegada() {
        return tiempodellegada;
    }

    public void setTiempodellegada(int tiempodellegada) {
        this.tiempodellegada = tiempodellegada;
    }

    public int getTiempodefinalizacion() {
        return tiempodefinalizacion;
    }

    public void setTiempodefinalizacion(int tiempodefinalizacion) {
        this.tiempodefinalizacion = tiempodefinalizacion;
    }

    public int getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(int ejecucion) {
        this.ejecucion = ejecucion;
    }

    public int getQuantum() {
        return Quantum;
    }

    public void setQuantum(int Quantum) {
        this.Quantum = Quantum;
    }

    public int getTh() {
        return Th;
    }

    public void setTh(int Th) {
        this.Th = Th;
    }
    

    public String getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(String caracteres) {
        this.caracteres = caracteres;
    }
    

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    public int Rafaga(char remplazo,int TH){
        int contador=0;
         String palabraremplazada="";
    String remplazante=String.valueOf(remplazo);
    String comparando=remplazante.toUpperCase();
       
        for (int i=0;i<getCaracteres().length();i++){
            if(getCaracteres().charAt(i)==remplazo){
                
                 contador=contador+1;
               
            }
            if(remplazante.equalsIgnoreCase(comparando)){
                      contador=contador+1;
                }
             
        }
        return TH*contador;
    }
    
    public String Remplazar(char buscando,String remplazado){
         String palabraremplazada="";
    String remplazante=String.valueOf(buscando);
    String comparando=remplazante;
       for(int i=0;i<getCaracteres().length();i++){
           int contador=0;
           if(getCaracteres().charAt(i)==buscando){
                
               if(remplazante.equalsIgnoreCase(comparando)){
                     palabraremplazada= getCaracteres().replaceAll(remplazante, remplazado);
               }
                
               
               
             
              
             
              
              
                    
           }
        
           
       }
        return palabraremplazada;
    }
    public boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    
    
    
}
