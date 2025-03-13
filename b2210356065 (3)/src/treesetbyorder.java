import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TreeSet;

public class treesetbyorder {
    public static void tresetorder(File a) throws IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(a));
        File outputFile = new File("poemTreeSetOrderByID.txt");

        TreeSet<String> set = new TreeSet<>();
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                set.add(line);
            }
        }
        int x=0;
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (String line : set) {
                if(x<line.split("\t")[0].length()) {
                    x = line.split("\t")[0].length();
                }
            }
            int lineNumber = 0;
            for (int i=0;i<=x;i++){
                for (String line : set) {
                    if (line.split("\t")[0].length() ==i) {
                        writer.println(line);
                    }
                }
            }
        }
    }
}