package net.Mega2223.jogoemtexto.entidades.projeteis;

import net.Mega2223.jogoemtexto.interfaces.Projectile;
import net.Mega2223.jogoemtexto.interfaces.Renderizável;
import net.Mega2223.jogoemtexto.objetos.Coord2D;

public abstract class Tiro implements Projectile, Renderizável {
    double speed = 1;
    Coord2D coords;

    public double getSpeed(){
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void onFrame() {

    }

    @Override
    public void getDamage() {

    }

    @Override
    public String[] getRender() {
        return new String[0];
    }

    @Override
    public Coord2D coords() {
        return null;
    }
}
