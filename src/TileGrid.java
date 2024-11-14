package work5;

/**
 * The grid that manages its tiles and represents the Mediator class
 */
public class TileGrid {

    /**
     * The width of the grid
     */
    private int width;

    /**
     * The height of the grid
     */
    private int height;

    /**
     * The cached value of the X coordinate of the player (-1 if player is unset)
     */
    private int playerX;

    /**
     * The cached value of the Y coordinate of the player (-1 if player is unset)
     */
    private int playerY;

    /**
     * The internal representation of the grid
     */
    private Tile[][] grid;

    /**
     * The constructor for the TileGrid class
     * @param width The width of the grid
     * @param height The height of the grid
     */
    public TileGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.playerX = -1;
        this.playerY = -1;
        this.grid = new Tile[height][width];
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                grid[x][y] = new EmptyTile(this);
            }
        }
    }

    /**
     * A utility method that checks whether the coordinates are within the grid bounds
     * @param x The x coordinate
     * @param y The y coordinate
     * @return True, if the position is within the bounds
     */
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    /**
     * A utility method that checks whether the player has been set previously
     * @return True, if the player has been set
     */
    public boolean isPlayerSet() {
        return playerX >= 0 && playerY >= 0;
    }

    /**
     * A utility method that moves the player to the new position (or creates the player)
     * @param nx The new x position
     * @param ny The new y position
     * @return The new player object, null if position is out of bounds
     */
    private PlayerTile resetPlayer(int nx, int ny) {
        if(!isWithinBounds(nx, ny)) return null;
        
        if(isWithinBounds(playerX, playerY)) grid[playerX][playerY] = new EmptyTile(this);
        grid[nx][ny] = new PlayerTile(this);
        this.playerX = nx;
        this.playerY = ny;
        return (PlayerTile)grid[nx][ny];
    }

    /**
     * A method to get the current player object
     * @return The player object, null if hasn't been set
     */
    public PlayerTile getPlayer() {
        if(!isWithinBounds(playerX, playerY)) return null;
        return (PlayerTile)grid[playerX][playerY];
    }

    /**
     * The method which sets the player if it wasn't previously set
     * @param x The x player coordinate
     * @param y The y player coordinate
     * @return The new player object, null if player hasn't been set
     */
    public PlayerTile setPlayer(int x, int y) {
        if(isPlayerSet()) return null;
        if(!isWithinBounds(x, y)) return getPlayer();

        return resetPlayer(x, y);
    }

    /**
     * The method to move player by one tile horizontally or vertically
     * @param dx The x difference
     * @param dy The y difference
     * @return The new player object, null if player hasn't been set
     */
    public PlayerTile movePlayer(int dx, int dy) {
        if(!isPlayerSet()) return null;
        if(Math.abs(dx + dy) > 1) return getPlayer();
        if(!isWithinBounds(playerX + dx, playerY + dy)) return getPlayer();
        if(grid[playerX + dx][playerY + dy] instanceof ObstacleTile) return getPlayer();

        return resetPlayer(playerX + dx, playerY + dy);
    }

    /**
     * The method to teleport player to an arbitrary position
     * @param x The x position
     * @param y The y position
     * @return The new player object
     */
    public PlayerTile teleportPlayer(int x, int y) {
        if(!isPlayerSet()) return null;
        if(!isWithinBounds(x, y)) return getPlayer();

        return resetPlayer(x, y);
    }

    /**
     * The method to set an obstacle
     * @param x The x coordinate
     * @param y The y coordinate
     * @return False, if the tile is occupied by the player
     */
    public boolean setObstacle(int x, int y) {
        if(!isWithinBounds(x, y)) return false;
        if(x == playerX && y == playerY) return false;
        grid[x][y] = new ObstacleTile(this);
        return true;
    }

    /**
     * A method to display the grid with default values set
     */
    public void displayGrid() { displayGrid('.', 'o', '#'); }

    /**
     * A method to display the grid
     * @param empty A char to represent the empty tile
     * @param player A char to represent the player tile
     * @param obstacle A char to represent the obstacle tile
     */
    public void displayGrid(char empty, char player, char obstacle) {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Tile tile = grid[x][y];
                if(tile instanceof EmptyTile)
                    System.out.print(empty);
                else if(tile instanceof PlayerTile)
                    System.out.print(player);
                else if(tile instanceof ObstacleTile)
                    System.out.print(obstacle);
            }
            System.out.println();
        }
    }

}
