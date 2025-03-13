import java.io.*;
import java.util.*;

public class Arraylst {
    public static void araylist(File a) throws IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(a));

        ArrayList<String> poemArrayList = new ArrayList<String>();

        String line;
        while ((line = inputFile.readLine()) != null) {
            poemArrayList.add(line);
        }
        inputFile.close();

        Collections.shuffle(poemArrayList); // Verileri rastgele sırala

        BufferedWriter bw = new BufferedWriter(new FileWriter("poemArrayList.txt"));

        for (String poemLine : poemArrayList) {
            bw.write(poemLine + "\n"); // Her satırı dosyaya yazdır
        }

        bw.close();
    }
}