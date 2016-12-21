package john.gomez.com.a12222016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Call";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeNetworkCall();
    }

    public void makeNetworkCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<JSONUtil> call = service.getResponse();

        call.enqueue(new Callback<JSONUtil>() {
            @Override
            public void onResponse(Call<JSONUtil> call, Response<JSONUtil> response) {

                if (response.isSuccessful()) {
                    JSONUtil responseBody = response.body();
                    int size = responseBody.getAnimals().size();
                    Log.d(TAG, "onResponse: " + size);
                }

            }

            @Override
            public void onFailure(Call<JSONUtil> call, Throwable t) {

            }
        });
    }

}
