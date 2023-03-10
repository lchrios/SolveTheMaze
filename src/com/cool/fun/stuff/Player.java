package com.cool.fun.stuff;

public class Player {

    private Integer x;
    private Integer y;
    /*
     * Values for the direction
     * ------------------------
     * 0 = North
     * 1 = West
     * 2 = South
     * 3 = East
     */
    private Integer dir; 

    public Player() {
        // * Player will always start at this coordinates lookint to East
        this.x = 0;
        this.y = 1;
        this.dir = 3;
    }

    public Integer getX() { return this.x; }

    public Integer getY() { return this.y; }

    public void rotate() { 
        // Will rotate the player to the next right cardinal direction
        dir = (dir + 1) % 4;
    }

    public void move() {
        switch (this.dir) {
            case 0:
                this.y--;
                break;
            case 1:
                this.x--;
                break;
            case 2:
                this.y++;
                break;
            case 3:
                this.x++;
                break;
        }
    }

}
