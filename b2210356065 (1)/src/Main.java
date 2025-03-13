import com.sun.corba.se.spi.orb.ParserImplBase;

import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Open input and output files
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        PrintWriter writer = new PrintWriter(new FileWriter(args[1]));

        // Departure times
        Map<String, Integer> departures = new TreeMap<>();
        Map<String, Integer> departure1 = new TreeMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            String id = parts[0];
            String te = parts[1];
            String[] parcs = te.split(":");
            int hour = Integer.parseInt(parcs[0]);
            int minute = Integer.parseInt(parcs[1]);
            int totalMinutes = hour * 60 + minute;
            int delay = Integer.parseInt(parts[2]);
            int time = totalMinutes+delay;
            departure1.put(id,time-delay);
            departures.put(id, time);
        }


        writer.println("Departure order:");
        List<String> departureList = new ArrayList<>(departures.keySet());
        Collections.sort(departureList, Comparator.comparingInt(departures::get));
        List<String> departureList1 = new ArrayList<>(departure1.keySet());
        Collections.sort(departureList1, Comparator.comparingInt(departure1::get));
        for (String id : departureList1) {
            int time = departure1.get(id);
            String tripState = "IDLE";
            int hour = time / 60;
            int minute = time % 60;
            for (String otherId : departureList1) {
                if (otherId.equals(id)) {
                    continue;
                }
                else{

                    if (departure1.get(id).equals(departure1.get(otherId))) {
                        tripState = "DELAYED";
                    }
                }
            }
            writer.printf("%s depart at %02d:%02d   Trip State:%s\n", id, hour, minute, tripState);
        }
        writer.println("\nArrival order:");
        for (String id : departureList) {
            int time = departures.get(id);
            int hour = time / 60;
            int minute = time % 60;
            String tripState = "IDLE";
            for (String otherId : departureList) {
                if (otherId.equals(id)) {
                    continue;
                }
                else{

                    if (departures.get(id).equals(departures.get(otherId))) {
                        tripState = "DELAYED";
                    }
                }
            }
            writer.printf("%s arrive at %02d:%02d   Trip State:%s\n", id, hour, minute, tripState);
        }

        // Close input and output files
        reader.close();
        writer.close();
    }
}