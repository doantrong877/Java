public class CafeUtil{
    public int getStreakGoal(int numWeeks){
        int result = 0;
        for(int i = 1 ; i <= numWeeks; i++){
            result += i;
        }
        return result;
    }
}