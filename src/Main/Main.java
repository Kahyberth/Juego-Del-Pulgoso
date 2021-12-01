package Main;

import Controlador.Controlador;
import Modelo.Hueso;
import Vista.GUI;



public class Main {
    public static void main(String[] args) {
        
       Hueso hueso = new Hueso();
       GUI gui = new GUI();
       Controlador controlador = new Controlador(hueso,gui);
       gui.setVisible(true);
       
       
    }
    
}
