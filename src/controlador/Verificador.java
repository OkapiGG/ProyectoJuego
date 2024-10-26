/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
// del text

import javax.swing.JOptionPane;

/** 
 *
 * @author  
 */
//se abstraer los metodos y las clases * Abstrat
//

public class Verificador {
    
    public boolean verificaCajaTextoCadena(javax.swing.JTextField cajaTexto){
       if(cajaTexto.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Campo requerido" );
            return false;
        }
       return true;
   }
     public boolean verificaCajaTextoEntero(javax.swing.JTextField cajaTexto){
       if(cajaTexto.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Campo requerido" );
            return false;
        }
       else{
           try{
              int a = Integer.parseInt(cajaTexto.getText());
           }catch(Exception e){
               System.err.println("Aqui hay un error");
               JOptionPane.showMessageDialog(null,"El valor ingresado no es un numero" );
               return false;
           }
       }
       return true;
   }
    
    public boolean verificaCajaTextoVacio(javax.swing.JTextField cajaTexto){
       if(cajaTexto.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Campo requerido" );
            return false;
        }
       return true;
   }
   
   public boolean verificaCajaTextoVacio(String cadena){
       if(cadena.isBlank()){
            JOptionPane.showMessageDialog(null,"Campo" );
            return false;
        }
       return true;
   }
   
   
}
