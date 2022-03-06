package net.Mega2223.jogoemtexto;

public class Utils {
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
