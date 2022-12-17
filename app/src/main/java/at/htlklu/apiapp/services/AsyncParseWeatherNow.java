package at.htlklu.apiapp.services;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

import at.htlklu.apiapp.MainActivity;
import at.htlklu.apiapp.R;
import at.htlklu.apiapp.data.MainStats;
import at.htlklu.apiapp.data.Position;
import at.htlklu.apiapp.data.Weather;
import at.htlklu.apiapp.data.WeatherData;
import at.htlklu.apiapp.data.Wind;

public class AsyncParseWeatherNow extends AsyncTask<String, Integer, WeatherData> {

    private MainActivity activity;

    public AsyncParseWeatherNow(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected WeatherData doInBackground(String... var) {

        StringBuilder url = new StringBuilder(var[0]);
        for (int i = 1; i < var.length; i++) {
            url.append(i < var.length - 1 ? var[i] + "&" : var[i]);
        }

        Gson gson = new Gson();
        final URL URL;
        JsonObject jsonObject;
        try {
            URL = new URL(url.toString());
            jsonObject = JsonParser.parseReader(new InputStreamReader(URL.openStream())).getAsJsonObject();
        } catch (IOException e) {
            return null;
        }

        Position location = getLocation(jsonObject, gson);

        Weather weather = getWeatherDescription(jsonObject, gson);

        MainStats mainStats = getTempsPressureHumidity(jsonObject, gson);

        Wind wind = getWind(jsonObject, gson);

        return new WeatherData(location, mainStats, weather, wind, var[2]);
    }

    @Override
    protected void onPostExecute(WeatherData weatherData) {
        TextView dataOutput = activity.findViewById(R.id.txt_title);
        activity.findViewById(R.id.cardContainer).setVisibility(View.VISIBLE);
        if (weatherData != null) {
            dataOutput.setText(String.format("%s%n%s%n%s%n%.0f°C%n%s",
                    weatherData.getPosition().getName().substring(1, weatherData.getPosition().getName().length() -1 ),
                    weatherData.getDayOfWeekAsString(),
                    weatherData.getDate(),
                    weatherData.getMainStats().getTemp(),
                    weatherData.getWeather().getDescription()));
        } else {
            dataOutput.setText("Ort nicht gefunden");
        }
    }

    //region helper methods
    private static Wind getWind(JsonObject jsonObject, Gson gson) {
        JsonObject windJsonObject = jsonObject.getAsJsonObject("wind");
        return gson.fromJson(windJsonObject, Wind.class);
    }

    private static MainStats getTempsPressureHumidity(JsonObject jsonObject, Gson gson) {
        JsonObject mainJsonObject = jsonObject.getAsJsonObject("main");
        return gson.fromJson(mainJsonObject, MainStats.class);
    }

    private static Weather getWeatherDescription(JsonObject jsonObject, Gson gson) {
        JsonArray weatherJsonArray = jsonObject.getAsJsonArray("weather");
        return gson.fromJson(weatherJsonArray.get(0).getAsJsonObject(), Weather.class);
    }

    private static Position getLocation(JsonObject jsonObject, Gson gson) {
        // lon & lat entry
        JsonObject coordsJsonObject = jsonObject.getAsJsonObject("coord");
        Position location = gson.fromJson(coordsJsonObject, Position.class);

        JsonObject sysJsonObject = jsonObject.getAsJsonObject("sys");
        location.setCountry(String.valueOf(sysJsonObject.get("country")));
        location.setSunrise(Long.parseLong(String.valueOf(sysJsonObject.get("sunrise"))));
        location.setSunset(Long.parseLong(String.valueOf(sysJsonObject.get("sunset"))));

        location.setTimezone(Integer.parseInt(String.valueOf(jsonObject.get("timezone"))));

        // cityname
        location.setName(String.valueOf(jsonObject.get("name")));
        return location;
    }

    private void buildAlertDialog_wrongLocationInput() {
        TextView dataOutput = activity.findViewById(R.id.txt_title);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Ungültige Eingabe");
        builder.setMessage("Ort nicht gefunden");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", (dialogInterface, i) -> {
            dataOutput.setText("");
            activity.findViewById(R.id.cardContainer).setVisibility(View.VISIBLE);
            dialogInterface.cancel();
        });
        builder.show();
    }
    //endregion

}
