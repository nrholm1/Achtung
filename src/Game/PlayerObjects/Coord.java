package Game.PlayerObjects;

public class Coord {
    public double v1;
    public double v2;

    public Coord add(Coord otherCoord) {
        return new Coord(v1 + otherCoord.v1, v2 + otherCoord.v2);
    }

    public Coord(double V1, double V2) {
        v1 = V1;
        v2 = V2;
    }

    public double[] getPositionInDoubles() {
        return new double[] {v1, v2};
    }

    public Coord() {}
}