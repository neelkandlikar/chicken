import java.util.ArrayList;
import java.util.Collection;

public class Wumpus extends Creature {

    public Wumpus(Graph.Node room) {
        super(room);
    }


    @Override
    public void move(Player p) {
        Graph.Node playerCurrentRoom = p.getCurrentRoom();
        if (playerCurrentRoom.equals(getCurrentRoom())) {
            System.out.println("The wumpus is in the same room as the player!");
        }
        Graph.Node toMove = null;
        Collection<Graph.Node> neighborsOld = getCurrentRoom().getNeighbors().values();
        ArrayList<Graph.Node> neighbors = new ArrayList<>(neighborsOld);


        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i).equals(playerCurrentRoom)) {
                if (i != 0) {
                    toMove = neighbors.get(i - 1);
                } else if (neighbors.size() > 1) {
                    toMove = neighbors.get(1);
                }
                // currently if the player is in a node two rooms away, the wumpus will move to a room that will not be neighboring the player
                break;
            } else {
                Collection<Graph.Node> neighborsNeighborsOld = neighbors.get(i).getNeighbors().values();
                ArrayList<Graph.Node> neighborsNeighbors = new ArrayList<>(neighborsNeighborsOld);
                for (int j = 0; j < neighborsNeighbors.size(); j++) {
                    if (neighborsNeighbors.get(j).equals(playerCurrentRoom)) {
                        if (i != 0)
                            toMove = neighbors.get(i - 1);
                        break;
                    } else if (neighbors.size() != 1) {
                        toMove = neighbors.get(i + 1);
                        break;
                        // currently if the player is in a node two rooms away, the wumpus will move to a room that will not be neighboring the player

                    }
                }
            }
        }

        if (toMove != null) {
            moveToRoom(this, toMove);
        }


    }
}
