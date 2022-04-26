import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class AdjacencyMatrix {
    class Node{
        public int key;
        public Node(int key){
            this.key = key;
        }

        public int getKey(){
            return key;
        }

        public Edge getEdge(Node dest){
            int destKey = dest.getKey();
            return edges[key][destKey];
        }

        public Edge addEdge(Node dest){
            int destKey = dest.getKey();
            if(key != destKey){
                if(edges[key][destKey] == null){
                    edges[key][destKey] = new Edge(dest);
                }return edges[key][destKey];
            }return null;
        }

        public Iterator<Edge> edgeIterator(){
            List<Edge> adjacencyList = new LinkedList<>();
            int length = nodes.length;
            for(int i = 0; i < length; i++){
                if(edges[key][i] != null){
                    adjacencyList.add(edges[key][i]);
                }
            }return adjacencyList.iterator();
        }
    }

    class Edge{
        public Node dest;
        public Edge(Node dest){
            this.dest = dest;
        }

        public Node getDest(){
            if(dest != null){
                return dest;
            }else{
                return null;
            }
        }

        public int getDestKey(){
            return dest.getKey();   
        }
    }
    
    public Node[] nodes = new Node[1];
    public Edge[][] edges = new Edge[1][1];

    public AdjacencyMatrix(int i){
        nodes = new Node[i];
        edges = new Edge[i][i];
    }

    public Iterator<Node> nodeIterator(){
        int length = nodes.length;
        List<Node> list = new LinkedList<>();
        for(int i = 0; i < length; i++){
            if(nodes[i] != null){
                list.add(nodes[i]);
            }
        }return list.iterator();
    }

    public Node getNode(int key){
        int length = nodes.length;
        for(int i = 0; i < length; i++){
            if(nodes[i] != null){
                if(nodes[i].getKey() == key){
                    return nodes[i];
                }
            }
        } return null;
    }

    public Edge getEdge(int source, int dest){
        if(nodes[source] != null){
            if(nodes[dest] != null){
                if(edges[source][dest] != null){
                    return edges[source][dest];
                }
            }
        }return null;
    }

    public Node addNode(int key){
        if(nodes[key] == null){
            nodes[key] = new Node(key);
        }return nodes[key];
    }

    public Edge addEdge(int source, int dest){
        if(source != dest){
            if(source > dest){
                resize(source);
            }else{
                resize(dest);
            }addNode(source);
            addNode(dest);
            edges[source][dest] = new Edge(nodes[dest]);
            return edges[source][dest];
        }return null;
    }

    public void resize(int newSize){
        int oldSize = nodes.length;
        if(newSize >= oldSize){
            Node[] nodes2 = new Node[newSize++];
            for(int i = 0; i < oldSize; i++){
                nodes2[i] = nodes[i];
            }Edge[][] edges2 = new Edge[newSize++][newSize++];
            for(int i = 0; i < oldSize; i++){
                for(int j = 0; j < oldSize; j++){
                    edges2[i][j] = edges[i][j];
                }
            }nodes = nodes2;
            edges = edges2;
        }
    }

    public static PrintStream printed(String file) throws FileNotFoundException{
        return new PrintStream(new FileOutputStream(file));
    }
}