package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {

    Container contenedor;
    public JButton button[][] = new JButton[4][4];
    public JButton Salir;
    public JPanel dashBoard,cuadricula ;
    public GUI() {

        contenedor = getContentPane();
        setTitle("Juego del Pulgoso");
        setSize(600,600);
        setLocationRelativeTo(null);
        IniciarPaneles();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void IniciarPaneles() {
        DashBoard();
        Cuadricula();
        Button();
    }

    public void DashBoard() {
        dashBoard = new JPanel();
        dashBoard.setLayout(null);
        //dashBoard.setBounds(0, 0, 250, 100);
        Color color = new Color(32,25,50);
        dashBoard.setBackground(color);
        contenedor.add(dashBoard);

    }

    public void Cuadricula() {

        cuadricula = new JPanel();
        cuadricula.setBounds(90, 75, 400, 400);
        cuadricula.setBackground(Color.black);
        cuadricula.setLayout(new GridLayout(4, 4, 4, 4));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                button[i][j] = new JButton();
                cuadricula.add(button[i][j]);
            }
        }

        dashBoard.add(cuadricula);
    }
    
    public void Button(){
       Salir = new JButton("Probar");
       Salir.setBounds(100, 480, 150, 30);
       Salir.setSize(100, 50);
       // dashBoard.add(Salir);
       
    }
}
