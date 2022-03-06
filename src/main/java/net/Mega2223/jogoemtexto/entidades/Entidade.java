package net.Mega2223.jogoemtexto.entidades;

import net.Mega2223.jogoemtexto.Utils;
import net.Mega2223.jogoemtexto.interfaces.Atualizável;
import net.Mega2223.jogoemtexto.interfaces.Danificável;
import net.Mega2223.jogoemtexto.interfaces.Renderizável;
import net.Mega2223.jogoemtexto.objetos.Coord2D;

public abstract class Entidade implements Renderizável, Atualizável, Danificável {

    public void onSpawn(){}

    public void onDeath(){}

    Coord2D coords = new Coord2D();
    protected double health = 100;
    protected double speed = 1;

    @Override
    public Coord2D coords() {
        return coords;
    }

    @Override
    public void doDamage(int damage) {
        health -= damage;
        onHealthChange(damage);
    }

    @Override
    public void regenerate(int health) {
        this.health += health;
        onHealthChange(health);
    }

    @Override
    public double getHealth() {
        return health;
    }

    public double getSpeed(){
        return speed;
    }


    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
