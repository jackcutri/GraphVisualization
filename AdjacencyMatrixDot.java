import java.io.PrintStream;
import java.util.Iterator;

public class AdjacencyMatrixDot {
    AdjacencyMatrix adjacencyMatrix;

    public AdjacencyMatrixDot(AdjacencyMatrix adjacencyMatrix){
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public void toDot(PrintStream printed){
        printed.println("graph AdjacencyMatrix {");
        printed.println("graph[layout = neato];");
        printed.println("\tnode [fontname=\"" + "helvetica" + "\"];");
        printed.println("\tnode [shape = square];");
        printed.println("\tnode [style = filled];");
        printed.println("\tnode [color = white];");
        printed.println("\tedge [color = white];\n");
        printed.println("\t1 [label = \"" + "\" fillcolor = \"" + "#9370DB" + "\" pos = \"" + "0,0!" + "\"];");
    
        Iterator<AdjacencyMatrix.Node> xItr = adjacencyMatrix.nodeIterator();
        int counter = 2;
        double xCoord = 0.5;
        double yCoord = 0;

        while(xItr.hasNext()){
            AdjacencyMatrix.Node currentNode = xItr.next();
            printed.println("\t" + counter + " [label = \"" + currentNode.getKey() + "\" fillcolor = \"" + "#9370DB" + "\" pos = \"" + xCoord + "," + yCoord + "!" + "\"];");
            counter++;
            xCoord += .5;
        }

        Iterator<AdjacencyMatrix.Node> yItr = adjacencyMatrix.nodeIterator();
        xCoord = 0;
        yCoord = -0.5;

        while(yItr.hasNext()){
            AdjacencyMatrix.Node currentNode = yItr.next();
            printed.println("\t" + counter + " [label = \"" + currentNode.getKey() + "\" fillcolor = \"" + "#9370DB" + "\" pos=\"" + xCoord + "," + yCoord +"!" + "\"];");
            counter++;
            yCoord -= .5;
        }

        Iterator<AdjacencyMatrix.Node> nodeItr = adjacencyMatrix.nodeIterator();
        xCoord = 0.5;
        yCoord = -0.5;

        while(nodeItr.hasNext()){
            AdjacencyMatrix.Node currentNode = nodeItr.next();
            Iterator<AdjacencyMatrix.Edge> edgeItr = currentNode.edgeIterator();
            while(edgeItr.hasNext()){
                AdjacencyMatrix.Edge currentEdge = edgeItr.next();
                printed.println("\t" + counter + " [label = \"X" + "\" fillcolor = \"" + "#AFEEEE" + "\" pos = \"" + (xCoord * currentNode.getKey()) + "," + (yCoord * currentEdge.getDestKey()) + "!" + "\"];");
                counter++;
                printed.println("\t" + counter + " [label = \"X" + "\" fillcolor = \"" + "#AFEEEE" + "\" pos = \"" + (xCoord * currentEdge.getDestKey()) + "," + (yCoord * currentNode.getKey()) + "!" + "\"];");
                counter++;
            }counter++;
        }printed.println("}");
    }
}