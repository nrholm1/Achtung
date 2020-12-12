package Networking.Utils;

public class Payload {
    // position (x,y)
    // currInput (left, right, null)

    double x;
    double y;
    int currInput; // 1,2,3 -> (left, right, null)

    public void setX(double _x) {
        x = _x;
    }

    public void setY(double _y) {
        y = _y;
    }

    public void setCurrInput(int _currInput) {
        currInput = _currInput;
    }

    public Payload() {
        x = 0;
        y = 0;
        currInput = 0;
    }
}