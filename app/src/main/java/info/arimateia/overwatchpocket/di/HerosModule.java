package info.arimateia.overwatchpocket.di;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import info.arimateia.overwatchpocket.repository.HerosRepository;
import info.arimateia.overwatchpocket.ui.heros.HerosFragment;
import info.arimateia.overwatchpocket.ui.heros.HerosPresenter;
import info.arimateia.overwatchpocket.ui.heros.HerosView;
import info.arimateia.overwatchpocket.ui.heros.IHerosPresenter;

/**
 * Created by felipets on 7/18/17.
 */

@Module
public abstract class HerosModule {

    @Binds
    abstract HerosView provideHehoresView(HerosFragment herosFragment);

    @Provides
    public static IHerosPresenter provideIHerosPresenter(HerosView herosView, HerosRepository repository) {
        return new HerosPresenter(herosView, repository);
    }
}
