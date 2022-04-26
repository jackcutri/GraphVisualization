public class Main {
    public static void run(String file) throws Exception{
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(10);
        AdjacencyMatrixDot dot = new AdjacencyMatrixDot(adjacencyMatrix);

        adjacencyMatrix.addNode(1);
        adjacencyMatrix.addNode(2);
        adjacencyMatrix.addNode(3);

        adjacencyMatrix.addEdge(1,2);
        adjacencyMatrix.addEdge(1,3);

        dot.toDot(AdjacencyMatrix.printed(file));
    }
    public static void main(String[] args) throws Exception{
        run("AdjacencyMatrix.dot");
    }
}