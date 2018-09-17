import java.util.*;

/**
 * ChuckleHistory will keep track of the users rolled numbers
 */
public class ChuckleHistory {

    public static List <Integer> NumberHistory = new ArrayList<> ();
    public static int LEAST_SUM = 2;
    public static int MAX_SUM = 12;

    public void SaveNumber(int rolledNum) {
        NumberHistory.add(rolledNum);
    }

    public boolean CheckIfExists(int rolledNum) {
        return NumberHistory.contains(rolledNum);
    }

    public boolean CompletedChucke() {

        for(int i = LEAST_SUM; i <= MAX_SUM; i++)
        {
            if(!NumberHistory.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public String GetCurrentList() {
        return NumberHistory.toString();
    }
}
