package dk.tec.elevclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ElevService
{
    @GET("Elev/")
    Call<List<Elev>> getAllElever();

    @GET("Elev/{id}")
    Call<Elev> getElevById(@Path("id") int id);

    @POST("Elev/")
    Call<Void> addElev(@Body Elev e);
}
