import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        treesetbyorder tbo=new treesetbyorder();
        treeset treeset=new treeset();
        hshset hshset=new hshset();
        arayorder arayorder=new arayorder();
        hshmap hshmap=new hshmap();
        Arraylst aray=new Arraylst();
        tbo.tresetorder(new File(args[0]));
        treeset.treset(new File(args[0]));
        hshmap.hshmap(new File(args[0]));
        hshset.hshset(new File(args[0]));
        arayorder.arayorder(new File(args[0]));
        aray.araylist(new File(args[0]));
    }
}