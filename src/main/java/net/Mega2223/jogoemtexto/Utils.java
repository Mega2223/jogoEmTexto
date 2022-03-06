package net.Mega2223.jogoemtexto;

public class Utils {
    public static final String DIRECTORY = System.getProperty("user.dir");
    public static final String TEXTURES_DIR = DIRECTORY + "\\src\\main\\resources\\EntityTextures";
    public static int globalDebug = 0;
    public static void debug(int priority, String debug){
        if(priority >= globalDebug){
            System.out.println(debug);
        }
    }
    public static void debug(String debug){
        debug(0,debug);
    }
}
