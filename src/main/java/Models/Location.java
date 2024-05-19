package Models;

public class Location {
    private int Id;
    private char name;
    private int Distance;

    public Location(int id, char name, int distance) {
        Id = id;
        this.name = name;
        Distance = distance;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getDistnace() {
        return Distance;
    }

    public void setDistnace(int distance) {
        Distance = distance;
    }
}
