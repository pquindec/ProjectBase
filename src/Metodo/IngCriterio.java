
package Metodo;

import adm.Conexion;
import adm.Criterio;
import adm.Docente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class IngCriterio {
    Conexion conexion = new Conexion();
    Connection cn = conexion.getConexion();
    PreparedStatement cst;
    public boolean Guardar(Object objNew) {
        Criterio objN = (Criterio) objNew;
        boolean estado = false;

        try {
            cst = cn.prepareCall("{call Criterio(?,?,'Insert')}");
            cst.setString(1, objN.getId_criterio());
            cst.setString(2, objN.getNombre_criterio());
            cst.execute();
            estado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
    public ArrayList<Criterio> Listar_Criterio(){
        ArrayList<Criterio> list = new ArrayList<Criterio>();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConexion();
        String sql = "SELECT * FROM vistaCriterio;";
        
         try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Criterio vo = new Criterio();
                vo.setId_criterio(rs.getString("id_criterio"));
                vo.setNombre_criterio(rs.getString("nombre_criterio"));
                list.add(vo);
            }
            }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                cn.close();
            }catch(Exception ex){}
        }
        return list;
}
    public boolean eliminar(Object obj ){
          Criterio objN = (Criterio) obj;
           boolean estado = false;
        try {
                     
          CallableStatement pst=cn.prepareCall("{Call Criterio(?,null,'Delete')}");
          pst.setString(1, objN.getId_criterio());
          
              pst.executeUpdate();
              estado = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return estado;
    }
    public boolean Modificar(Object objNew) {
        Criterio objN = (Criterio) objNew;
        boolean estado = false;

        try {

            cst = cn.prepareCall("{call Criterio(?,?,'Update')}");

            cst.setString(1, objN.getId_criterio());
            cst.setString(2, objN.getNombre_criterio());
            cst.execute();
            estado = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
}
