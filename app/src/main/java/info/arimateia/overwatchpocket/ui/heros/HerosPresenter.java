package info.arimateia.overwatchpocket.ui.heros;

import java.util.List;

import javax.inject.Inject;

import info.arimateia.overwatchpocket.repository.HerosRepository;
import info.arimateia.overwatchpocket.vo.Hero;

/**
 * Created by felipets on 7/18/17.
 */

public class HerosPresenter implements IHerosPresenter {

    private HerosView view;
    private HerosRepository repository;

    @Inject
    public HerosPresenter(HerosView view, HerosRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadHeros() {
        view.showLoading();

        repository.getHeros(new HerosRepository.Callback<List<Hero>>() {
            @Override
            public void response(List<Hero> result) {
                view.hideLoading();

                if (result != null) {
                    view.showHeros(result);
                }
            }
        });
    }
}
