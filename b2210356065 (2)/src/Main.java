import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // input.txt dosyasını BufferedReader ile okuyoruz
            BufferedReader br = new BufferedReader(new FileReader(args[0]));

            // output.txt dosyasına yazmak için FileWriter kullanıyoruz
            FileWriter fw = new FileWriter("output.txt",true);

            String line;
            while ((line = br.readLine()) != null) {
                // 26 harf ve boşluk dışındaki karakterleri tespit etmek için regex kullanıyoruz
                if (!line.matches("[a-zA-Z ]+")) {
                    fw.write("The input file should not contains unexpected characters\n");
                    fw.close();
                    br.close();
                    System.err.println("The input file should not contains unexpected characters");
                    return;
                }
            }

            // Tüm koşullar sağlandıysa, input.txt içeriğini output.txt'ye kopyalıyoruz
            br = new BufferedReader(new FileReader(args[0]));
            while ((line = br.readLine()) != null) {
                fw.write(line + "\n");
            }

            fw.close();
            br.close();
            System.out.println("The program is running correctly");
        } catch (FileNotFoundException e) {
            System.err.println("There should be an input file in the specified path");
        } catch (IOException e) {
            System.err.println("An error occurred while reading or writing the file");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("There should be only 1 parameter");
        }
    }
}