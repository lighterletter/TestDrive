package john.gomez.com.a12222016;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIService {

    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<JSONUtil> getResponse();
}
