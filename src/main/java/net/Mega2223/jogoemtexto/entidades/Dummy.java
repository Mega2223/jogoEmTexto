package net.Mega2223.jogoemtexto.entidades;

import net.Mega2223.jogoemtexto.Utils;
import net.Mega2223.jogoemtexto.graficos.RenderUtils;

public class Dummy extends Entidade{
    @Override
    public void onFrame() {

    }
    String[] texture = RenderUtils.getRenderFromFile(Utils.TEXTURES_DIR + "\\DummyTexture.StrText");
    public Dummy(){
        super();
        health = 1;
    }

    @Override
    public String[] getRender() {
        return texture;
    }
}
