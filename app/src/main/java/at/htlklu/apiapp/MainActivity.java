package at.htlklu.apiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import at.htlklu.apiapp.services.Constants;
import at.htlklu.apiapp.services.WeatherDataParser;

public class MainActivity extends AppCompatActivity {

    EditText txt_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_location = findViewById(R.id.txt_locationInput);
    }

    public void downloadButtonPressed(View view) {
            WeatherDataParser task = new WeatherDataParser(this);
            task.execute(Constants.URL,
                    Constants.API_KEY,
                    "q=" + txt_location.getText().toString(),
                    Constants.UNITS_METRIC,
                    Constants.LANG_DE);
    }
}