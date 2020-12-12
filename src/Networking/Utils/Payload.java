package Networking.Utils;

import java.io.Serializable;

public class Payload implements Serializable {
    // position (x,y)
    // currInput (left, right, null)

    double x;
    double y;
    int currInput; // 0,1,2 -> (null, left, right)

    public void setX(double _x) {
        x = _x;
    }

    public void setY(double _y) {
        y = _y;
    }

    public void setCurrInput(int _currInput) {
        currInput = _currInput;
    }

    public String toString() {
        String inputDir = "null";
        if (currInput != 0)
            inputDir = currInput == 1 ? "left" : "right";
        return "(" + x + ", " + y + ") - " + inputDir;
    }

    public Payload() {
        x = 0;
        y = 0;
        currInput = 0;
    }
}