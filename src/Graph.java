import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Graph {

    private HashMap<String, Node> nodes;

    public Graph() {

        nodes = new HashMap<>();
    }

    public void addNode(String name, String description) {
        nodes.put(name, new Node(name, description));
    }

    public void addDirectedEdge(String name1, String name2) {
        Node n1 = nodes.get(name1);
        Node n2 = nodes.get(name2);
        if (n1 != null || n2 != null) {
            n1.addNeighbor(n2);
        }

    }

    public void addUndirectedEdge(String name1, String name2) {
        addDirectedEdge(name1, name2);
        addDirectedEdge(name2, name1);
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }


    class Node {

        private String name;
        private HashMap<String, Node> neighbors;
        private ArrayList<Item> items;
        private String description;
        private ArrayList<Creature> creatures;

        private Node(String name, String description) {
            items = new ArrayList<>();
            neighbors = new HashMap<>();
            creatures = new ArrayList<>();
            this.name = name;
            this.description = description;
        }

        private void addNeighbor(Node a) {
            neighbors.put(a.getName(), a);
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }


        public HashMap<String, Node> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(HashMap<String, Node> neighbors) {
            this.neighbors = neighbors;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public ArrayList<Creature> getCreatures(){
            return creatures;
        }

        public void setItems(ArrayList<Item> items) {
            this.items = items;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getNeighborNames() {
            StringBuilder sb = new StringBuilder();
            for (Node n : neighbors.values()) {
                String s = (n.getName() + " ");
                sb.append(s);
            }
            return sb.toString().trim();
        }

        public Node getNeighbor(String name) {
            return neighbors.get(name);
        }

        public void addItem(String name, String description) {
            items.add(new Item(name, description));
        }

        public void addCreature(Creature c){
            creatures.add(c);
        }

        public void removeCreature(Creature c){
           for(int i = creatures.size() - 1; i >= 0; i--){
               if(c.equals(creatures.get(i))){
                   creatures.remove(creatures.get(i));
                   break;
               }
           }
        }



        public void addItem(Item i) {
            items.add(i);
        }

        public void removeItem(String name) {
            for (int i = items.size() -1; i >= 0; i--) {
                if (items.get(i).getName().equals(name)) {
                    items.remove(i);
                }
            }
        }

    }

}
