package cisco.java.challenge.gnode;

import java.util.ArrayList;
import java.util.Stack;

public class NodeService {

    private Stack<GNode> stack = new Stack<>();

    private ArrayList<ArrayList<GNode>> finalNodeList = new ArrayList<>();

    private ArrayList<GNode> tempNodeList = new ArrayList<>();

    private ArrayList<GNode> listOfGNodes = new ArrayList<>();

    public ArrayList walkGraph(GNode node) {

        listOfGNodes.add(node);

        for (GNode child : node.getChildren()) {

            walkGraph(child);
        }

        return listOfGNodes;
    }


    public ArrayList paths(GNode node) {

        stack.push(node);
        tempNodeList.add(node);

        while (!stack.isEmpty()) {
            GNode currentNode = stack.peek();

            GNode[] children = currentNode.getChildren();

            if (children.length == 0) {
                finalNodeList.add(new ArrayList<GNode>(tempNodeList));
            }

            for (GNode child : children) {

                paths(child);

                stack.pop();
                tempNodeList.remove(tempNodeList.size() - 1);
            }

            break;
        }

        return finalNodeList;
    }

}
