package subasta;

import jade.core.AID;
import java.util.ArrayList;

public class Libro {
    //datos del libro
    private String titulo;
    private double incrementoPrecio;
    private double precioSalida;
    private double precioSubasta;
    
    //variable del id del mejor pujador
    private AID mejorPujador;
    private ArrayList<AID> pujadores;
    
    //datos de la puja
    private int pujas;
    private int estado;
    private int mejorPujadorOK;
    private int decrementar;
    
    /**
     * metodo constructor
     * @param titulo Es el titulo del libro.
     * @param precioSalida Es el precio base de salida con el que sale el libro.
     * @param incrementoPrecio Cuanto se incrementa el precio del libro
     */
    public Libro(String titulo, double precioSalida, double incrementoPrecio) {
        this.titulo = titulo;
        this.precioSalida = precioSalida;
        this.incrementoPrecio = incrementoPrecio;
        //precio de la subasta inicial es el precio de salida
        this.precioSubasta = precioSalida;
        //lista de todos los pujadores para este libro
        pujadores = new ArrayList<>();
        pujas = 0;
        estado = 0;
        mejorPujadorOK = 0;
        decrementar = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getIncrementoPrecio() {
        return incrementoPrecio;
    }

    public void setIncrementoPrecio(double incrementoPrecio) {
        this.incrementoPrecio = incrementoPrecio;
    }

    public double getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(double precioSalida) {
        this.precioSalida = precioSalida;
    }

    public double getPrecioSubasta() {
        return precioSubasta;
    }

    public void setPrecioSubasta(double precioSubasta) {
        this.precioSubasta = precioSubasta;
    }

    public AID getMejorPujador() {
        return mejorPujador;
    }

    public void setMejorPujador(AID mejorPujador) {
        this.mejorPujador = mejorPujador;
    }

    public ArrayList<AID> getPujadores() {
        return pujadores;
    }

    public void setPujadores(AID pujador) {
        this.pujadores.add(pujador);
    }

    public int getPujas() {
        return pujas;
    }

    public void setPujas(int pujas) {
        this.pujas = pujas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getMejorPujadorOK() {
        return mejorPujadorOK;
    }

    public void setMejorPujadorOK(int mejorPujadorOK) {
        this.mejorPujadorOK = mejorPujadorOK;
    }

    public int getDecrementar() {
        return decrementar;
    }

    public void setDecrementar(int decrementar) {
        this.decrementar = decrementar;
    }

    public void incrementarPrecio() {
        precioSubasta += incrementoPrecio;
    }

    public void decrementarPrecio(){
        precioSubasta -= incrementoPrecio;
    }
}
