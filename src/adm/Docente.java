
package adm;
public class Docente {
    String txtCedula;
    String txtNombre;
    String txtApellido;
    String txtUsuario;
    String txtContraseña;
    String txtCorreo;
    String txtTipo_Usuario;
    String txtSustentacion;
    String Criterio;

    public Docente() {
    }

    public Docente(String txtCedula, String txtNombre, String txtApellido, String txtUsuario, String txtContraseña, String txtCorreo, String txtTipo_Usuario, String txtSustentacion, String Criterio) {
        this.txtCedula = txtCedula;
        this.txtNombre = txtNombre;
        this.txtApellido = txtApellido;
        this.txtUsuario = txtUsuario;
        this.txtContraseña = txtContraseña;
        this.txtCorreo = txtCorreo;
        this.txtTipo_Usuario = txtTipo_Usuario;
        this.txtSustentacion=txtSustentacion;
        this.Criterio=Criterio;
    }
    public String getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(String txtCedula) {
        this.txtCedula = txtCedula;
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(String txtApellido) {
        this.txtApellido = txtApellido;
    }

    public String getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(String txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public String getTxtContraseña() {
        return txtContraseña;
    }

    public void setTxtContraseña(String txtContraseña) {
        this.txtContraseña = txtContraseña;
    }

    public String getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(String txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public String getTxtTipo_Usuario() {
        return txtTipo_Usuario;
    }

    public void setTxtTipo_Usuario(String txtTipo_Usuario) {
        this.txtTipo_Usuario = txtTipo_Usuario;
    }

    
    public String getTxtSustentacion() {
        return txtSustentacion;
    }

    /**
     * @param txtSustentacion the txtSustentacion to set
     */
    public void setTxtSustentacion(String txtSustentacion) {
        this.txtSustentacion = txtSustentacion;
    }

    /**
     * @return the Criterio
     */
    public String getCriterio() {
        return Criterio;
    }

    /**
     * @param Criterio the Criterio to set
     */
    public void setCriterio(String Criterio) {
        this.Criterio = Criterio;
    }

    
}
