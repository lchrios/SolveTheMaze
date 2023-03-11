package com.cool.fun.stuff;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This class contains the following attributes:
 * - A matrix of Cell objects that represent the parsed maze; 
 * - The Player instance 
 * - References to the start and end Cells of the maze
 * 
 * @author lChrios
 */
public class Maze {
    
    private List<List<Cell>> maze;
    private Player player;
    private Cell end;
    private Cell start = new Cell(0, 1, false);

    /**
     * Constructor method for the Maze which generates 
     * a new Player instance along with the given end Cell object.
     * 
     * @param maze          The matrix of Cell objects
     * @param endHeight     Height of the end Cell object
     * @return              Maze instance
     */
    public Maze(List<List<Cell>> maze, Integer endHeight) {
        this.maze = maze;
        this.player = new Player();
        this.end = new Cell(0, endHeight, false);
    }

    /**
     * This method will find the exit of the maze by following the
     * right-hand rule to solve mazes. 
     * The player will try to move to the rightest available side.
     * Each player movement will conclude with the printing of the 
     * maze through the printMaze method and a subsequent sleep to 
     * visualize the movement through the CLI.
     */
    public void solve() {
        // Enter the first maze Cell
        if (start.containsPlayer(player)) {
            player.move();
            printMaze();
        }

        while (!isSolved()) {

            if (isSideAvailable(0)) {
                // check if right is available
                player.rotateRight();
                player.move();
            } else if (isSideAvailable(1)) {
                // check if front is available
                player.move();
            } else if (isSideAvailable(2)) {
                // check if left is available
                player.rotateLeft();
                player.move();
            } else {
                // rotate backwards
                player.rotateBackward();
                player.move();
            }

            printMaze();

            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Exit was found.");
    }

    /**
     * This method will check for the queried side availability 
     * based on the player orientation and the method input.
     * 
     * @param side  A number indicating the side to check based on a side code
     *                  0 = right side
     *                  1 = front side
     *                  2 = left side
     * @return      Boolean for the availability for queried side 
     */
    public Boolean isSideAvailable(Integer sideCode) {

        Integer x = player.getX();
        Integer y = player.getY();
        
        Side side = this.player.getDir().getSide(sideCode);
        
        return !this.maze.get(y + side.getDy()).get(x + side.getDx()).isWall();
    }

    /**
     * This method will print the current state of the maze 
     * through the console by serializing the Cell into a String
     */
    public void printMaze() {
        StringBuffer sb = new StringBuffer();
        for(List<Cell> row : this.maze) {
            row.stream().forEach(cell -> {
                if (cell.containsPlayer(player)) {
                    sb.append('O');
                } else if (cell.isEnd(this.end.getY())) {
                    sb.append('E');
                } else if (cell.isStart()) {
                    sb.append('B');
                } else {
                    sb.append(cell.isWall() ? 'X' : ' ');
                }
            });
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    /**
     * Checks if the player is present in the end Cell
     * 
     * @return  Boolean whether the player is located in the end Cell or not
     */
    public Boolean isSolved() { return end.containsPlayer(player); }
}
