package tasks.first;

public class Vertex {
    private int number;
    boolean isVisited;


    public Vertex(int number) {
        this.number = number;
        this.isVisited = false;
    }


    public int getNumber() {
        return number;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
