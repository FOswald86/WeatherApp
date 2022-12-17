package at.htlklu.apiapp.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WeatherData {

    //region properties
    private Position position;
    private MainStats mainStats;
    private Weather weather;
    private Wind wind;
    private String date;
    private Calendar calendar;
    //endregion

    //region constructors
    public WeatherData(Position position, MainStats mainStats, Weather weather, Wind wind, String city ) {
        this.position = position;
        this.mainStats = mainStats;
        this.weather = weather;
        this.wind = wind;
        this.date = new SimpleDateFormat("dd.MM.yy").format(new Date());
        calendar = Calendar.getInstance();
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

    public String getDayOfWeekAsString() {

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                return "Sonntag";
            case Calendar.MONDAY:
                return "Montag";
            case Calendar.TUESDAY:
                return "Dienstag";
            case Calendar.WEDNESDAY:
                return "Mittwoch";
            case Calendar.THURSDAY:
                return "Donnerstag";
            case Calendar.FRIDAY:
                return "Freitag";
            case Calendar.SATURDAY:
                return "Samstag";
            default:
                return "Wochentags Fehler";
        }
    }
    //endregion

    //region getter & setter
    public Position getPosition() {
        return position;
    }

    public String getDate() {
        return date;
    }

    public MainStats getMainStats() {
        return mainStats;
    }

    public Weather getWeather() {
        return weather;
    }
    //endregion
}

