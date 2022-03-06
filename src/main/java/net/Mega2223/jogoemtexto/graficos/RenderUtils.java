package net.Mega2223.jogoemtexto.graficos;

import net.Mega2223.jogoemtexto.interfaces.Renderizável;
import net.Mega2223.jogoemtexto.objetos.Dim2D;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RenderUtils {

    public static String[] getRenderFromFile(String path){
        return getRenderFromFile(new File(path));
    }

    public static String[] getRenderFromFile(File path){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            ArrayList<String> out = new ArrayList<>();
            String line = reader.readLine();
            while (line != null){
                out.add(line);
                line = reader.readLine();
            }
            String[] arr = new String[out.size()];
            return out.toArray(arr);

        } catch (IOException ex){ex.printStackTrace();return null;}
    }

    public static Dim2D getSize(Renderizável renderizável){
        int maxX = 0;
        String[] render = renderizável.getRender();

        for(String act : render){
            if(act.length() > maxX){maxX = act.length();}
        }

        return new Dim2D(maxX, render.length);
    }
}
