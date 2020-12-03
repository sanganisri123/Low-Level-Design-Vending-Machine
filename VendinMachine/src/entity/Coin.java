package entity;

public enum Coin {

    NOCOIN(0),ONEROOPE(1),FIVEROOPE(5),TENROOPE(10),TWENTYROOPE(20),FIFTYROOPE(50),HUNDREDROOPE(100);
    private long coinValue;

    public long getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(long coinValue) {
        this.coinValue = coinValue;
    }

    Coin(long value)
    {
        this.coinValue=value;
    }
}
