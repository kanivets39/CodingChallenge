package cisco.java.challenge.gnode;

import java.util.*;

public class GraphNode implements GNode {

    private String nodeName;

    private GNode[] children;

    private GNode[] emptyList = new GNode[0];






    public GraphNode(String nodeName) {
        this.nodeName = nodeName;
    }


    public void setChildren(GNode[] children) {
        int arrLength = children.length;
        int index = 0; //counter for array index
        this.children = new GNode[arrLength];

        for (GNode child : children) {
            this.children[index] = child;
            index = index + 1;
        }
    }

    @Override
    public String getName() {

        return this.nodeName;
    }

    @Override
    public GNode[] getChildren() {

        if (this.children == null) {
            return emptyList;

        } else {
            return this.children;
        }

    }




    @Override
    public String toString() {
        return this.getName();
    }

}
