import java.util.LinkedList;

/**
 * Created by Sean on 11/06/2017.
 */
public class GetTheTiles implements Runnable {

    @Override
    public void run() {
        Singleton newInstance = Singleton.getinstance();

        System.out.println("Instance ID: = [" + System.identityHashCode(newInstance) + "]");
        System.out.println(newInstance.getLetterList());

        LinkedList<String> playerOneTiles = newInstance.getTiles(7);

        System.out.println("Player :" + playerOneTiles);

        System.out.println("Got the tiles");
    }
}
