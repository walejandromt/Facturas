/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturas;

import vista.factura;

    
public class Factura {
    
    
    public static void main(String ...args){
        
        
        if(Sistema.conectarBaseDatos()){
            factura menu = new factura();
             menu.setVisible(true);     
            System.out.println("Conexion realizada");
        
        }
    
    
    }
    
}
