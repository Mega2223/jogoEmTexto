package net.Mega2223.jogoemtexto.graficos;

import net.Mega2223.jogoemtexto.interfaces.Renderizável;
import net.Mega2223.jogoemtexto.objetos.Coord2D;
import net.Mega2223.jogoemtexto.objetos.Dim2D;

import java.util.ArrayList;
import java.util.List;

public class RenderBoard {

    protected List<Renderizável>[] layers;
    Dim2D size;

    public RenderBoard(List<Renderizável>[] renders, Dim2D size) {
        layers = renders.clone();
        this.size = size;
    }

    public RenderBoard(int layers, Dim2D size) {
        this.layers = new List[layers];
        for (int i = 0; i < this.getLayers().length; i++) {
            this.layers[i] = new ArrayList<>();
        }
        this.size = size;
    }

    public void addToLayer(Renderizável addWhat, int layer) {
        layers[layer].add(addWhat);
    }

    public void removeFromLayer(Object removeWhat, int layer) {
        layers[layer].remove(removeWhat);
    }
    public void remove(Object removeWhat) {
        for (int i = 0; i < layers.length; i++) {
            removeFromLayer(removeWhat, i);
        }
    }
    public String getRenderedBoard() {
        char[][] legal = new char[(int) size.getY()][(int) size.getX()];


        for (int y = 0; y < legal.length; y++) {
            for (int x = 0; x < legal[y].length; x++) {
                legal[y][x] = getOccupyingChar(x,y);
            }
        }


        String ret = "";

        for (int y = 0; y < legal.length; y++) {
            for (int x = 0; x < legal[y].length; x++) {
                ret = ret + legal[y][x];
            }
            ret = ret + "\n";

        }
        return ret;
    }

    public char getOccupyingChar(int x, int y) {
        //inversão de coordenada, já que naturalmente o foguete ficaria encima, e eu quero que
        //ele fice embaixo assumindo uma cordenada y de 0,
        //por isso a subtração no retorno tb
        y = size.getY() - y;
        try {
            for (List<Renderizável> layer : getLayers()) {
                for (Renderizável act : layer) {
                    Coord2D coords = act.coords();
                    Dim2D size = RenderUtils.getSize(act);
                    if (x >= coords.getX() && x < coords.getX() + size.getX() &&
                            y >= coords.getY() && y < coords.getY() + size.getY()
                    ) {
                        Coord2D objectCoords = act.coords();
                        int[] difference = {(int) (x - objectCoords.getX()), (int) (y - objectCoords.getY())};

                        return act.getRender()[size.getY()-difference[1]-1].charAt(difference[0]);
                    }
                }
            }

            return ' ';
        } catch (StringIndexOutOfBoundsException ex){return ' ';}
    }

    public List<Renderizável>[] getLayers() {
        return layers.clone();
    }
}
