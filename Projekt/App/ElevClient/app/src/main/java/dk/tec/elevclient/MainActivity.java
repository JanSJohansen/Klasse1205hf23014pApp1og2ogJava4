package dk.tec.elevclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ElevService elevService = ServiceBuilder.buildService(ElevService.class);
        Call<Elev> request = elevService.getElevById(1001);
        request.enqueue(new Callback<Elev>() {
            @Override
            public void onResponse(Call<Elev> call, Response<Elev> response)
            {
               Elev elev =  response.body();
               Log.d("Der kom en elev: ", elev.getName());
            }

            @Override
            public void onFailure(Call<Elev> call, Throwable t)
            {
                Log.d("Jans Error: ", t.getMessage());
            }
        });
    }
}