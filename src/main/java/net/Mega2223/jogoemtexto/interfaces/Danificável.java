package net.Mega2223.jogoemtexto.interfaces;

public interface Danificável {

    default void onHealthChange(int damage){}

    default void doDamage(){
        doDamage(1);
    }
    default void regenerate(){
        regenerate(1);
    }



    void doDamage(int damage);
    void regenerate(int health);

    double getHealth();
}
