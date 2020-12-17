package Game.PlayerObjects;

import Game.GameConstants;

public class Kurwe {
    private int port;
    private Vec2D positionVec;
    private Vec2D moveVec;
    private int colorId;
    public Coord[] lastVisited;

    public void setPlayerId(int Id) { port = Id; }
    public int getPlayerId() { return port; }

    public int getColorId() { return colorId; }

    public Vec2D getPositionVec() {
        return positionVec;
    }

    public void setNewAngle(boolean clockwise) {
        if (clockwise)
            moveVec.setAngle(moveVec.getAngle()
                    - GameConstants.rotSize);
        else
            moveVec.setAngle(moveVec.getAngle()
                    + GameConstants.rotSize);
        moveVec.calculateVecFromAngle();
    }

    public void move() {
        positionVec = positionVec.addVec(moveVec);
    }

    public int chooseUniqueColor() {
        int id = -1;
        while (!GameConstants.usedColors.contains(colorId)) {
            id = (int) (Math.random() * 6);
            GameConstants.usedColors.add(colorId);
        }

        return id;
    }

    public void updateLastVisited(int x, int y) {
        for(int i = 1; i < lastVisited.length; i++) {
            lastVisited[i] = lastVisited[i - 1];
        }
        lastVisited[0] = new Coord(x,y);
    }

    public boolean isInLastVisited(int x, int y) {
        boolean isIn = false;
        for (var c : lastVisited)
            if ((c.v1 == x && c.v2 == y))
                isIn = true;
        return isIn;
    }

    public Kurwe(int Id) {
        setPlayerId(Id);
        colorId = chooseUniqueColor();
        positionVec = new Vec2D(500,500);

        int angle = (int) (Math.random() * 5 * 45);
        angle -= angle % 5;
        moveVec = new Vec2D(angle);

        lastVisited = new Coord[3];
    }

    public void logKurwePosition() {
        System.out.println("(X: " + positionVec.coord.v1 + ", Y: " + positionVec.coord.v2 + ")");
    }

    public String getKurwePositionLog() {
        return "(X: " + positionVec.coord.v1 + ", Y: " + positionVec.coord.v2 + ")";
    }
}