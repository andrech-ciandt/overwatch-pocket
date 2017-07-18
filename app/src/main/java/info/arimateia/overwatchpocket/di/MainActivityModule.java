package info.arimateia.overwatchpocket.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import info.arimateia.overwatchpocket.MainActivity;

/**
 * Created by felipets on 7/18/17.
 */

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class})
    abstract MainActivity contributeMainActivity();
}
