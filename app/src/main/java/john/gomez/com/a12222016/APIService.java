package john.gomez.com.a12222016;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by john on 12/21/16.
 */

public interface APIService {

    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<ResponseBody> getResponse();
}
