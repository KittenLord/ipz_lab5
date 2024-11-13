package work5;

public class PlayerTile extends Tile {

    public PlayerTile(TileGrid grid) { this.grid = grid; }

    public PlayerTile moveUp() {
        return grid.movePlayer(0, -1);
    }
    public PlayerTile moveRight() {
        return grid.movePlayer(1, 0);
    }
    public PlayerTile moveDown() {
        return grid.movePlayer(0, 1);
    }
    public PlayerTile moveLeft() {
        return grid.movePlayer(-1, 0);
    }

}
