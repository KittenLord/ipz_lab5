package work5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TileGrid grid = new TileGrid(8, 8);
        grid.setPlayer(3, 3);
        grid.setObstacle(5, 5);

        grid.displayGrid();

        Scanner scanner = new Scanner(System.in).useDelimiter("");
        PlayerTile player = grid.getPlayer();
        while(true) {
            char c = scanner.next().charAt(0);
            if(c == 'w') player = player.moveUp();
            else if(c == 'a') player = player.moveLeft();
            else if(c == 's') player = player.moveDown();
            else if(c == 'd') player = player.moveRight();
            else if(c == 'q') break;
            else continue;
            grid.displayGrid();
        }

        System.out.println("goodbye");
    }
}
