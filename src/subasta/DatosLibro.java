/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subasta;

/**
 *
 * @author jetmarte
 */
public class DatosLibro {
    private String titulo;
    private String precio;
    private String incremento;

    public DatosLibro(String titulo, String precio, String incremento) {
        this.titulo = titulo;
        this.precio = precio;
        this.incremento = incremento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getIncremento() {
        return incremento;
    }

    public void setIncremento(String incremento) {
        this.incremento = incremento;
    }
    
    
    
}
