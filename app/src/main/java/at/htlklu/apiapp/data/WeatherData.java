package at.htlklu.apiapp.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherData {

    //region properties
    private Position position;
    private MainStats mainStats;
    private Weather weather;
    private Wind wind;
    private String date;
    //endregion

    //region constructors
    public WeatherData(Position position, MainStats mainStats, Weather weather, Wind wind ) {
        this.position = position;
        this.mainStats = mainStats;
        this.weather = weather;
        this.wind = wind;
        this.date = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date());
    }
    //endregion

    //region methods

    @Override
    public String toString() {
        return "WeatherData{" +
                "location=" + position +
                ", mainStats=" + mainStats +
                ", weather=" + weather +
                ", wind=" + wind +
                ", date='" + date + '\'' +
                '}';
    }

    //endregion

    //region getter & setter
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Position getLocation() {
        return position;
    }

    public void setLocation( Position position) {
        this.position = position;
    }

    public MainStats getMainStats() {
        return mainStats;
    }

    public void setMainStats( MainStats mainStats ) {
        this.mainStats = mainStats;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather( Weather weather ) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind( Wind wind ) {
        this.wind = wind;
    }
    //endregion
}

