package net.Mega2223.jogoemtexto.objetos;

public abstract class Obj2D {
    protected double[] coords;

    public double getX(){
        return coords[0];
    }

    public void setX(double toWhat){
        coords[0] = toWhat;
    }
    public double getY(){
        return coords[1];
    }

    public void setY(double toWhat){
        coords[1] = toWhat;
    }

    public Obj2D(){
        coords = new double[]{0,0};
    }
    public Obj2D(double[] coords){
        coords = coords.clone();
    }



}
