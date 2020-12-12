package Networking.Utils;

public class PayloadBuilder {
    Payload payload;

    public PayloadBuilder() {
        payload = new Payload();
    }

    public Payload create() {
        return payload;
    }

    public PayloadBuilder withX(double _x) {
        payload.setX(_x);
        return this;
    }

    public PayloadBuilder withY(double _y) {
        payload.setY(_y);
        return this;
    }

    public PayloadBuilder withCurrInput(int _currInput) {
        payload.setCurrInput(_currInput);
        return this;
    }
}