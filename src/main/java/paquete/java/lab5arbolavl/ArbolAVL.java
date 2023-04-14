/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.java.lab5arbolavl;

import javax.swing.JOptionPane;

/**
 *
 * @author Latitude E5470
 */
public class ArbolAVL {
    private NODOArbolAVL raiz; //nuestra raiz 
    public ArbolAVL(){ //constructor para iniciar nuestra raiz en nulo
        this.raiz=null;
    }
    public NODOArbolAVL obtenerRaiz(){
        return raiz;
    }
    //Buscar un nodo 
    public NODOArbolAVL buscar(int d, NODOArbolAVL r){
        if(raiz==null){
            return null;
        }else if(r.dato==d){//si es igual a d es que ya lo encontro 
            return r;
        }else if (r.dato<d){
            return buscar(d,r.hijoDerecho);
        }else{
            return buscar(d,r.hijoIzquiedo);
        }                  
    }
    // Metodo para obtener el factor de equilibrio 
    public int obtenerFE(NODOArbolAVL x){
        if(x==null){
            return -1;
        }else{
            return x.fe;
        }
    }
    //Rotaicion simple a la Izquierda 
    public NODOArbolAVL rotacionIzquierda(NODOArbolAVL c){
        NODOArbolAVL auxiliar=c.hijoIzquiedo;
        c.hijoIzquiedo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquiedo), obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquiedo), obtenerFE(auxiliar.hijoDerecho))+1; //para obtener el maxdimo 
        return auxiliar;
    }
    //Rotacion simple a la derecha 
     public NODOArbolAVL rotacionDerecha(NODOArbolAVL c){
        NODOArbolAVL auxiliar=c.hijoDerecho;
        c.hijoDerecho=auxiliar.hijoIzquiedo;
        auxiliar.hijoIzquiedo=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquiedo), obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquiedo), obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
     //Rotacion Doble a la derecha 
     public NODOArbolAVL rotacionDobleIzquierda(NODOArbolAVL c){
         NODOArbolAVL temporal;
         c.hijoIzquiedo=rotacionDerecha(c.hijoIzquiedo); 
         temporal=rotacionIzquierda(c);
         return temporal;
     }
     //ROtacion doble a la izquierda 
     public NODOArbolAVL rotacionDobleDerecha(NODOArbolAVL c){
         NODOArbolAVL temporal;
         c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
         temporal=rotacionDerecha(c);
         return temporal;
     }
     //Metodo para insertar AVL
     public NODOArbolAVL insertarAVL(NODOArbolAVL nuevo, NODOArbolAVL subAr){
         NODOArbolAVL nuevoPadre=subAr;
         if(nuevo.dato<subAr.dato){
             if(subAr.hijoIzquiedo==null){
                 subAr.hijoIzquiedo=nuevo;
             }else{
                 subAr.hijoIzquiedo=insertarAVL(nuevo, subAr.hijoIzquiedo);
                 if((obtenerFE(subAr.hijoIzquiedo)- obtenerFE(subAr.hijoDerecho)==2)){
                     if(nuevo.dato<subAr.hijoIzquiedo.dato){
                         nuevoPadre=rotacionIzquierda(subAr);
                     }else{
                        // nuevoPadre=rotacionIzquierda(subAr);
                        nuevoPadre=rotacionDobleIzquierda(subAr);
                     }
                 }
             }
         }else if(nuevo.dato>subAr.dato){
             if(subAr.hijoDerecho==null){
                 subAr.hijoDerecho=nuevo;
             }else{
                 subAr.hijoDerecho=insertarAVL(nuevo, subAr.hijoDerecho);
                 if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquiedo)==2)){
                     if(nuevo.dato>subAr.hijoDerecho.dato){
                         nuevoPadre=rotacionDobleDerecha(subAr);
                     }else{
                         nuevoPadre=rotacionDobleDerecha(subAr);
                     } 
                 }
             }
         }else{
             JOptionPane.showMessageDialog(null, "Nodo duplicado");
         }
         //Actualizando la altura 
        if((subAr.hijoIzquiedo==null) && (subAr.hijoDerecho!=null)){
            subAr.fe=subAr.hijoDerecho.fe+1;
        }else if((subAr.hijoDerecho==null) && (subAr.hijoIzquiedo!=null)){
            subAr.fe=subAr.hijoIzquiedo.fe+1;       
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.hijoIzquiedo), obtenerFE(subAr.hijoDerecho))+1;                  
        }
        return nuevoPadre;
     }
     //Metodo para insertar 
     public void insertar(int d){
         NODOArbolAVL nuevo=new NODOArbolAVL(d);
         if(raiz==null){
             raiz=nuevo;
         }else{
             raiz=insertarAVL(nuevo, raiz);
         }
     }
     //Recorridos 
     //Metodo para recorrer el arbol en Orden 
     public void inOrden(NODOArbolAVL r){
         if(r!=null){
             inOrden(r.hijoIzquiedo);
             System.out.print(r.dato + ", ");
             inOrden(r.hijoDerecho);           
         }
     }
     //MEtodo para recorrer el arbol en Preorden
     public void preOrden(NODOArbolAVL r){
         if(r!=null){
             System.out.print(r.dato + ", ");
             preOrden(r.hijoIzquiedo);
             preOrden(r.hijoDerecho); 
         }
     }
    //Metodo para recorrer el arbol en PostOrden  
         public void postOrden(NODOArbolAVL r){
         if(r!=null){
             postOrden(r.hijoIzquiedo);
             postOrden(r.hijoDerecho);  
             System.out.print(r.dato + ", ");
         }
     }
         public boolean NodVacio(){
             return raiz==null;
         }
}
         