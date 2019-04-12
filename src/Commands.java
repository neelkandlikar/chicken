import java.util.ArrayList;

public class Commands {

    private static String help = "Help\n" + "\"look\" to view all available commands  \n\"go\" <roomname> to go to a different room \n\"add room\" <roomname> to add a room that is neighboring the current one  \n\"quit\" to quit \nuse commands take or drop <item> to pick up or drop items";

    public static void drop(String itemName, Player p) {
        for (int i = p.getItems().size() - 1; i >= 0; i--) {
            if (p.getItems().get(i).getName().equals(itemName)) {
                Item item = p.getItems().get(i);
                p.getCurrentRoom().addItem(item);
                p.removeItem(itemName);
                System.out.println("Dropped item " + item.getName() + " in " + p.getCurrentRoom().getName());
                return;
            }
        }
        help();
    }

    public static void take(String itemName, Player p) {
        ArrayList<Item> roomItems = p.getCurrentRoom().getItems();
        for (int i = roomItems.size() - 1; i >= 0; i--) {
            if (roomItems.get(i).getName().equals(itemName)) {
                Item item = p.getCurrentRoom().getItems().get(i);
                p.addItem(item);
                p.getCurrentRoom().removeItem(itemName);
                System.out.println("Picked up item " + item.getName() + " in " + p.getCurrentRoom().getName());
                return;
            }
        }
        help();
    }

    public static void go(Player p, Graph.Node newNode) {
        if (newNode == null) {
            System.out.println("Please enter a valid neighbor!");
            return;
        }
        p.setCurrentRoom(newNode);
        System.out.println("You are currently in the " + p.getCurrentRoom().getName());
    }

    public static void look(Player p) {
        System.out.println(p.getCurrentRoom().getItems());
    }

    public static void addRoom(String s, Player p,  Graph g) {
        g.addNode(s, "user added room name " + s);
        g.addDirectedEdge(p.getCurrentRoom().getName(), s);
        System.out.println("added room " + s);

    }




    public static void help() {
        System.out.println(help);
    }

}


