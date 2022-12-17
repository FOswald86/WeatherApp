package at.htlklu.apiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import at.htlklu.apiapp.services.Constants;
import at.htlklu.apiapp.services.AsyncLocation;
import at.htlklu.apiapp.services.AsyncParseWeatherNow;

public class MainActivity extends AppCompatActivity {

    EditText txt_locationInput;
    AsyncLocation asyncLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_locationInput = findViewById(R.id.txt_locationInput);
        asyncLocation = new AsyncLocation(this);
        asyncLocation.execute();

    }

    public void downloadButtonPressed(View view) {
        AsyncParseWeatherNow task = new AsyncParseWeatherNow(this);
        task.execute(Constants.URL,
                Constants.API_KEY,
                "q=" + txt_locationInput.getText().toString(),
                Constants.UNITS_METRIC,
                Constants.LANG_DE);
    }
}