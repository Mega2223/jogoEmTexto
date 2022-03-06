package net.Mega2223.jogoemtexto.entidades;

import net.Mega2223.jogoemtexto.Utils;
import net.Mega2223.jogoemtexto.graficos.RenderUtils;
import net.Mega2223.jogoemtexto.objetos.Coord2D;

public class Player extends Entidade{

    String[] render;

    public Player(){
        Utils.debug(System.getProperty("user.dir"));
        render = RenderUtils.getRenderFromFile(Utils.TEXTURES_DIR+"\\PlayerTexture.StrText");

        for(String ac : render){
            Utils.debug(ac);
        }

    }

    @Override
    public String[] getRender() {
        return render;
    }


    @Override
    public void onFrame() {

    }

}
