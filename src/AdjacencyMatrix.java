import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        String fileName = "src/Log.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            List<String> nodeNames = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.contains(",")) {
                    break;
                }
                nodeNames.add(line.trim());
            }

            int nodeCount = nodeNames.size();
            boolean[][] matrix = new boolean[nodeCount][nodeCount];

            do {
                if (line.contains(",")) {
                    String[] nodes = line.split(",");
                    int node1 = nodeNames.indexOf(nodes[0].trim());
                    int node2 = nodeNames.indexOf(nodes[1].trim());
                    matrix[node1][node2] = true;
                    //matrix[node2][node1] = true;
                }
            } while ((line = reader.readLine()) != null);

            reader.close();

            System.out.print("    ");
            for (String nodeName : nodeNames) {
                System.out.printf("%-3s ", nodeName);
            }
            System.out.println();

            for (int i = 0; i < nodeCount; i++) {
                System.out.printf("%-3s ", nodeNames.get(i));
                for (int j = 0; j < nodeCount; j++) {
                    System.out.print(matrix[i][j] ? "1   " : "0   ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
