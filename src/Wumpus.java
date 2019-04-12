import java.util.ArrayList;

public class Wumpus extends Creature {

    public Wumpus(Graph.Node room) {
        super(room);
    }


    @Override
    public void move(Player p) {
        Graph.Node playerCurrentRoom = p.getCurrentRoom();
        if(playerCurrentRoom.equals(getCurrentRoom())){
            System.out.println("The wumpus is in the same room as the player!");
        }
        Graph.Node toMove = null;
        ArrayList<Graph.Node> neighbors = (ArrayList<Graph.Node>) getCurrentRoom().getNeighbors().values();

        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i).equals(playerCurrentRoom)) {
                toMove = neighbors.get(i - 1);
                // currently if the player is in a node two rooms away, the wumpus will move to a room that will not be neighboring the player
                break;
            } else {
                ArrayList<Graph.Node> neighborsNeighbors = (ArrayList<Graph.Node>) neighbors.get(i).getNeighbors().values();
                for (int j = 0; j < neighborsNeighbors.size(); j++) {
                    if (neighborsNeighbors.get(j).equals(playerCurrentRoom)) {
                        toMove = neighbors.get(i - 1);
                        // currently if the player is in a node two rooms away, the wumpus will move to a room that will not be neighboring the player
                        break;
                    }
                }
            }
        }

        if (toMove != null) {
            moveToRoom(this, toMove);
        }


    }
}
