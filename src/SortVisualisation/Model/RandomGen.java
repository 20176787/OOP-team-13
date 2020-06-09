package SortVisualisation.Model;

import java.util.ArrayList;
import java.util.Collections;
public class RandomGen {
    public static int[] generateRandomInts(int max) {
        int[] intSeries = new int[max];
        for(int i=0; i<max; i++) {
            intSeries[i] = (int) (Math.random() * max + 1); // +1 for minimum is 1
        }
        return intSeries;
    }

    public static ArrayList<Integer> generateRandomList(int max) {
        ArrayList<Integer> intSeries = new ArrayList<>();
        for(int i=1; i<max+1; i++) {
            intSeries.add(i);
        }
        Collections.shuffle(intSeries);
        return intSeries;
    }
}
