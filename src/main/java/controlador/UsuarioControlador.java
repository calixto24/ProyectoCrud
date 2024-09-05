
package controlador;

import dataBase.CConexion;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UsuarioControlador {
    
    int idSexo;
    
    CConexion cConexion;
    
    //constructor vacio
    public UsuarioControlador() {
        
        cConexion = new CConexion();
        
    }
    
    
    public void setIdsexo(int idSexo) {
        
        this.idSexo = idSexo;
        
    }
    
    public void mostrarSexo(JComboBox CBsexo) {
        
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
    
    //metodo agregar usuario
    public void agregarUsuario(JTextField TFNombre, JTextField TFApellido, JComboBox CBsexo, JTextField TFEdad, File TFImage) {
        
        String consulta = "insert into usuarios (nombres, apelldidos, fksexo, foto) values (?,?,?,?)";
        
    }
    
}
