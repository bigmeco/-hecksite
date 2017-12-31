import android.database.Observable;

import retrofit2.http.GET;

/**
 * Created by bigi on 31.12.2017.
 */

public interface Zapros {
    @GET("dnevnik/login")
    Observable<String> getLog();
}
