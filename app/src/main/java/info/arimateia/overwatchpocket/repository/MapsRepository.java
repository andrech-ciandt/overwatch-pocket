package info.arimateia.overwatchpocket.repository;

import android.support.annotation.NonNull;

import java.util.List;

import info.arimateia.overwatchpocket.api.ApiResponse;
import info.arimateia.overwatchpocket.api.OverwatchService;
import info.arimateia.overwatchpocket.vo.Map;
import info.arimateia.overwatchpocket.vo.Photo;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by felipets on 7/18/17.
 */

public class MapsRepository {

    private final OverwatchService service;
    private final List<Photo> photos;


    public MapsRepository(OverwatchService service, List<Photo> photos) {
        this.service = service;
        this.photos = photos;
    }

    public void getMaps(@NonNull final Callback<List<Map>> callback) {
        service.getMaps().enqueue(new retrofit2.Callback<ApiResponse<Map>>() {
            @Override
            public void onResponse(Call<ApiResponse<Map>> call, Response<ApiResponse<Map>> response) {
                List<Map> maps = response.body().getData();
                addPhoto(maps);
                callback.response(maps);
            }

            @Override
            public void onFailure(Call<ApiResponse<Map>> call, Throwable t) {
                callback.response(null);
            }
        });
    }


    private void addPhoto(List<Map> maps) {
        for (Map map : maps) {
            addPhoto(map);
        }
    }

    private void addPhoto(Map map) {
        for (Photo photo : photos) {
            if (photo.getId() == map.getId()) {
                map.setPictures(photo);
                break;
            }
        }
    }


    public interface Callback<T> {
        void response(T result);
    }
}
