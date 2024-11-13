package work5;

public class TileGrid {

    private int width;
    private int height;
    private Tile[][] grid;

    public TileGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Tile[height][width];
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                grid[x][y] = new EmptyTile();
            }
        }
    }

}
