package net.Mega2223.jogoemtexto.objetos;

import net.Mega2223.jogoemtexto.Utils;
import net.Mega2223.jogoemtexto.graficos.RenderUtils;
import net.Mega2223.jogoemtexto.interfaces.Renderizável;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<Renderizável>[] layers;
    Dim2D size;

    public Board(List<Renderizável>[] renders, Dim2D size) {
        layers = renders.clone();
        this.size = size;
    }

    public Board(int layers, Dim2D size) {
        this.layers = new List[layers];
        for (int i = 0; i < this.layers.length; i++) {
            this.layers[i] = new ArrayList<>();
        }
        this.size = size;
    }

    public void addToLayer(Renderizável addWhat, int layer) {
        layers[layer].add(addWhat);
    }

    public void removeFromLayer(Renderizável removeWhat, int layer) {
        layers[layer].remove(removeWhat);
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
            for (List<Renderizável> layer : layers) {
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
}
