package com.cool.fun.stuff;

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
    public Side getLeft() { return this.left; }
    public Side getFront() { return this.front; }
    public Side getRight() { return this.right; }

    public static Orientation getOrientation(Integer code) {
        for (Orientation or : Orientation.values()) {
            if (or.code == code) return or;
        }

        return null;
    }

}
