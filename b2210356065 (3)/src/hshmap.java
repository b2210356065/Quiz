import java.io.*;
import java.util.*;

public class hshmap {
    public static void hshmap(File a) throws IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(a));

        HashMap<Integer, String> poemMap = new HashMap<Integer, String>();

        String line;
        while ((line = inputFile.readLine()) != null) {
            String[] parts = line.split("\t");
            int id = Integer.parseInt(parts[0]);
            String text = parts[1];
            poemMap.put(id, text);
        }
        inputFile.close();

        TreeMap<Integer, String> sortedPoemMap = new TreeMap<Integer, String>(poemMap);

        PrintWriter writer = new PrintWriter(new FileWriter("poemHashMap.txt"));
        for (Map.Entry<Integer, String> entry : sortedPoemMap.entrySet()) {
            writer.println(entry.getKey() + "\t" + entry.getValue());
        }
        writer.close();
    }
}