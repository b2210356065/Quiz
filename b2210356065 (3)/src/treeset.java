import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

public class treeset {
    public static void treset(File a) throws IOException {
        TreeSet<String> poemSet = new TreeSet<>();
        BufferedReader input = new BufferedReader(new FileReader(a));
        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            poemSet.add(scanner.nextLine());
        }
        scanner.close();

        PrintWriter writer = new PrintWriter(new FileWriter("poemTreeSet.txt"));

        for (String line : poemSet) {
            writer.println(line);
        }

        writer.close();
    }
}