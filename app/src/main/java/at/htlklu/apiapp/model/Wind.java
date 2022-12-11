package at.htlklu.apiapp.model;

public class Wind {

    //region properties
    private double speed;
    private int deg;
    //endregion

    //region methods
    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
    //endregion

    //region getter & setter
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }
    //endregion
}
