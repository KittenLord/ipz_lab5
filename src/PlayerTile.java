package work5;

/**
 * A tile that contains the player
 */
public class PlayerTile extends Tile {

    /**
     * The constructor for the PlayerTile class
     * @param grid The parent grid
     */
    public PlayerTile(TileGrid grid) { this.grid = grid; }

    /**
     * A method that tries to move player upwards, and returns the new player
     * @return The new player object
     */
    public PlayerTile moveUp() {
        return grid.movePlayer(0, -1);
    }
    /**
     * A method that tries to move player rightwards, and returns the new player
     * @return The new player object
     */
    public PlayerTile moveRight() {
        return grid.movePlayer(1, 0);
    }
    /**
     * A method that tries to move player downwards, and returns the new player
     * @return The new player object
     */
    public PlayerTile moveDown() {
        return grid.movePlayer(0, 1);
    }
    /**
     * A method that tries to move player leftwards, and returns the new player
     * @return The new player object
     */
    public PlayerTile moveLeft() {
        return grid.movePlayer(-1, 0);
    }

}
