/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodo;

import adm.Conexion;
import adm.Docente;
import adm.Evidencia;
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
public class IngEvidencia {
 Conexion conexion = new Conexion();
    Connection cn = conexion.getConexion();
    PreparedStatement cst;

    public boolean Guardar(Object objNew) {
        Evidencia objN = (Evidencia) objNew;
        boolean estado = false;

        try {

            cst = cn.prepareCall("{call TodosE(?,?,?,?,?,'Insertar')}");

            cst.setString(1, objN.getCodigo());
            cst.setString(2, objN.getNombre());
            cst.setString(3, objN.getEstado());
            cst.setString(4, objN.getResolucion());
            cst.setString(5, objN.getTipo_Evidencia());
            cst.execute();
            estado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
    public boolean Modificar(Object objNew) {
        Evidencia objN = (Evidencia) objNew;
        boolean estado = false;

        try {

            cst = cn.prepareCall("{call TodosE(?,?,?,?,?,'Actualizar')}");
            cst.setString(1, objN.getCodigo());
            cst.setString(2, objN.getNombre());
            cst.setString(3, objN.getEstado());
            cst.setString(4, objN.getResolucion());
            cst.setString(5, objN.getTipo_Evidencia());
            cst.execute();
            estado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
    public boolean eliminar(Object obj ){
          Evidencia objN = (Evidencia) obj;
           boolean estado = false;
        try {
                     
          CallableStatement pst=cn.prepareCall("{Call TodosE(?,null,null,null,null,null,'Eliminar')}");
          pst.setString(1, objN.getCodigo());
          
              pst.executeUpdate();
              estado = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return estado;
    }
    public ArrayList<Evidencia> Listar_Evidencia(){
        ArrayList<Evidencia> list = new ArrayList<Evidencia>();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConexion();
        String sql = "SELECT * FROM vistaEvidencia;";
        
         try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Evidencia vo = new Evidencia();
                vo.setCodigo(rs.getString("txtCodigo"));
                vo.setNombre(rs.getString("txtNombre"));
                vo.setEstado(rs.getString("txtEstado"));
                vo.setResolucion(rs.getString("txtResolucion"));
                vo.setTipo_Evidencia(rs.getString("txtTipo_Evidencia"));
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
}