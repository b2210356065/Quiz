import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Quiz1 {
    public static void main(String[] args) throws IOException{
        String inputFile = args[0];
        FileReader reader = new FileReader(inputFile);
        String line;
        List<String> yasaklistring = new ArrayList<>();
        List<String> kelimeler = new ArrayList<>();
        boolean control= true;
        while (reader.hasNextLine()) {
            line = reader.readLine().toLowerCase();
            if(line.equals("...")){
                control=false;
                continue;
            }
            if(control){
                yasaklistring.add(line);
            }
            else{
                String[] s=line.split("\\s+");
                for (String k:s){
                    if(yasaklistring.contains(k)){
                    }
                    else{
                        kelimeler.add(k+" "+line);
                    }
                }
            }
        }
        for (int i = 1; i < kelimeler.size(); i++) {
            String temp2 = kelimeler.get(i);
            // make temp first word of the string
            String temp = temp2.split("\\s+")[0].toLowerCase();
            int j = i - 1;
            while (j >= 0 && kelimeler.get(j).split("\\s+")[0].toLowerCase().compareTo(temp) > 0) {
                kelimeler.set(j + 1, kelimeler.get(j));
                j--;
            }
            kelimeler.set(j + 1, temp2);
        }
        String old = "";
        int oldcount = 0;
        for(String j:kelimeler){
            if (j.equals(old)){
                oldcount++;
            }
            else{
                oldcount=0;
            }
            String[] f=j.split("\\s+");
            int z = 0;
            for(int i =1;i<f.length;i++){
                if (f[i].equals(f[0])){
                    if (z == oldcount){
                        System.out.print(f[i].toUpperCase()+" ");
                    }else{
                        System.out.print(f[i]+" ");
                    }
                    z++;
                }
                else{
                    System.out.print(f[i]+" ");
                }
            }
            System.out.println();
        }

    }
}
class FileReader {
    private Scanner scanner;
    public FileReader(String filename) throws IOException {
        scanner = new Scanner(new File(filename));
    }
    public String readLine() {
        return scanner.nextLine();
    }
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}