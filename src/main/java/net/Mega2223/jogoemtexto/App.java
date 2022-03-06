package net.Mega2223.jogoemtexto;

import net.Mega2223.jogoemtexto.entidades.Entidade;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {

    static int frame = 0;

    public static final int FRAMERATE = 60;

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor ex = new ScheduledThreadPoolExecutor(1);
        ex.scheduleAtFixedRate(new Thread(App::doFrame),0,1000/FRAMERATE, TimeUnit.MILLISECONDS);
    }

    public static void doFrame(){
        frame++;
    }

}
