package info.arimateia.overwatchpocket.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import info.arimateia.overwatchpocket.OverwatchApp;

/**
 * Created by felipets on 7/18/17.
 */
@Singleton
@Component(modules = {AppModule.class, AndroidInjectionModule.class, MainActivityModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }

    void inject(OverwatchApp overwatchApp);
}
