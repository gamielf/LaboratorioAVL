/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.java.lab5arbolavl;

/**
 *
 * @author Latitude E5470
 */
public class NODOArbolAVL {
    int dato, fe; //fe factor de equilibrio 
    NODOArbolAVL hijoIzquiedo,hijoDerecho;
    
   public NODOArbolAVL(int d){
       this.dato=d;
       this.fe=0;
       this.hijoIzquiedo=null;
       this.hijoDerecho=null;  
       //datos 
   }
}
