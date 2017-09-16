
package adm;


public class Criterio {
    
   String id_criterio;
     String nombre_criterio;

    public Criterio() {
        this.id_criterio = "";
        this.nombre_criterio = "";
        
    }
    
    public Criterio(String id_criterio, String nombre_criterio) {
        this.id_criterio = id_criterio;
        this.nombre_criterio = nombre_criterio;
    }
    
    public Criterio(String nombre_criterio) {
        this.nombre_criterio = nombre_criterio;
    }    

    /**
     * @return the id_criterio
     */
   

    /**
     * @return the nombre_criterio
     */
    public String getNombre_criterio() {
        return nombre_criterio;
    }

    /**
     * @param nombre_criterio the nombre_criterio to set
     */
    public void setNombre_criterio(String nombre_criterio) {
        this.nombre_criterio = nombre_criterio;
    }

    /**
     * @return the id_criterio
     */
    public String getId_criterio() {
        return id_criterio;
    }

    /**
     * @param id_criterio the id_criterio to set
     */
    public void setId_criterio(String id_criterio) {
        this.id_criterio = id_criterio;
    }

}
