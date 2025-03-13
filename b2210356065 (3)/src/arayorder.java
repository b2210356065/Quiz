import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class arayorder {
    public static void arayorder(File a) throws IOException {
        ArrayList<String> poem = new ArrayList<>();
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader(a));
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                poem.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(poem);
        try {
            int x=0;
            PrintWriter writer = new PrintWriter("poemArrayListOrderByID.txt");
            for (String line : poem) {
                if(x<line.split("\t")[0].length()) {
                    x = line.split("\t")[0].length();
                }
            }
            for (int i=0;i<=x;i++){
                for (String line : poem) {
                    if (line.split("\t")[0].length() ==i) {
                        writer.println(line);
                    }
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}