/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alumno_2DAW
 */
public class Videoclub {
    private int idVideclub;
    private String nombre;

    public Videoclub(int idVideclub, String nombre) {
        this.idVideclub = idVideclub;
        this.nombre = nombre;
    }

    public int getIdVideclub() {
        return idVideclub;
    }

    public void setIdVideclub(int idVideclub) {
        this.idVideclub = idVideclub;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
