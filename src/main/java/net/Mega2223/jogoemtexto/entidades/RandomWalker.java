package net.Mega2223.jogoemtexto.entidades;

import net.Mega2223.jogoemtexto.Utils;
import net.Mega2223.jogoemtexto.graficos.RenderUtils;

import javax.swing.*;
import java.util.Random;

public class RandomWalker extends Entidade{
    String[] render = RenderUtils.getRenderFromFile(Utils.TEXTURES_DIR + "\\RandomWalker.StrText");
    Random random = new Random();
    @Override
    public String[] getRender() {
        return render;
    }


    @Override
    public void onFrame() {
        coords.setX(coords.getX()+random.nextInt(3)-1);
        coords.setY(coords.getY()+random.nextInt(3)-1);
    }
}
