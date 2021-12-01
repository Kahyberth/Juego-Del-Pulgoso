package Modelo;

public class Hueso {

    public int xCoordenada;
    public int yCoordenada;

    public Hueso(int x, int y) {

        this.xCoordenada = x;
        this.yCoordenada = y;
    }

    public Hueso() {

    }

    public int getX() {
        return xCoordenada;
    }

    public void setX(int x) {
        this.xCoordenada = x;
    }

    public int getY() {
        return yCoordenada;
    }

    public void setY(int y) {
        this.yCoordenada = y;
    }

}
