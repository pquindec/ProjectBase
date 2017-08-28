package adm;
public class Evidencia {
    String Codigo;
  String Nombre;
  String Estado;
  String Resolucion;
  String Tipo_Evidencia;
  public Evidencia(String Codigo, String Nombre, String Estado, String Resolucion, String Tipo_Evidencia) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Estado = Estado;
        this.Resolucion = Resolucion;
        this.Tipo_Evidencia = Tipo_Evidencia;
    }
  public Evidencia() {
    }
  public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getResolucion() {
        return Resolucion;
    }

    public void setResolucion(String Resolucion) {
        this.Resolucion = Resolucion;
    }

    public String getTipo_Evidencia() {
        return Tipo_Evidencia;
    }

    public void setTipo_Evidencia(String Tipo_Evidencia) {
        this.Tipo_Evidencia = Tipo_Evidencia;
    }
}