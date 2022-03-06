import net.Mega2223.jogoemtexto.entidades.Player;
import net.Mega2223.jogoemtexto.objetos.Board;
import net.Mega2223.jogoemtexto.objetos.Dim2D;

public class RenderTest {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        player.coords().setCoords(new double[]{0,0});

        Board board = new Board(1,new Dim2D(30,30));
        board.addToLayer(player,0);

        int itner = 0;
        while (true){
            double legl = (Math.sin((double)itner/10)+1)*10;
            player.coords().setX(legl);
            Thread.sleep(100);
            System.out.println(board.getRenderedBoard());
            itner++;
        }

    }
}
