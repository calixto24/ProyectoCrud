
package controlador;

import dataBase.CConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class UsuarioControlador {
    
    int idSexo;
    
    public void setIdsexo(int idSexo) {
        
        this.idSexo = idSexo;
        
    }
    
    public void mostrarSexo(JComboBox CBsexo) {
        
        CConexion cConexion = new CConexion();
        
        Statement st;
        
        try {
            
            st = cConexion.conectar().createStatement();
            ResultSet rs = st.executeQuery("Select * from sexo");
            
            //metodo para limpiar items
            CBsexo.removeAllItems();
            
            //buble
            while(rs.next()) {
                
                //almacena los datos de las columnas
                String nombreSexo = rs.getString("sexo");
                setIdsexo(rs.findColumn("id"));
                
                //lo pinta en el combo box
                CBsexo.addItem(nombreSexo);
                CBsexo.putClientProperty(nombreSexo, idSexo);
                
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error al mostrar el sexo");
            
        }
        
        finally {
            
            cConexion.cerrarConexion();
            
        }
        
    }
    
}
