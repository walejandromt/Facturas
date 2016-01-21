/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;


import facturas.Sistema;
import java.sql.ResultSet;

/**
 *
 * @author Williams
 */
public class factura extends javax.swing.JFrame {

    /**
     * Creates new form factura
     */
    
    private void buscarMontoActual(){
    
    
    String cliente_id = "null";
                if (cliente.getSelectedItem()!=null){ 
                cliente_id=cliente.getSelectedItem().toString();//si seleccionó, checar nombre*id
                //buscar el id, partir del * + 1
                cliente_id = cliente_id.substring(cliente_id.indexOf("*")+1);
            
                
                }
                
                try {            
            //limpiando el JComboBox, por si tiene algo
            cuenta.setText("");
            //consulta a la base de datos para la lista de estados
            //el nombre e id se concatenan para llenar el combo como uno solo
            ResultSet estados = 
               Sistema.getResultSet(" select cuentaActual("+cliente_id+") as cuenta from dual");
            
                  
                    
            //recorriendo la tabla
            while (estados.next())
                cuenta.setText(estados.getString("cuenta"));
                
                  
        } catch (Exception ex) {
        }
    
    }
    private void nuevoAbono(){
     int monto =0;
     int id = 0;
     
      try {            
            
            ResultSet estados = 
               Sistema.getResultSet(" select recibo_id as cuenta from abono");
            
                  
                    
            //recorriendo la tabla
            while (estados.next()){
                
               id = Integer.parseInt( estados.getString("cuenta"));
            
            }
                  
        } catch (Exception ex) {
        }
                
      
         id += 1;
        
        try {
                monto = Integer.parseInt(abono.getText());
            }catch(Exception ex){
                Sistema.mensaje("Monto no válido, vuelva a escribirlo");
            }
        
        String cliente_id = "null";
                if (cliente.getSelectedItem()!=null){ 
                cliente_id=cliente.getSelectedItem().toString();//si seleccionó, checar nombre*id
                //buscar el id, partir del * + 1
                cliente_id = cliente_id.substring(cliente_id.indexOf("*")+1);
            
                
                }
                
                String recibos_folio = "null";
                if (recibos.getSelectedItem()!=null){ 
                recibos_folio = recibos.getSelectedItem().toString();//si seleccionó, checar nombre*id
                //buscar el id, partir del * + 1
                recibos_folio = recibos_folio.substring(recibos_folio.indexOf("*")+1);
                recibos_folio = recibos_folio.substring(recibos_folio.indexOf("*")+1);
                    
                }
        
     String consulta = "insert into abono (recibo_id, fecha, monto, recibos_folio, cliente_id_cliente) values "
             + "("+id+", "               //Recibo_id
             + "'null', "        //fecha
             + monto +","              //monto
             + recibos_folio+", "                //recibos_folio
             + cliente_id +")";            //cliente_id_cliente
        
     
     if(monto != 0 && !"".equals(cuenta.getText())){
         
         if(Sistema.ejecuta(consulta)){
             Sistema.mensaje("Datos Guardados");
         }else{Sistema.mensaje("Error! 4616, verificar su abono.");}
     }
                
    
    }
    private void buscarRecibos(){
    
    
             String cliente_id = "null";
                if (cliente.getSelectedItem()!=null){ 
                cliente_id=cliente.getSelectedItem().toString();//si seleccionó, checar nombre*id
                //buscar el id, partir del * + 1
                cliente_id = cliente_id.substring(cliente_id.indexOf("*")+1);
            }
            
              try {            
            //limpiando el JComboBox, por si tiene algo
            recibos.removeAllItems();
            //consulta a la base de datos para la lista de estados
            //el nombre e id se concatenan para llenar el combo como uno solo
            ResultSet estados = 
               Sistema.getResultSet("select cliente.nombre||'*'||recibos.cuenta||'*'||recibos.folio as recibos from cliente "
                       + "inner join recibos on cliente.id_cliente = recibos.cliente_id_cliente "
                       + "where id_cliente = "+cliente_id);
            
                  
                    
            //recorriendo la tabla
            while (estados.next())
                recibos.addItem(estados.getString("recibos"));
                  System.out.println(" hola estoy aki " + estados.getString("recibos"));
        } catch (Exception ex) {
        }
              
    
    }
      private void actualizar(){
       
           cuenta.setText("");
           
            
             try {            
            //limpiando el JComboBox, por si tiene algo
            cliente.removeAllItems();
            //consulta a la base de datos para la lista de estados
            //el nombre e id se concatenan para llenar el combo como uno solo
            ResultSet clientes = 
               Sistema.getResultSet("select nombre||'*'||id_cliente as nombre  from cliente");
                    
            //recorriendo la tabla
            while (clientes.next()){
                cliente.addItem(clientes.getString("nombre"));
                
            }
                 System.out.println("fueraaa");
        } catch (Exception ex) {
        }
            
            
              
                
             
    
      
     
     }
     
    public factura() {
        initComponents();
        cliente.setSelectedIndex(-1);
        recibos.setSelectedIndex(-1);
        actualizar();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cuenta = new javax.swing.JTextField();
        recibos = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        cliente = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        abono = new javax.swing.JTextField();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente");

        jLabel2.setText("Recibos");

        jLabel3.setText("Abonar");

        cuenta.setFocusable(false);

        recibos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Abonar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clienteMousePressed(evt);
            }
        });
        cliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                clientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                clientePopupMenuWillBecomeVisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                clienteItemStateChanged(evt);
            }
        });
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Cuenta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(abono)
                            .addComponent(cuenta)
                            .addComponent(recibos, 0, 492, Short.MAX_VALUE)
                            .addComponent(cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(recibos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        
    }//GEN-LAST:event_clienteActionPerformed

    private void clienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_clienteItemStateChanged
        
    }//GEN-LAST:event_clienteItemStateChanged

    private void clienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteMousePressed
       
    }//GEN-LAST:event_clienteMousePressed

    private void clientePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_clientePopupMenuWillBecomeVisible
        
    }//GEN-LAST:event_clientePopupMenuWillBecomeVisible

    private void clientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_clientePopupMenuWillBecomeInvisible
        buscarRecibos();
        buscarMontoActual();
    }//GEN-LAST:event_clientePopupMenuWillBecomeInvisible

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        nuevoAbono();
        
        buscarMontoActual();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField abono;
    private javax.swing.JComboBox cliente;
    private javax.swing.JTextField cuenta;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox recibos;
    // End of variables declaration//GEN-END:variables
}
