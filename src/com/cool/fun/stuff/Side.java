package com.cool.fun.stuff;

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
