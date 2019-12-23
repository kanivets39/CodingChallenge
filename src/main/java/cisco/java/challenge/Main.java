package cisco.java.challenge;

import cisco.java.challenge.counter.WordCounter;
import cisco.java.challenge.gnode.GNode;
import cisco.java.challenge.gnode.GraphNode;
import cisco.java.challenge.gnode.NodeService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        NodeService nodeService = new NodeService();
        //creating nodes
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        GraphNode nodeD = new GraphNode("D");
        GraphNode nodeE = new GraphNode("E");
        GraphNode nodeF = new GraphNode("F");
        GraphNode nodeG = new GraphNode("G");
        GraphNode nodeH = new GraphNode("H");
        GraphNode nodeI = new GraphNode("I");



        //set children nodes
        GNode[] childrenOfNodeA = new GNode[]{nodeB, nodeC, nodeD};
        nodeA.setChildren(childrenOfNodeA);

        GNode[] childrenOfNodeB = new GNode[]{nodeE, nodeF};
        nodeB.setChildren(childrenOfNodeB);

        GNode[] childrenOfNodeC = new GNode[]{nodeG, nodeH, nodeI};
        nodeC.setChildren(childrenOfNodeC);



//        1.  ArrayList containing every GNode in the graph. Each node should
//        appear in the ArrayList exactly once (i.e. no duplicates).

        ArrayList resultNodes = nodeService.walkGraph(nodeA);

        System.out.println("Task1 GNode");
        System.out.println("\n1) ArrayList containing every node in the graph are: " + resultNodes);



//        2. ArrayList of ArrayLists, representing all possible
//        paths through the graph starting at 'node'.  The ArrayList returned can be
//        thought of as a ArrayList of paths, where each path is represented as an
//        ArrayList of GNodes.


        ArrayList<ArrayList<GNode>> arrayListOfPaths = nodeService.paths(nodeA);

        System.out.println("\n2) The ArrayList of ArrayLists presenting all possible paths are: " + arrayListOfPaths);


//        Produce a count of all the different "words" in a text file

        System.out.println("\n\nTask2 Word Count\n");
        WordCounter wordCounter = new WordCounter();
        String file = "Files/myFile.txt";
        String fileData = readUsingFiles(file);
        System.out.println(convertWithStream(wordCounter.count(fileData)));
    }

    private static String readUsingFiles(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    private static String convertWithStream(Map<String, Integer> map) {
        return map.keySet().stream()
                .map(key -> map.get(key) + " " + key + "\n")
                .collect(Collectors.joining("", "", ""));
    }
}
