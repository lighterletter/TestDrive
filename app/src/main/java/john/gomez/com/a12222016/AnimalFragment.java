package john.gomez.com.a12222016;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by john on 12/21/16.
 */
public class AnimalFragment extends Fragment {

    private View root;
    private RecyclerView recyclerView;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.main_fragment, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = view.getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
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
                    List<Animal> animals = responseBody.getAnimals();

                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(new AnimalAdapter(animals));

                }

            }

            @Override
            public void onFailure(Call<JSONUtil> call, Throwable t) {

            }
        });
    }

}
