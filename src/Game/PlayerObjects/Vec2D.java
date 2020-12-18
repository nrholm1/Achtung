package Game.PlayerObjects;

public class Vec2D {
    public Coord coord;
    private int angle;

    public void setAngle(int a) {
        angle = a;
    }

    public int getAngle() {
        return angle;
    }

    public void calculateVecFromAngle() {
        coord.v1 = Math.cos(Math
                .toRadians(this.getAngle()));
        coord.v2 = Math.sin(Math
                .toRadians(this.getAngle()));
    }

    public Vec2D scalarMultiply(double scalar) {
        return new Vec2D(coord.v1 * scalar, coord.v2 * scalar);
    }

    public Vec2D addVec(Vec2D otherVec) {
        return new Vec2D(coord.add(otherVec.coord));
    }

    public Vec2D removePrecision() {
        coord.v1 = (int) coord.v1;
        coord.v2 = (int) coord.v2;
        return this;
    }

    public Vec2D(int Angle) {
        setAngle(Angle);
        coord = new Coord();
        calculateVecFromAngle();
    }

    public Vec2D(double V1, double V2) {
        coord = new Coord(V1, V2);
    }

    public Vec2D(Coord _coord) {
        coord = _coord;
    }
}