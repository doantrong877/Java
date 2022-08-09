import java.util.Random;
import java.util.ArrayList;
public class PuzzleJava{



public ArrayList<Integer> getTenRolls(){
    Random rand = new Random();
    ArrayList<Integer> result = new ArrayList<Integer>() ;
    for(int i = 0; i <= 10; i++){
        result.add(rand.nextInt(20)+1) ;
    }
    return result;
}


}




