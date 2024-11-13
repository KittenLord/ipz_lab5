package work5;

public class TileGrid {

    private int width;
    private int height;

    private int playerX;
    private int playerY;

    private Tile[][] grid;

    public TileGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.playerX = -1;
        this.playerY = -1;
        this.grid = new Tile[height][width];
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                grid[x][y] = new EmptyTile();
            }
        }
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    public boolean isPlayerSet() {
        return playerX >= 0 && playerY >= 0;
    }

    private PlayerTile resetPlayer(int nx, int ny) {
        if(!isWithinBounds(nx, ny)) return null;
        
        if(isWithinBounds(playerX, playerY)) grid[playerX][playerY] = new EmptyTile();
        grid[nx][ny] = new PlayerTile();
        this.playerX = nx;
        this.playerY = ny;
        return grid[nx][ny];
    }

    public PlayerTile setPlayer(int x, int y) {
        if(!isWithinBounds(x, y)) return null;
        if(isPlayerSet()) return null;

        return resetPlayer(x, y);
    }

    public PlayerTile movePlayer(int dx, int dy) {
        if(!isPlayerSet()) return null;
        if(Math.abs(dx + dy) > 1) return null;
        if(!isWithinBounds(playerX + dx, playerY + dy)) return null;
        if(grid[playerX + dx][playerY + dy] instanceof ObstacleTile) return null;

        return resetPlayer(playerX + dx, playerY + dy);
    }

    public boolean teleportPlayer(int x, int y) {
        if(!isPlayerSet()) return false;
        if(!isWithinBounds(x, y)) return false;

        resetPlayer(x, y);
        return true;
    }

    public boolean setObstacle(int x, int y) {
        if(!isWithinBounds(x, y)) return false;
        if(x == playerX && y == playerY) return false;
        grid[x][y] = new ObstacleTile();
        return true;
    }

    public void displayGrid() { displayGrid('.', 'x', '#'); }
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
