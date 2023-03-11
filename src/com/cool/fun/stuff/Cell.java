package com.cool.fun.stuff;

/**
 * This class represents each Cell of the maze
 * Given its coordinates and whether if it is a wall or not
 * Along with utilities for checking player presence on the cell
 * 
 * @author lChrios
 */
public class Cell {
    
    private Integer x;
    private Integer y;
    private Boolean isWall;

    /**
     * Constructor used to map the maze to a Cell matrix
     * 
     * @param x         Column of the cell at the matrix
     * @param y         Row of the cell at the matrix
     * @param isWall    Whether it is a wall or not ('X' or ' ')
     */
    public Cell(Integer x, Integer y, Boolean isWall) {
        this.x = x;
        this.y = y;
        this.isWall = isWall;
    }

    public Integer getX() { return this.x; }

    public Integer getY() { return this.y; }

    public Boolean isWall() { return this.isWall; }

    /**
     * This is used to determine if the player 
     * is located at the current Cell.
     * 
     * @param player    Object from which extracts the player's position
     * @return          Boolean if the player is present on the cell and cell is not a wall
     */
    public Boolean containsPlayer(Player player) {
        return this.x.equals(player.getX()) && this.y.equals(player.getY()) && !this.isWall;
    }

    /**
     * Used to determine if this Cell is the start Cell.
     * 
     * @return  Boolean whether this Cell is the start Cell
     */
    public Boolean isStart() { return this.x == 0 && this.y == 1; }

    /**
     * Used to determine if this Cell is the end of the maze.
     * 
     * @param endH      The height at which the end Cell is located
     * @return          Whether the cell is a valid exit and the expected one
     */
    public Boolean isEnd(Integer endH) { return this.x == 0 && this.y == endH && !this.isWall; }
}
