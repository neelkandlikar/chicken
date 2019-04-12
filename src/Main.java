import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) {


        Graph g = new Graph();
        g.addNode("hall", "a hall");
        g.addNode("dungeon", "a dungeon");
        g.addNode("closet", "a closet");


        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");

        //   Graph.Node currentNode = g.getNode("hall");

        Item a = new Item("item1", "Description1");
        Item b = new Item("item2", "Description2");
        Item c = new Item("item3", "Description3");
        Item d = new Item("item4", "Description4");
        Item e = new Item("item5", "Description5");

        g.getNode("dungeon").addItem(a);
        g.getNode("hall").addItem(b);
        g.getNode("dungeon").addItem(c);
        g.getNode("closet").addItem(d);
        g.getNode("hall").addItem(e);


        Player p = new Player("Neel", "god");
        p.setCurrentRoom(g.getNode("hall"));

        Wumpus w = new Wumpus(g.getRandomNode());
        Popstar p = new Popstar(g.getRandomNode());
        // creating a wumpus and popstar in a random room in the graph.


        System.out.println("You are currently in the " + p.getCurrentRoom().getName());


        startGame(p, g);



    }


    private static void startGame(Player p, Graph g) {

        String response;
        Scanner scanner = new Scanner(System.in);

        while (true) {
//            System.out.println("You can go to the " + currentNode.getNeighborNames());
//            System.out.println("What room would you like to go to?");
            response = scanner.nextLine();
            response = response.trim().toLowerCase();
            if (response.equals("quit")) {
                System.exit(0);
            } else if (response.equals("help")) {
                Commands.help();
            } else if (response.equals("look")) {
                Commands.look(p);
            } else {
                String[] brokenResponse = response.split(" ");
                if (brokenResponse.length > 1 && brokenResponse[0].equals("go")) {
                    Graph.Node newNode = p.getCurrentRoom().getNeighbor(brokenResponse[1]);
                    Commands.go(p, newNode);
                } else if (brokenResponse.length > 2 && brokenResponse[0].equals("add") && brokenResponse[1].equals("room")) {
                    String s = "";
                    for (int i = 2; i < brokenResponse.length; i++) {
                        s += brokenResponse[i];
                    }
                    Commands.addRoom(s,p, g);
                } else if (brokenResponse.length > 1 && brokenResponse[0].equals("take")) {
                    String itemName = brokenResponse[1];
                    Commands.take(itemName, p);

                } else if (brokenResponse.length > 1 && brokenResponse[0].equals("drop")) {
                    String itemName = brokenResponse[1];
                    Commands.drop(itemName, p);

                }

            }
        }

    }


}
