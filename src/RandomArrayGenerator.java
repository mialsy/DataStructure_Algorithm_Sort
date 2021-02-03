import java.util.Arrays;
import java.util.Random;

public class RandomArrayGenerator {
    public static int[] generate(int length, int range) {
        Random rand = new Random();

        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(range);
        }

        return arr;
    }
}
