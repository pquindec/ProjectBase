
package adm;

import Metodo.IngCriterio;
import Metodo.IngDocente;
import Metodo.IngEvidencia;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class Tabla {
IngDocente dao = null;
IngEvidencia ev=null;
    IngCriterio cr=null;

    public void visualizar_Docente(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        dt.addColumn("Cedula");
        dt.addColumn("Nombre");
        dt.addColumn("Apellido");
        dt.addColumn("Usuario");
        dt.addColumn("Contraseña");
        dt.addColumn("Correo");
        dt.addColumn("Tipo Usuario");
        dt.addColumn("Sustentacion");
        dt.addColumn("Modificar");
        dt.addColumn("Eliminar");
        JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");

        dao = new IngDocente();
        Docente vo = new Docente();
        ArrayList<Docente> list = dao.Listar_Docente();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[10];
                vo = list.get(i);
                fila[0] = vo.txtCedula;
                fila[1] = vo.txtNombre;
                fila[2] = vo.txtApellido;
                fila[3] = vo.txtUsuario;
                fila[4] = vo.txtContraseña;
                fila[5] = vo.txtCorreo;
                fila[6] = vo.txtTipo_Usuario;
                fila[7] = vo.txtSustentacion;
                fila[8] = btn_modificar;
                fila[9] = btn_eliminar;
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(20);
        }
    }
    public void visualizar_Evidencia(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("Estado");
        dt.addColumn("Resolucion");
        dt.addColumn("Tipo Evidencia");
        dt.addColumn("Cedula");
        dt.addColumn("Id Codigo");
        dt.addColumn("Modificar");
        dt.addColumn("Eliminar");
        JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");

        ev = new IngEvidencia();
        Evidencia vo = new Evidencia();
        ArrayList<Evidencia> list = ev.Listar_Evidencia();
        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[9];
                vo = list.get(i);
                fila[0] = vo.Codigo;
                fila[1] = vo.Nombre;
                fila[2] = vo.Estado;
                fila[3] = vo.Resolucion;
                fila[4] = vo.Tipo_Evidencia;
                fila[5] = vo.Cedula;
                fila[6] = vo.Id_Codigo;
                fila[7] = btn_modificar;
                fila[8] = btn_eliminar;
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(20);
        }
    }
    public void visualizar_Criterio(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("Modificar");
        dt.addColumn("Eliminar");
        JButton btn_modificar = new JButton("Modificar");
        btn_modificar.setName("m");
        JButton btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setName("e");
        cr = new IngCriterio();
        Criterio vo = new Criterio();
        ArrayList<Criterio> list = cr.Listar_Criterio();
        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[5];
                vo = list.get(i);
                fila[0] = vo.id_criterio;
                fila[1] = vo.nombre_criterio;
                fila[2] = btn_modificar;
                fila[3] = btn_eliminar;
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(20);
        }
    }
}