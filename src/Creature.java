import java.util.ArrayList;

public abstract class Creature {

    private Graph.Node currentRoom;


    public Creature(Graph.Node currentRoom){
        this.currentRoom = currentRoom;
    }


    public abstract void move(Player p);

    public  Graph.Node getRandomAdjacentRoom(){
        ArrayList<Graph.Node> neighbors = (ArrayList<Graph.Node>) currentRoom.getNeighbors().values();
        int i = (int) (Math.random() * neighbors.size());
        return neighbors.get(i);
    }

    protected  Graph.Node getCurrentRoom(){
        return currentRoom;
    }

    protected  void moveTowards(Graph.Node r){


    }

    protected  boolean isRoomCloserTo(Player p, Graph.Node r){
        int playerDistance = 0;
        int roomDistance = 0;
        return false;

    }

    protected void moveToRoom(Creature c, Graph.Node r) {
       Graph.Node oldRoom = currentRoom;
       oldRoom.removeCreature(c);
       currentRoom = r;
       r.addCreature(c);
    }


}
