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
     * Coding for the orientation
     *      0 = North
     *      1 = West
     *      2 = South
     *      3 = East
     */
    private Orientation dir; 
    private Integer x;
    private Integer y;

    public Player() {
        // * Player will always start at this coordinates lookint to East
        this.x = 0;
        this.y = 1;
        this.dir = Orientation.EAST;
    }

    public Integer getX() { return this.x; }
    public void setX(Integer x) { this.x = x; }

    public Integer getY() { return this.y; }
    public void setY(Integer y) { this.y = y; }

    public Orientation getDir() { return this.dir; }

    /**
     * Will rotate the player to the next left cardinal direction
     */
    public void rotateRight() { this.dir = Orientation.getOrientation(((this.dir.getCode() - 1) + 4) % 4); }

    /**  
     * Will rotate the player to the next left cardinal direction
     */
    public void rotateLeft() { this.dir = Orientation.getOrientation((this.dir.getCode() + 1) % 4); }

    /**  
     * Will rotate the player to backwards direction
     */
    public void rotateBackward() { this.dir = Orientation.getOrientation((this.dir.getCode() + 2) % 4); }

    /**
     * Advance the player to the next cell depending on the current direction
     */
    public void move() {
        Side front = this.dir.getFront();

        this.setX(this.getX() + front.getDx());
        this.setY(this.getY() + front.getDy());
    }

}
