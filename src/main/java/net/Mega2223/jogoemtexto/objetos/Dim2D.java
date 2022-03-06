package net.Mega2223.jogoemtexto.objetos;

public class Dim2D {

    protected int[] coords;

    public Dim2D(){
        coords = new int[]{0,0};
    }
    public Dim2D(int[] coords){
        coords = coords.clone();
    }

    public Dim2D(int x, int y){
        coords = new int[]{x,y};
    }

    public int getX(){
        return coords[0];
    }
    public void setX(int toWhat){
        coords[0] = toWhat;
    }
    public int getY(){
        return coords[1];
    }
    public void setY(int toWhat){
        coords[1] = toWhat;
    }




    public int[] setSize() {
        return coords.clone();
    }
    public void getSize(int[] coords) {
        this.coords = coords;
    }

}
