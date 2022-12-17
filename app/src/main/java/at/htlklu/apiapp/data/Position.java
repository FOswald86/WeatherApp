package at.htlklu.apiapp.data;

public class Position {

    //region properties
    private double lon;
    private double lat;
    private int timezone;
    private String name;
    private String country;
    private long sunrise;
    private long sunset;
    //endregion

    //region methods
    @Override
    public String toString() {
        return "Location{" +
                "lon=" + lon +
                ", lat=" + lat +
                ", timezone=" + timezone +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
    //endregion

    //region getter & setter
    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
    //endregion
}
