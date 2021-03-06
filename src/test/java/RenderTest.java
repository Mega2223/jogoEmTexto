import net.Mega2223.jogoemtexto.entidades.Dummy;
import net.Mega2223.jogoemtexto.entidades.Entidade;
import net.Mega2223.jogoemtexto.entidades.RandomWalker;
import net.Mega2223.jogoemtexto.graficos.RenderBoard;
import net.Mega2223.jogoemtexto.interfaces.Atualizável;
import net.Mega2223.jogoemtexto.objetos.Dim2D;

public class RenderTest {
    public static void main(String[] args) throws InterruptedException {
        Entidade dummy = new Dummy();
        dummy.coords().setCoords(new double[]{1,1});

        RenderBoard board = new RenderBoard(1,new Dim2D(30,30));
        board.addToLayer(dummy,0);

        int itner = 0;
        while (true){
            double legl = (Math.sin((double)itner/10)+1)*10;
            dummy.coords().setX(legl);
            Thread.sleep(100);
            System.out.println(board.getRenderedBoard());
            itner++;
        }

    }
}
