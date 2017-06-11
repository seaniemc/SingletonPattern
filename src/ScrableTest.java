import java.util.LinkedList;

/**
 * Created by Sean on 11/06/2017.
 */
public class ScrableTest {

    public static void main(String[] args) {

        Singleton newInstance = Singleton.getinstance();
        System.out.println("Instance 1 ID: = [" + System.identityHashCode(newInstance) + "]");
        System.out.println(newInstance.getLetterList());

        LinkedList<String> playerOneTiles = newInstance.getTiles(7);
        System.out.println("Player 1:" + playerOneTiles);

        System.out.println(newInstance.getLetterList());

        Singleton secondInstance = Singleton.getinstance();
        System.out.println("Instance 2 ID: = [" + System.identityHashCode(secondInstance) + "]");
        System.out.println(secondInstance.getLetterList());

        LinkedList<String> playerTwoTiles = newInstance.getTiles(7);
        System.out.println("Player 2:" + playerTwoTiles);

        System.out.println(newInstance.getLetterList());
    }
}
