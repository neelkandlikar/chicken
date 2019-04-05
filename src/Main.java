import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args){



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
        Item e= new Item("item5", "Description5");

        g.getNode("dungeon").addItem(a);
        g.getNode("hall").addItem(b);
        g.getNode("dungeon").addItem(c);
        g.getNode("closet").addItem(d);
        g.getNode("hall").addItem(e);




        Player p = new Player("Neel", "a legend");
        p.setCurrentRoom(g.getNode("hall"));


        String response;
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are currently in the " + p.getCurrentRoom().getName());


        while (true) {
//            System.out.println("You can go to the " + currentNode.getNeighborNames());
//            System.out.println("What room would you like to go to?");

            response = scanner.nextLine();
            response = response.trim().toLowerCase();
            if (response.equals("quit")) {
                System.exit(0);
            } else if (response.equals("help")) {
                help();
            } else if (response.equals("look")) {
                System.out.println(p.getCurrentRoom().getItems());
            } else {
                String[] brokenResponse = response.split(" ");
                if (brokenResponse.length > 1 && brokenResponse[0].equals("go")) {
                    Graph.Node newNode = p.getCurrentRoom().getNeighbor(brokenResponse[1]);
                    if (newNode == null) {
                        System.out.println("Please enter a valid neighbor!");
                        continue;
                    }
                    p.setCurrentRoom(newNode);
                    System.out.println("You are currently in the " + p.getCurrentRoom().getName());
                    continue;
                } else if (brokenResponse.length > 2 && brokenResponse[0].equals("add") && brokenResponse[1].equals("room")) {
                    String s = "";
                    for (int i = 2; i < brokenResponse.length; i++) {
                        s += brokenResponse[i];
                    }
                    g.addNode(s, "user added room name " + s);
                    g.addDirectedEdge(p.getCurrentRoom().getName(), s);
                    System.out.println("added room " + s);
                    continue;
                } else if (brokenResponse.length > 1 && brokenResponse[0].equals("take")) {
                    String itemName = brokenResponse[1];
                    for (int i = 0; i < p.getCurrentRoom().getItems().size(); i++)
                        if (p.getCurrentRoom().getItems().get(i).getName().equals(itemName)) {
                            Item item = p.getCurrentRoom().getItems().get(i);
                            p.addItem(item);
                            p.getCurrentRoom().removeItem(itemName);
                            System.out.println("Picked up item " + item.getName() + " in " + p.getCurrentRoom().getName());
                            break;
                        }
                } else if (brokenResponse.length > 1 && brokenResponse[0].equals("drop")) {
                    String itemName = brokenResponse[1];
                    for (int i = 0; i < p.getItems().size(); i++)
                        if (p.getItems().get(i).getName().equals(itemName)) {
                            Item item = p.getItems().get(i);
                            p.getCurrentRoom().addItem(item);
                            p.removeItem(itemName);
                            System.out.println("Dropped item " + item.getName() + " in " + p.getCurrentRoom().getName());
                            break;
                        }
                } else {
                    help();
                }
            }
        }


    }

    public static void help() {
        String help = "Help\n" + "\"look\" to view all available commands  \n\"go\" <roomname> to go to a different room \n\"add room\" <roomname> to add a room that is neighboring the current one  \n\"quit\" to quit \nuse commands take or drop <item> to pick up or drop items";
        System.out.println(help);
    }

}
