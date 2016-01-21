/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Williams
 */
public class MiTableModel extends DefaultTableModel{
    
    boolean columnas[] = new boolean[30];  

 public void setColumnaEditable(int columna, boolean editable){
     columnas[columna] = editable;
 }
 public void setColumnasEditable(boolean editable){
     for (int i=0; i < columnas.length;i++)
         columnas[i]= editable;
 }
 
 @Override
 public boolean isCellEditable (int row, int column)
   {

       return columnas[column];
   } 

    
}
