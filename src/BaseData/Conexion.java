package BaseData;

import Modelo.Hueso;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    Connection conex;

    public void conectar() {
        try {
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Juego", "postgres", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public ArrayList<int[]> listar() {
        ArrayList<int[]> coordenadaBaseData = new ArrayList<>();
        int[] coordenadasHueso = new int[2];
        try {
            Statement st = conex.createStatement();
            String coordenada = "SELECT xcoordenada, ycoordenada\n"
                    + "	FROM public.\"Configuracion\";";
            ResultSet resultado = st.executeQuery(coordenada);

            while (resultado.next()) {
                for (int i = 0; i < 1; i++) {
                    coordenadasHueso[0] = Integer.parseInt(resultado.getString("xcoordenada"));
                    coordenadasHueso[1] = Integer.parseInt(resultado.getString("ycoordenada"));
                    coordenadaBaseData.add(coordenadasHueso);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return coordenadaBaseData;
    }

}
