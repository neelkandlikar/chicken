import java.util.ArrayList;
import java.util.HashMap;

public class Chicken extends Creature {

    private String name = "Chicken";

    public Chicken(Graph.Node currentRoom) {
        super(currentRoom);
    }

    @Override
    public void move(Player p) {
        moveToRoom(this, getRandomAdjacentRoom());
        //chicken moves to random room
        if(this.getCurrentRoom().equals(p.getCurrentRoom())){
            System.out.println("Chicken " + name  + " is in the same room as the player");
        }
    }

    public void setName(String name){
        this.name = name;
    }
}
