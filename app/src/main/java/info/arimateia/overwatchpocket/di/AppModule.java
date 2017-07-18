package info.arimateia.overwatchpocket.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import info.arimateia.overwatchpocket.api.OverwatchService;
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
}
