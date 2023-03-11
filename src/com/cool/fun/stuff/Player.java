package com.cool.fun.stuff;

/**
 * Class which contians the coordinates of the player at the maze 
 * along with the oritnetation of the player which is coded.
 * 
 * @author lChrios
 */
public class Player {

    /**
     * Contains the direction at which the player is facing through storing it by this code
     * ------------------------
     * Coding for the oritnetation
     *      0 = North
     *      1 = West
     *      2 = South
     *      3 = East
     */
    // TODO: Change direction from Integer to ENUMS
    private Integer dir; 
    private Integer x;
    private Integer y;

    public Player() {
        // * Player will always start at this coordinates lookint to East
        this.x = 0;
        this.y = 1;
        this.dir = 3;
    }

    public Integer getX() { return this.x; }

    public Integer getY() { return this.y; }

    public Integer getDir() { return this.dir; }

    /**
     * Will rotate the player to the next left cardinal direction
     */
    public void rotateRight() { this.dir = ((this.dir - 1) + 4) % 4; }

    /**  
     * Will rotate the player to the next left cardinal direction
     */
    public void rotateLeft() { this.dir = (this.dir + 1) % 4; }

    /**  
     * Will rotate the player to backwards direction
     */
    public void rotateBackward() { this.dir = (this.dir + 2) % 4; }

    /**
     * Advance the player to the next cell depending on the current direction
     */
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
