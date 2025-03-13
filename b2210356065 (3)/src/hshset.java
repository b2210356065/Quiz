import java.io.*;
import java.util.*;

public class hshset{
    public static void hshset(File a) throws IOException {
        Set<String> lines = new HashSet<>();
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader(a));
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> shuffledLines = new ArrayList<>(lines);
        Collections.shuffle(shuffledLines);

        try {
            FileWriter writer = new FileWriter("poemHashSet.txt");
            for (String line : shuffledLines) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}