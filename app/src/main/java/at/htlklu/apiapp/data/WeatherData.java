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
    private String dayOfWeek;
    private String city;
    //endregion

    //region constructors
    public WeatherData(Position position, MainStats mainStats, Weather weather, Wind wind, String city ) {
        this.position = position;
        this.mainStats = mainStats;
        this.weather = weather;
        this.wind = wind;
        this.date = new SimpleDateFormat("dd.MM.yy").format(new Date());
        calendar = Calendar.getInstance();
        this.dayOfWeek = getDayOfWeekAsString();
        this.city = city;
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

    //region getter & setter
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Position getCity() {
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

