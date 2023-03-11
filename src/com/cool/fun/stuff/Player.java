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

    public Integer getDir() { return this.dir; }

    public void rotateRight() { 
        // Will rotate the player to the next left cardinal direction
        this.dir = ((this.dir - 1) + 4) % 4;
    }

    public void rotateLeft() { 
        // Will rotate the player to the next left cardinal direction
        this.dir = (this.dir + 1) % 4;
    }

    public void rotateBackward() {
        this.dir = (this.dir + 2) % 4;
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
            default:
                break;
        }
    }

}
