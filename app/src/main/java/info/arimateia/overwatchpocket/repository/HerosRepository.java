package info.arimateia.overwatchpocket.repository;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import info.arimateia.overwatchpocket.api.ApiResponse;
import info.arimateia.overwatchpocket.api.OverwatchService;
import info.arimateia.overwatchpocket.vo.Hero;
import info.arimateia.overwatchpocket.vo.Photo;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by felipets on 7/18/17.
 */

@Singleton
public class HerosRepository {

    private final OverwatchService service;
    private final List<Photo> photos;

    @Inject
    public HerosRepository(OverwatchService service, @Named("heros") List<Photo> photos) {
        this.service = service;
        this.photos = photos;
    }

    public void getHeros(@NonNull final Callback<List<Hero>> callback) {
        service.getHeros().enqueue(new retrofit2.Callback<ApiResponse<Hero>>() {
            @Override
            public void onResponse(Call<ApiResponse<Hero>> call, Response<ApiResponse<Hero>> response) {
                List<Hero> heros = response.body().getData();
                addPhoto(heros);
                callback.response(heros);
            }

            @Override
            public void onFailure(Call<ApiResponse<Hero>> call, Throwable t) {
                callback.response(null);
            }
        });
    }


    private void addPhoto(List<Hero> heros) {
        for (Hero hero : heros) {
            addPhoto(hero);
        }
    }

    private void addPhoto(Hero hero) {
        for (Photo photo : photos) {
            if (photo.getId() == hero.getId()) {
                hero.setPictures(photo);
                break;
            }
        }
    }


    public interface Callback<T> {
        void response(T result);
    }
}
