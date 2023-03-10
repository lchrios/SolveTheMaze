package com.cool.fun.stuff;

public class Cell {
    
    private Integer x;
    private Integer y;
    private Boolean isWall;

    public Cell(Integer x, Integer y, Boolean isWall) {
        this.x = x;
        this.y = y;
        this.isWall = isWall;
    }

    public Integer getX() { return this.x; }

    public Integer getY() { return this.y; }

    public Boolean isWall() { return this.isWall; }

    public Boolean containsPlayer(Player player) {
        return this.x.equals(player.getX()) && this.y.equals(player.getY()) && !this.isWall;
    }

    public Boolean isStart() { return this.x == 0 && this.y == 1; }

    public Boolean isEnd(Integer endH) { return this.x == 0 && this.y == endH && !this.isWall; }
}
