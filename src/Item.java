public class Item {

    private String name;
    private String description;
    private Graph.Node itemRoom;

    public Item(String name, String description, Graph.Node itemRoom) {
        this.name = name;
        this.description = description;
        this.itemRoom  = itemRoom;
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

    @Override
    public String toString() {
        return name + " " + description;
    }

    public void take(){

    }

    public void drop(){

    }
}
