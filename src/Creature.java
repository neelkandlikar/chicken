import java.util.ArrayList;
import java.util.Collection;

public abstract class Creature {

    private Graph.Node currentRoom;


    public Creature(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }


    public abstract void move(Player p);

    public Graph.Node getRandomAdjacentRoom() {
        Collection<Graph.Node> neighborsOld = currentRoom.getNeighbors().values();
        ArrayList<Graph.Node> neighbors = new ArrayList<>(neighborsOld);
        if (neighbors.size() == 0) {
            return null;
        }
        int i = (int) (Math.random() * neighbors.size());
        return neighbors.get(i);
    }

    protected Graph.Node getCurrentRoom() {
        return currentRoom;
    }


    protected void moveToRoom(Creature c, Graph.Node r) {
        if (r == null) {
            return;
        }
        Graph.Node oldRoom = currentRoom;
        oldRoom.removeCreature(c);
        currentRoom = r;
        r.addCreature(c);
    }


}
