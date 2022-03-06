package net.Mega2223.jogoemtexto.objetos;

public class Coord2D extends Obj2D {


    public double[] getCoords() {
        return coords.clone();
    }
    public void setCoords(double[] coords) {
        this.coords = coords;
    }

}
