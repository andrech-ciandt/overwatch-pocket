package info.arimateia.overwatchpocket.di;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import info.arimateia.overwatchpocket.repository.MapsRepository;
import info.arimateia.overwatchpocket.ui.maps.IMapsPresenter;
import info.arimateia.overwatchpocket.ui.maps.MapsFragment;
import info.arimateia.overwatchpocket.ui.maps.MapsPresenter;
import info.arimateia.overwatchpocket.ui.maps.MapsView;

/**
 * Created by felipets on 7/18/17.
 */

@Module
public abstract class MapsModule {

    @Binds
    abstract MapsView provideHehoresView(MapsFragment mapsFragment);

    @Provides
    public static IMapsPresenter provideIMapsPresenter(MapsView mapsView, MapsRepository repository) {
        return new MapsPresenter(mapsView, repository);
    }
}
