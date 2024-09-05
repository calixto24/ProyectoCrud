
package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class CConexion {
    
    Connection con;
    
    public Connection conectar() {

        try {
             
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:/bdusuarios", "root", "");
            JOptionPane.showMessageDialog(null, "CONECTADO");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "NO CONECTADO" + e);
            
        }

        return con;

    }
    
    public void cerrarConexion() {
        
        try {
            
            if (con != null && !con.isClosed()) {
                
                JOptionPane.showMessageDialog(null, "CONEXION CERRADA");
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "NO SE PUEDO CERRAR LA CONEXION");
            
        }
        
    }
}
