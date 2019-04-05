import java.util.ArrayList;
import java.util.HashMap;

public class Chicken extends Creature {

    public Chicken(Graph.Node currentRoom) {
        super(currentRoom);
    }

    @Override
    public void move() {
        ArrayList<Graph.Node> neighbors = (ArrayList<Graph.Node>) getCurrentRoom().getNeighbors().values();
        Graph.Node room = neighbors.get((int) (Math.random() * neighbors.size()));
        moveToRoom(this, room);
    }
}
