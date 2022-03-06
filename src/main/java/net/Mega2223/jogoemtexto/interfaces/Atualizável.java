package net.Mega2223.jogoemtexto.interfaces;

public interface Atualizável {

    void onFrame();
    default void onDeath(){};

    default boolean isDead(){return false;};
}
