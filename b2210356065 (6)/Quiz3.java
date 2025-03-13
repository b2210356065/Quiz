import java.util.*;
import java.io.*;

public class Quiz3 {
    static class Triple{
        int u, v;
        double w;
        public Triple(int u, int v, double w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static int parent[];
    public static void unionfind(int n){
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        parent[py] = px;
    }

    public static void main(String[] args) throws IOException {



        // arraylist of Triple

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line=reader.readLine();
        Integer[] array=new Integer[3];
        array[0]=Integer.parseInt(line);


        line=reader.readLine();

        while (array[0]-- >0){
            ArrayList<Triple> distance = new ArrayList<>();
            int sayac=0;
            LinkedList<String> adjList = new LinkedList<>();
            array[1]=Integer.parseInt(line.split(" ")[0]);
            array[2]=Integer.parseInt(line.split(" ")[1]);
            while ((line = reader.readLine()) != null){
                sayac++;

                if(sayac-1==array[2]){
                    break;
                }
                adjList.add(line);
            }
            //print adj
            // for (int i=0;i<adjList.size();i++){
            //     System.out.println(adjList.get(i));
            // }
            for (int i=0;i<adjList.size();i++){
                for (int j=i+1;j<adjList.size();j++){
                    double dist = calculate(adjList.get(i),adjList.get(j));
                    Triple edge = new Triple(i, j, dist);
                    distance.add(edge);

                }
            }
            Collections.sort(distance, new Comparator<Triple>() {
                @Override
                public int compare(Triple o1, Triple o2) {
                    return Double.compare(o1.w, o2.w);
                }
            });
            unionfind(adjList.size());

            ArrayList<Double> result = new ArrayList<Double>();
            for (int i=0;i<distance.size();i++){
                if(find(distance.get(i).u)!=find(distance.get(i).v)){
                    union(distance.get(i).u,distance.get(i).v);
                    result.add(distance.get(i).w);
                }
            }
            // print result
            // for (int i=0;i<result.size();i++){
            //     System.out.println(result.get(i));
            // }
            System.out.println(String.format("%.2f",result.get(result.size()-array[1])));
        }
        reader.close();
    }
    public static double calculate(String o, String t){
        int oX=Integer.parseInt(o.split(" ")[0]);
        int oY=Integer.parseInt(o.split(" ")[1]);
        int tX=Integer.parseInt(t.split(" ")[0]);
        int tY=Integer.parseInt(t.split(" ")[1]);
        return ( Math.sqrt(Math.pow(oX - tX, 2) + Math.pow(oY - tY, 2)));
    }
}