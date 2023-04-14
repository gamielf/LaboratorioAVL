/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package paquete.java.lab5arbolavl;

import javax.swing.JOptionPane;

/**
 *
 * @author Latitude E5470
 */
public class Lab5ArbolAVL {

  //  public static void main(String[] args) {
      //  ArbolAVL arbAVL=new ArbolAVL();
        //Insertando Nodos 
      //  arbAVL.insertar(10);
      //  arbAVL.insertar(5);
      //  arbAVL.insertar(13);
      //  arbAVL.insertar(1);
      //  arbAVL.insertar(6);
       // arbAVL.insertar(17);
       // arbAVL.preOrden(arbAVL.obtenrRaiz());

    ArbolAVL AVL= new ArbolAVL();

    public void capturar(){
        int dato;
        dato=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero: "));

        AVL.insertar(dato);
        JOptionPane.showMessageDialog(null,"Nodo "+dato+" agregado...");
    }

public void imprimir(){//IMPRIMIENDO BARRA DE OPCIONES PARA PODER ENTRAR AL MENU
    int d;
     d=Integer.parseInt(JOptionPane.showInputDialog("ARBOL AVL\n\nIngrese una opcion: \nInOrden(1)\nPreOrden(2)\nPostOrden(3)"));
                switch(d){
                    case 1:
                        if(!AVL.NodVacio()){
                            System.out.println("Arbol en InOrden");
                            AVL.inOrden(AVL.obtenerRaiz());
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio");
                        }
                        break;
                    case 2:
                        if(!AVL.NodVacio()){
                            System.out.println("Arbol en PreOrden");
                           AVL.preOrden(AVL.obtenerRaiz());
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio");
                        }
                        break;
                    case 3:
                        if(!AVL.NodVacio()){
                            System.out.println("Arbol en PostOrden");
                          AVL.postOrden(AVL.obtenerRaiz());
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio");
                        }
                        break;
                }
                JOptionPane.showMessageDialog(null, "Mostrado en consola...");
}
  
    public static void main(String[] args) {
        Lab5ArbolAVL clase = new Lab5ArbolAVL();
     int r=0;

        do{
        r=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion: \nINGRESAR (1)\nIMPRIMIR (2)\nSALIR (3)"));
        switch(r){
            case 1:
              clase.capturar();
                break;
            case 2:
         clase.imprimir();
      
         break;
            case 3:
                
                break;
            case 4:
                break;

            default:JOptionPane.showMessageDialog(null, "La opcion esta incorrecta");
        }
        }while(r!=3);
    }   
    }

