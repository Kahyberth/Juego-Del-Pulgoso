package Controlador;

import BaseData.Conexion;
import Excepciones.Excepcion;
import Modelo.Hueso;
import Vista.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controlador implements ActionListener {

    Hueso hueso;
    GUI gui;
    int clicks = 0;
    Conexion conectar;

    Hueso huesoCoordenada;

    Timer timer = null;

    public Controlador(Hueso hueso, GUI gui) {
        this.hueso = hueso;
        System.out.println("BUENA SUERTE TIENES 3 INTENTOS");
        this.gui = gui;
        this.gui.Salir.addActionListener(this);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.gui.button[i][j].addActionListener(this);
            }
        }
        conectar = new Conexion();
        conectar.conectar();
        ArrayList<int[]> coordenadaHueso = conectar.listar();

        for (int[] data : coordenadaHueso) {
            System.out.println(data[0] + ", " + data[1]);
            huesoCoordenada = new Hueso(data[0], data[1]);
        }

        timer = new Timer(60000, this);
        timer.start();

    }

    public Controlador() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == timer) {
            JOptionPane.showMessageDialog(null, "Tiempo Agotado Intentalo Nuevamente!");
            System.exit(0);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (e.getSource() == gui.button[i][j]) {
                    clicks++;
                    try {

                        if (clicks <= 3) {
                            if (huesoCoordenada.xCoordenada == i && huesoCoordenada.yCoordenada == j) {
                                JOptionPane.showMessageDialog(null, "Se Encontro El Hueso");
                                JOptionPane.showMessageDialog(null, "Felicitaciones Juego Terminado");
                                System.exit(0);
                            } else {
                                System.err.println("Hueso No Encontrado");

                            }
                        } else {
                            throw new Excepcion("Numero de Intentos Excedido");
                        }

                    } catch (Excepcion ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        JOptionPane.showMessageDialog(null, "GAME OVER");
                        System.exit(0);
                    }

                }
            }
        }

    }
}
