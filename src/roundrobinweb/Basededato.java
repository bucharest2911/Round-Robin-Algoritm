/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobinweb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author carlo
 */
public class Basededato {
     Connection con=null;
    PreparedStatement st=null;
    ResultSet rt=null;
    private Class dato;
    Conexion c=new Conexion();
  
    
    public Basededato(){
        try {
           
        c.setDriver("com.mysql.jdbc.Driver");
            Class.forName(c.getDriver());
            
            
           
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }  
    }
    
    public void insertarProceso(Proceso pro) throws FileNotFoundException{
        try {
            
              
            c.setUrl("jdbc:mysql://localhost:3306/resultado");
            c.setUsuario("root");
            c.setPassword("");
            con=DriverManager.getConnection(c.getUrl(), c.getUsuario(),c.getPassword());
              c.setDato(con);
            String sql="INSERT INTO procesos(id,nombre,prioridad,estado,Rafaga,Quantum,tiempodellegada,turnaround,tiempofinal,residuo,mensaje"+ " )"+
                    "values(?,?,?,?,?,?,?,?,?,?,?)" ;
             
             
         st=con.prepareStatement(sql);
         st.setInt(1, pro.getPID());
         st.setString(2, pro.getNombre());
         st.setInt(3, pro.getPrioridad());
         st.setString(4, pro.getEstado());
         st.setInt(5,pro.getRafaga());
         st.setInt(6, pro.getQuantum());
         st.setDouble(7, pro.getTiempodellegada());
         st.setDouble(8, pro.getTurnaround());
         st.setInt(9, pro.getTiempodefinalizacion());
         st.setInt(10, pro.getResiduoRafaga());
         st.setString(11, pro.getCaracteres());
         
                 
                 
           
            st.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                con.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
