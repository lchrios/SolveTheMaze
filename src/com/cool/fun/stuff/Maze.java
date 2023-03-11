package com.cool.fun.stuff;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Maze {
    
    private List<List<Cell>> maze;
    private Player player;
    private Cell end;
    private Cell start = new Cell(0, 1, false);

    public Maze(List<List<Cell>> maze, Integer endHeight) {
        this.maze = maze;
        this.player = new Player();
        this.end = new Cell(0, endHeight, false);
    }

    public void nextStep() {
        player.move();        
    }


    public void solve() {
        // enter the first row
        if (start.containsPlayer(player)) {
            player.move();
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
            } else {
                // rotate backwards
                player.rotateBackward();
                player.move();
            }

            printMaze();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }

    public Boolean isSideAvailable(Integer side) {
        /*
         * Side coding
         * ------------------------
         * 0 = right
         * 1 = front
         * 2 = left
         */

        Integer x = player.getX();
        Integer y = player.getY();
        Integer dir = player.getDir();

        switch(side) {
            case 0:
                switch(dir) {
                    case 0:
                        return !this.maze.get(y).get(x + 1).isWall();
                    case 1:
                        return !this.maze.get(y - 1).get(x).isWall();
                    case 2:
                        return !this.maze.get(y).get(x - 1).isWall();
                    default:
                        return !this.maze.get(y + 1).get(x).isWall();
                }
            case 1:
                switch(dir) {
                    case 0:
                        return !this.maze.get(y - 1).get(x).isWall();
                    case 1:
                        return !this.maze.get(y).get(x - 1).isWall();
                    case 2:
                        return !this.maze.get(y + 1).get(x).isWall();
                    default:
                        return !this.maze.get(y).get(x + 1).isWall();
                }
            default:
                switch(dir) {
                    case 0:
                        return !this.maze.get(y).get(x - 1).isWall();
                    case 1:
                        return !this.maze.get(y - 1).get(x).isWall();
                    case 2:
                        return !this.maze.get(y).get(x + 1).isWall();
                    default:
                        return !this.maze.get(y + 1).get(x).isWall();
                }
        }
    }

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

    public Boolean isSolved() {
        return end.containsPlayer(player);
    }
}
