import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Singleton {

    private static  Singleton firstInstance = null;

    String[] scrabbleLetters = {"a", "a", "a", "a", "a", "a", "a", "a", "a",
            "b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e",
            "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h",
            "h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l",
            "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o",
            "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r",
            "r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u",
            "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z",};

    //a linked list which adds the contents of the String array scrabbleLetters
    private LinkedList<String> letterList = new LinkedList<String>(Arrays.asList(scrabbleLetters));

    static boolean firstThread = true;

    private Singleton(){}

    public static Singleton getinstance(){
        if(firstInstance == null){

            if (firstThread){
                firstThread = false;

                Thread.currentThread();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (Singleton.class){
                if(firstInstance == null) {
                    // If the instance isn't needed it isn't created
                    // This is known as lazy instantiation

                    firstInstance = new Singleton();

                    Collections.shuffle(firstInstance.letterList);
                }
            }

        }

        return firstInstance;
    }

    public LinkedList<String> getLetterList(){
        return firstInstance.letterList;
    }
    public LinkedList<String> getTiles(int howManyTiles){
        LinkedList<String> tilesToSend = new LinkedList<String>();

        for(int i =0; i <= howManyTiles; i ++){
            tilesToSend.add(firstInstance.letterList.remove(0));
        }

        return tilesToSend;
    }
}
