import net.Mega2223.jogoemtexto.GameBoard;
import net.Mega2223.jogoemtexto.entidades.Dummy;
import net.Mega2223.jogoemtexto.entidades.Entidade;
import net.Mega2223.jogoemtexto.entidades.RandomWalker;
import net.Mega2223.jogoemtexto.graficos.RenderBoard;
import net.Mega2223.jogoemtexto.objetos.Dim2D;

public class BoardTest {
    public static void main(String[] args) throws InterruptedException {
        Entidade dummy = new RandomWalker();

        GameBoard board = new GameBoard(new Dim2D(40,40));

        board.addEntity(dummy,0);

        int itner = 0;
        while (true){
            Thread.sleep(100);
            board.playTick();
            System.out.println(board.getRender());
            itner++;
        }
    }
}
