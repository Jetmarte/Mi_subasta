/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import static agentes.Vendedor.interfazz;
import gui.VendedorVentana;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import java.util.ArrayList;
import subasta.DatosLibro;
import subasta.Libro;

/**
 *
 * @author jetmarte
 */
public class Propietario extends jade.core.Agent {
    
    private boolean control = false;
    private boolean control2 = true;
    
    private DFAgentDescription   prp;
    private Behaviour            actualizar;
    private ArrayList<Behaviour> subasta;
    
    
    /**
     * Inicializamos al agente propietario
     */
    protected void setup() {
        
        //Saludamos
        System.out.println("Hola! yo soy el Propietario : " + getAID().getName() + " -> listo");
        
        
        
        //Registramos al agente vendedor
        prp = new DFAgentDescription();
        prp.setName( this.getAID() );
        try {
            DFService.register( this, prp );
        } catch (FIPAException fe) {
            System.out.println("Excepcion: " + fe);
        }

        //Comenzamos comportamientos
        //********************************************
        actualizar = new Propietario.actualizarEstado();
        
        addBehaviour(actualizar);
        
        //********************************************

    }
    
    @Override
    public void takeDown() {

        //Desregistramos al agente
        try {
            DFService.deregister( this );
        } catch (FIPAException fe) {
            System.out.println("Excepcion: " + fe);
        }

        //Eliminamos los comportamientos
        
        removeBehaviour( actualizar );
        for( Behaviour comportamiento : subasta ) {
            removeBehaviour(comportamiento);
        }
        

        //Mensaje de despedida
        System.out.println("Adios propietario!" + getAID().getName() + " ha finalizado.");

    }
    
    //Actualiza el estado de los libros en la interfaz
    private class actualizarEstado extends CyclicBehaviour {
        public ArrayList<DatosLibro> dat_libro;
        private DatosLibro milibro;
        int cont = 0;
        actualizarEstado(){
            dat_libro = new ArrayList();
            
        }
        
        
        @Override
        public void action() {
            block(10000);
            if(control){
                System.out.println( "hola-----------------mundo");
                //interfaz.actualizarEstado(listaLibros);
                
                
            if(control2){
                //-------------agregar libros al arary--------------
        
                for(int i=0; i< 100 ; i++){
                    milibro = new DatosLibro("Libro_"+ i, Integer.toString(i+100) , Integer.toString(i+10) );
                    this.dat_libro.add(milibro);
                }

                //-----------------------------------
            }
            control2 = false;
            
            
            
            
            interfazz.titulo.setText(this.dat_libro.get(cont).getTitulo());
            interfazz.precio.setText(this.dat_libro.get(cont).getPrecio());
            interfazz.incremento.setText(this.dat_libro.get(cont).getIncremento());
            interfazz.insertarLibro();
            cont++;
                
            }
            control = true;
            
        }

    }

  
}
