package at.htlklu.apiapp.services;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.widget.EditText;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import at.htlklu.apiapp.MainActivity;
import at.htlklu.apiapp.R;

public class AsyncLocation extends AsyncTask<String, Integer, AsyncLocation> {

    private MainActivity activity;
    FusedLocationProviderClient fusedLocationProviderClient;

    public AsyncLocation(MainActivity activity) {
        this.activity = activity;
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity);
    }

    @Override
    protected AsyncLocation doInBackground(String... strings) {
        if (ContextCompat.checkSelfPermission(this.activity,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<android.location.Location>() {
                @Override
                public void onSuccess(android.location.Location location) {
                    if (location != null) {
                        Geocoder geocoder = new Geocoder(activity, Locale.getDefault());
                        try {
                            List<Address> fromLocation = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                            String locality = fromLocation.get(0).getLocality();
                            EditText txt_locationInput = activity.findViewById(R.id.txt_locationInput);
                            txt_locationInput.setText(locality);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } else {
            askPremission();
        }
        return null;
    }

    private void askPremission() {
        int REQUEST_CODE = 100;
        ActivityCompat.requestPermissions(this.activity, new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
    }
}
