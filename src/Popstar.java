import java.util.ArrayList;
import java.util.Collection;

public class Popstar extends Creature {

    public Popstar(Graph.Node room) {
        super(room);
    }

    @Override
    public void move(Player p) {
        if(p.getCurrentRoom().equals(getCurrentRoom())){
            System.out.println("The popstar is in the same room as the player!");
            return;
        }
        Graph.Node playerCurrentRoom = p.getCurrentRoom();
        Graph.Node toMove = null;
        Collection<Graph.Node> neighborsOld =  getCurrentRoom().getNeighbors().values();
        ArrayList<Graph.Node> neighbors = new ArrayList<>(neighborsOld);

        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i).equals(playerCurrentRoom)) {
                toMove = neighbors.get(i);
                break;
            } else {
               Collection neighborsNeighborsOld =  neighbors.get(i).getNeighbors().values();
               ArrayList<Graph.Node> neighborsNeighbors = new ArrayList<>(neighborsNeighborsOld);
                for (int j = 0; j < neighborsNeighbors.size(); j++) {
                    if (neighborsNeighbors.get(j).equals(playerCurrentRoom)) {
                        toMove = neighbors.get(i);
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
