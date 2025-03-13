import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Quiz4 {
    public static void main(String[] args) throws IOException {

        String databaseFile = args[0];
        String queryFile = args[1];

        Trie trie = new Trie();


        try (BufferedReader reader = new BufferedReader(new FileReader(databaseFile))) {
            String line = reader.readLine();
            long number_of_words = Long.parseLong(line);
            while ((line = reader.readLine()) != null) {
                String[] datas = line.split("\t");
                String lower = datas[1].toLowerCase();
                trie.insert(trie.root, lower, 0, Long.parseLong(datas[0]));
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(queryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] query = line.split("\t");
                String queryStr = query[0].toLowerCase();
                int limit = Integer.parseInt(query[1]);
                Map<Long,String> results = trie.search(queryStr, limit);
                System.out.print("Query received: \"" + queryStr + "\" with limit " + limit + ". ");
                System.out.println("Showing results:");
                if (results.isEmpty()) {
                    System.out.println("No results.");
                } else {
                    for (Map.Entry<Long, String> entry : results.entrySet()) {
                        System.out.println("- " + entry.getValue());
                    }
                }
            }
        }
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    long value;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    public TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(TrieNode trieNode, String word, int index, long value) {
        if (index == word.length()) {
            trieNode.value = value;
            trieNode.isEndOfWord = true;
            return;
        }
        char currentChar = word.charAt(index);
        if (!trieNode.children.containsKey(currentChar)) {
            trieNode.children.put(currentChar, new TrieNode());
        }
        insert(trieNode.children.get(currentChar), word, index + 1, value);
    }

    public Map<Long, String> search(String query, int limit) {
        Map<Long, String> results = new TreeMap<>(Collections.reverseOrder());
        TrieNode node = root;
        for (char c : query.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                return results;
            }
        }
        collect(node, new StringBuilder(query), results, limit);
        return results;
    }

    private void collect(TrieNode node, StringBuilder prefix, Map<Long, String> results, int limit) {
        if (results.size() >= limit || node == null) {
            return;
        }
        if (node.isEndOfWord) {
            results.put(node.value, node.value + " " + prefix.toString());
        }
        for (char c : node.children.keySet()) {
            collect(node.children.get(c), prefix.append(c), results, limit);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
