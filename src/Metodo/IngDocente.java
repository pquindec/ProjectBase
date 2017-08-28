/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodo;
import adm.Conexion;
import adm.Docente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class IngDocente {
Conexion conexion = new Conexion();
    Connection cn = conexion.getConexion();
    PreparedStatement cst;
    public boolean Guardar(Object objNew) {
        Docente objN = (Docente) objNew;
        boolean estado = false;

        try {

            cst = cn.prepareCall("{call Todos(?,?,?,?,?,?,?,'Insertar')}");

            cst.setString(1, objN.getTxtCedula());
            cst.setString(2, objN.getTxtNombre());
            cst.setString(3, objN.getTxtApellido());
            cst.setString(4, objN.getTxtUsuario());
            cst.setString(5, objN.getTxtContraseña());
            cst.setString(6, objN.getTxtCorreo());
            cst.setString(7, objN.getTxtTipo_Usuario());
            cst.execute();
            

            estado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
    public ArrayList<Docente> Listar_Docente(){
        ArrayList<Docente> list = new ArrayList<Docente>();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConexion();
        String sql = "SELECT * FROM vistaUsuario;";
        
         try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Docente vo = new Docente();
                vo.setTxtCedula(rs.getString("txtCedula"));
                vo.setTxtNombre(rs.getString("txtNombre"));
                vo.setTxtApellido(rs.getString("txtApellido"));
                vo.setTxtUsuario(rs.getString("txtUsuario"));
                vo.setTxtContraseña(rs.getString("txtContraseña"));
                vo.setTxtCorreo(rs.getString("txtCorreo"));
                vo.setTxtTipo_Usuario(rs.getString("txtTipo_Usuario"));
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
          Docente objN = (Docente) obj;
           boolean estado = false;
        try {
                     
          CallableStatement pst=cn.prepareCall("{Call Todos(?,null,null,null,null,null,null,'Eliminar')}");
          pst.setString(1, objN.getTxtCedula());
          
              pst.executeUpdate();
              estado = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return estado;
    }
    public boolean Modificar(Object objNew) {
        Docente objN = (Docente) objNew;
        boolean estado = false;

        try {

            cst = cn.prepareCall("{call Todos(?,?,?,?,?,?,?,'Actualizar')}");

            cst.setString(1, objN.getTxtCedula());
            cst.setString(2, objN.getTxtNombre());
            cst.setString(3, objN.getTxtApellido());
            cst.setString(4, objN.getTxtUsuario());
            cst.setString(5, objN.getTxtContraseña());
            cst.setString(6, objN.getTxtCorreo());
            cst.setString(7, objN.getTxtTipo_Usuario());
            cst.execute();

            estado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
}