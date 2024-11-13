package work5;

public class Main {
    public static void main(String[] args) {
        TileGrid grid = new TileGrid(8, 8);
        grid.setPlayer(3, 3);
        grid.setObstacle(5, 5);

        grid.displayGrid();
    }
}
