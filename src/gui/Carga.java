package gui;

import jade.core.Profile;
import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Carga {
    
    public static void main( String[] args ){
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        p.setParameter( Profile.MAIN_HOST, "localhost" );
        p.setParameter( Profile.GUI, "true");
        ContainerController cc = rt.createMainContainer(p);
        
        for(int i=1 ; i<4 ; i++){
            AgentController ac2;
            try{
                ac2 = cc.createNewAgent("Comprador_" + Integer.toString(i)+ "_", "agentes.Comprador", null );
                ac2.start();
            }catch( StaleProxyException e){
                //generar en un bloque
                e.printStackTrace();
            }
        }
        
        AgentController ac;
        try{
            ac = cc.createNewAgent("Vendedor_1", "agentes.Vendedor", null );
            ac.start();
        }catch( StaleProxyException e){
            //generar en un bloque
            e.printStackTrace();
        }
        
        AgentController ac2;
        try{
            ac = cc.createNewAgent("Propietario", "agentes.Propietario", null );
            ac.start();
        }catch( StaleProxyException e){
            //generar en un bloque
            e.printStackTrace();
        }
        
        
        
    }
    
}
