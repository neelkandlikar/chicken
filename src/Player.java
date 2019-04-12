import java.util.ArrayList;

public class Player {

    private String name;
    private String description;
    private ArrayList<Item> items;
    private Graph.Node currentRoom;

    public Player(String name, String description) {
        items = new ArrayList<>();
        this.name = name;
        this.description = description;
    }

    public void addItem(String name, String description){
        items.add(new Item(name, description));
    }

    public void addItem(Item i){
        items.add(i);
    }

    public void removeItem(String name){
        for(int i = items.size() -1; i >= 0; i--){
            if(items.get(i).getName().equals(name)){
                items.remove(i);
            }
        }
    }

    public void displayItems(){
        for (int i = 0; i < items.size(); i++){
            System.out.print(items.get(i).getName() + "," + items.get(i).getDescription() + " ");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Graph.Node getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void look(){
        System.out.println("These are the rooms that you can visit ");
    }
}
