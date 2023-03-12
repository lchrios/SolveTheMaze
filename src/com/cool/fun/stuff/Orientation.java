package com.cool.fun.stuff;

/**
 * This enum represents the orientation for the player and the 
 * respective sides it has according to this orientation.
 * 
 * @author lChrios
 */
public enum Orientation {
        NORTH(0, Side.RIGHT, Side.TOP, Side.LEFT),
        WEST(1, Side.TOP, Side.LEFT, Side.BOTTOM),
        SOUTH(2, Side.LEFT, Side.BOTTOM, Side.RIGHT),
        EAST(3, Side.BOTTOM, Side.RIGHT, Side.TOP);

    private Integer code;
    private Side left;
    private Side right;
    private Side front;

    private Orientation(Integer code, Side right, Side front, Side left) { 
        this.code = code;
        this.right = right;
        this.front = front;
        this.left = left; 
    }

    public Integer getCode() { return this.code; }
    
    /**
     * Generic method to obtain the side based on the query code
     * 
     * @param side  Code to return for left, front or right side
     *              0 = right, 1 = front, 2 = left
     * @return      Side depending on the queried code
     */
    public Side getSide(Integer side) {
        return side == 0 ? this.right : side == 1 ? this.front : this.left;
    }

    public Side getFront() { return this.front; }

    /**
     * Used to determine the Direction based on the direction code
     * 
     * @param code  Number to query the code for the matching orientation
     * @return      Returns the corresponding Orientation
     */
    public static Orientation getOrientation(Integer code) {
        for (Orientation or : Orientation.values())
            if (or.code == code) return or; // Orientation matched

        return null;
    }

}
