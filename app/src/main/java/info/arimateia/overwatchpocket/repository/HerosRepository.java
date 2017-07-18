package info.arimateia.overwatchpocket.repository;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import info.arimateia.overwatchpocket.api.ApiResponse;
import info.arimateia.overwatchpocket.api.OverwatchService;
import info.arimateia.overwatchpocket.vo.Hero;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by felipets on 7/18/17.
 */

@Singleton
public class HerosRepository {

    private OverwatchService service;

    @Inject
    public HerosRepository(OverwatchService service) {
        this.service = service;
    }

    public void getHeros(@NonNull final Callback<List<Hero>> callback) {
        service.getHeros().enqueue(new retrofit2.Callback<ApiResponse<Hero>>() {
            @Override
            public void onResponse(Call<ApiResponse<Hero>> call, Response<ApiResponse<Hero>> response) {
                callback.response(response.body().getData());
            }

            @Override
            public void onFailure(Call<ApiResponse<Hero>> call, Throwable t) {
                callback.response(null);
            }
        });
    }


    public interface Callback<T> {
        void response(T result);
    }
}
