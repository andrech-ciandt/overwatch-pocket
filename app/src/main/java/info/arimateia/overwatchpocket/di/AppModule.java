package info.arimateia.overwatchpocket.di;

import android.app.Application;
import android.content.Context;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import info.arimateia.overwatchpocket.api.OverwatchService;
import info.arimateia.overwatchpocket.utils.OverwatchUtils;
import info.arimateia.overwatchpocket.vo.Photo;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by felipets on 7/18/17.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://overwatch-api.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public OverwatchService provideService(Retrofit retrofit) {
        return retrofit.create(OverwatchService.class);
    }

    @Provides
    @Singleton
    @Named("heros")
    public List<Photo> provideHerosPhotos(Context context) {
        return OverwatchUtils.readHerosPhotos(context);
    }

    @Provides
    @Singleton
    public Context provideContext(Application application) {
        return application;
    }
}
