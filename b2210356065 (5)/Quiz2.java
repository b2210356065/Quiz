import java.util.*;
import java.io.*;

public class Quiz2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String line = bufferedReader.readLine();
        String[] s = line.split(" ");
        int capacity = Integer.parseInt(s[0]);
        int numResources = Integer.parseInt(s[1]);

        line = bufferedReader.readLine();
        Integer[] weights = new Integer[numResources];
        s = line.split(" ");
        for (int i = 0; i < numResources; i++) {
            weights[i] = Integer.parseInt(s[i]);
        }
        bufferedReader.close();

        printKnapsackSolution(weights, capacity);
    }

    public static void printKnapsackSolution(Integer[] weights, int capacity) {
        System.out.println(capacity);
        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j <= weights.length; j++) {
                if (L(weights, i, j)) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    public static boolean L(Integer[] weights, int m, int i) {
        if (i == 0 && m == 0) {
            return true;
        }
        if (i == 0 && m > 0) {
            return false;
        }
        if (i > 0 && weights[i - 1] > m) {
            return L(weights, m, i - 1);
        }
        return L(weights, m, i - 1) || L(weights, m - weights[i - 1], i - 1);
    }
}
