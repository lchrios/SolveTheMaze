package com.cool.fun.stuff;
/**
 * Represents the diferential for each side to calculate the adjacent Cells
 * Used to calculate the Cell at the given side which depends on the Orientation
 * 
 * @author lChrios
 */
public enum Side {
    TOP(0,-1),
    LEFT(-1, 0),
    BOTTOM(0, 1),
    RIGHT(1, 0);

    private Integer dx;
    private Integer dy;

    private Side(Integer dx, Integer dy) { this.dx = dx; this.dy = dy; }

    public Integer getDx() { return this.dx; }
    public Integer getDy() { return this.dy; }
}
