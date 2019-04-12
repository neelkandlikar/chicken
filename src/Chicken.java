import java.util.ArrayList;
import java.util.HashMap;

public class Chicken extends Creature {

    public Chicken(Graph.Node currentRoom) {
        super(currentRoom);
    }

    @Override
    public void move(Player p) {
        moveToRoom(this, getRandomAdjacentRoom());
        //chicken moves to random room
    }
}
