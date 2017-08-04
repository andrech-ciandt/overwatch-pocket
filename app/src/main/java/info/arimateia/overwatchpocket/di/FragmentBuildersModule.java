package info.arimateia.overwatchpocket.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import info.arimateia.overwatchpocket.ui.heros.HerosFragment;
import info.arimateia.overwatchpocket.ui.maps.MapsFragment;

/**
 * Created by felipets on 7/18/17.
 */

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = HerosModule.class)
    abstract HerosFragment contributeHerosFragment();

    @ContributesAndroidInjector(modules = MapsModule.class)
    abstract MapsFragment contributeMapsFragment();

}
