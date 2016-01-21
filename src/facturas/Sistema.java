/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturas;

import java.sql.Connection; //conexion a SQL

import java.sql.DriverManager; //Manejador de SQL
import java.sql.ResultSet;  //Resultados de consultas
import java.sql.SQLException; //excepciones generados por SQL
import java.sql.Statement;   //sentencia SQL
import java.util.Calendar;
import javax.swing.JOptionPane;  // panel para mostrar mensajes  cuadro de dialogo

public class Sistema {
    
    private static Connection conexion; //variable para manejar la conexión a la BD
 private static Statement sentencia; //para mandar las sentencias SQL a la BD   
public  static String titulo;  //título de nuestra aplicación


     /* trata de conectarse a la base de datos
     *  si se conecta regresa true
     *  sino muestra el error y regresa false
     * @return 
     */


    public static boolean conectarBaseDatos()    {
        try {
            titulo="Base de Datos Control Escolar"; 
            
            // cargar el driver en este caso oracle
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            // hacer la conexion 
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "users", "root");
            sentencia = conexion.createStatement();
            return true;
        } catch (Exception ex) {
            mensaje(ex.getMessage());
            return false;
        }
    }
    
    
     /**para desconectar de la base de datos
     * 
     */
    public static void desconectarBaseDatos(){
        try {
            conexion.rollback();
        
        } catch (SQLException ex) {
            mensaje(ex.getMessage());
        }
    } 

 

/** 
     * regresa el ResulSet con los datos de la consulta
     * si hay un error muestra el mensaje de error de la bd y regresa null
     * @param sql
     * @return 
     */
    public static ResultSet getResultSet(String sql) {
        try {
            return sentencia.executeQuery(sql);
        } catch (SQLException ex) {
                mensaje(ex.getMessage());
            return null;
        }       
    }

    
    /**
     * ejecuta un comando de insert, update o delete en la base de datos
     *  si la base de datos acepta regresa true, sino muetsra el errro y regresa false
     * @param sql sentencia sql
     * @return 
     */
    public static boolean ejecuta(String sql)  {
        try {
            sentencia.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            mensaje(ex.getMessage());
            return false;
        }
    }

 /**
     * Muestra mensaje en una caja de dialogo
     * @param mensaje 
     */
    public static void mensaje(String mensaje){
       JOptionPane.showMessageDialog(null, mensaje, titulo,JOptionPane.NO_OPTION);
    } 

    
 /**
     * Muestra una pregunta y el usuario acepta o la rechaza
     * @param mensaje 
     */    
    public static boolean preguntar(String mensaje){
        return  JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION)==0;
    }
    
     /**
     * pide un texto en una caja de dialogo
     * @param mensaje 
     */
   
    
     public static String getTexto(){
        return getTexto("Introduzca el texto");
    }
    
    public static String getTexto(String leyenda){
        String x = JOptionPane.showInputDialog(null, leyenda, titulo, JOptionPane.QUESTION_MESSAGE);
        if (x==null)
            x="";
        return x;
    }
    
    
     public static String cadenaBaseDatos(String valor) {
        return "'"+valor.trim()+"'";
    }
     
     public static Calendar dateBaseDatos(String Date){
     
     //"2008-08-11 00:00:00.0";
     
     
         Date = Date.substring(0, 10);
        int año = Integer.parseInt(Date.substring(0, 4));
        
        int mes = Integer.parseInt(Date.substring(5, 7));
        
        int dia = Integer.parseInt(Date.substring(8, 10));
        
        
          Calendar date = Calendar.getInstance();
                //año/mes/dia
                date.set(año, mes-1, dia);
                        //inicia1.setCalendar(date);
                        
        return date;
     
     }
     
     public static String cadenaDate(java.util.Date fecha){
     
       
            java.util.Date utilDate =  fecha;//fecha actual
            long lnMilisegundos = utilDate.getTime();
            java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
            
            
            return "'"+sqlDate.toString().trim()+"'";
            
     
     }

     
      public static String cadenaDateHora(java.util.Date fechaHora){
     
       
            java.util.Date utilDate =  fechaHora;//fecha actual
            long lnMilisegundos = utilDate.getTime();
            
            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
            
             
            return "'"+sqlTimestamp.toString().trim()+"'";
     
     }
      
          public static String cadenaModelo(java.util.Date fechaHora){
     
       
            java.util.Date utilDate =  fechaHora;//fecha actual
            long lnMilisegundos = utilDate.getTime();
            
            java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
            
             
            return sqlDate.toString().trim();
     
     }



}
