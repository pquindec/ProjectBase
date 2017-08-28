package adm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class Conexion {

    static Connection con = null;
    public static String User;
    public static String Clave;
    public static boolean status = false;

    public static Connection getConexion() {
        status = false;
        String url = "jdbc:sqlserver://Holger:1433;databaseName=Umbrella";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        try {
            con = DriverManager.getConnection(url, Conexion.User, Conexion.Clave);
            status = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }

    public static void setcuenta(String user, String clave) {
        Conexion.User = user;
        Conexion.Clave = clave;
    }
    public static boolean getstatus() {
        return status;
    }

    public static ResultSet Consulta(String consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

}
