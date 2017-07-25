package info.arimateia.overwatchpocket.api;

import info.arimateia.overwatchpocket.vo.Hero;
import info.arimateia.overwatchpocket.vo.Map;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by felipets on 7/18/17.
 */

public interface OverwatchService {

    @GET("/api/v1/hero")
    Call<ApiResponse<Hero>> getHeros();

    @GET("/api/v1/map")
    Call<ApiResponse<Map>> getMaps();
}
