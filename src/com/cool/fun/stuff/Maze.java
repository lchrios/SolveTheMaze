package com.cool.fun.stuff;

import java.util.List;

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
