package net.Mega2223.jogoemtexto.interfaces;

public interface Danificável extends Atualizável{

    default void onHealthChange(int damage){}

    default void doDamage(){
        doDamage(1);
    }
    default void regenerate(){
        regenerate(1);
    }

    boolean isDead = false;

    void doDamage(int damage);
    void regenerate(int health);

    double getHealth();
}
