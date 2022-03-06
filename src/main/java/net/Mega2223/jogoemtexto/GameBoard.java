package net.Mega2223.jogoemtexto;

import net.Mega2223.jogoemtexto.graficos.RenderBoard;
import net.Mega2223.jogoemtexto.interfaces.Atualizável;
import net.Mega2223.jogoemtexto.interfaces.Renderizável;
import net.Mega2223.jogoemtexto.objetos.Dim2D;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    int frame = 0;
    Dim2D size;
    protected RenderBoard renderBoard;
    protected List<Atualizável> atualizávels = new ArrayList<>();

    public GameBoard(Dim2D size){
        this.size = size;
        renderBoard = new RenderBoard(10,size);
    }
    public GameBoard(Dim2D size, int layers){
        this.size = size;
        this.renderBoard = new RenderBoard(layers,size);
    }

    public void addEntity(Atualizável entity){
        addEntity(entity,renderBoard.getLayers().length-1/2);
    }
    public void addEntity(Atualizável entity, int level){
        atualizávels.add(entity);
        if(entity instanceof Renderizável){renderBoard.addToLayer((Renderizável) entity,level);}
    }
    public void addRenderable(Renderizável renderizável,int layer){
        renderBoard.addToLayer(renderizável,layer);
    }

    public void playTick(){
        for(Atualizável act : atualizávels){
            act.onFrame();
            if(act.isDead()){act.onDeath();remove(act);}
        }
        frame++;
    }

    public void remove(Object act){
        atualizávels.remove(act);
        renderBoard.remove(act);
    }
    public void removeEntity(Atualizável ent){
        atualizávels.remove(ent);
    }
    public void removeRenderable(Renderizável rend){renderBoard.remove(rend);}

    public String getRender(){
        return renderBoard.getRenderedBoard();
    }

    public RenderBoard getRenderBoard() {
        return renderBoard;
    }

}
