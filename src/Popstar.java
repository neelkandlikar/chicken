import java.util.ArrayList;

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
        ArrayList<Graph.Node> neighbors = (ArrayList<Graph.Node>) getCurrentRoom().getNeighbors().values();

        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i).equals(playerCurrentRoom)) {
                toMove = neighbors.get(i);
                break;
            } else {
                ArrayList<Graph.Node> neighborsNeighbors = (ArrayList<Graph.Node>) neighbors.get(i).getNeighbors().values();
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
