package work5;

/**
 * A tile that isn't occupied by anything
 */
public class EmptyTile extends Tile {

    /**
     * The constructor for the EmptyTile class
     * @param grid The parent grid
     */
    public EmptyTile(TileGrid grid) { this.grid = grid; }
}
