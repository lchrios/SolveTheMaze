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

    private Orientation(Integer code, Side right, Side front, Side left) { this.code = code; }

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

    public enum Side {
        TOP(0, -1),
        LEFT(-1, 0),
        BOTTOM(0, 1),
        RIGHT(1, 0);
    
        private Integer dx;
        private Integer dy;
    
        private Side(Integer dx, Integer dy) { this.dx = dx; this.dy = dy; }
    
        public Integer getDx() { return this.dx; }
        public Integer getDy() { return this.dy; }
    }

}
