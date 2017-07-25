package info.arimateia.overwatchpocket.ui.maps;

import java.util.List;

import info.arimateia.overwatchpocket.repository.HerosRepository;
import info.arimateia.overwatchpocket.repository.MapsRepository;
import info.arimateia.overwatchpocket.ui.heros.IHerosPresenter;
import info.arimateia.overwatchpocket.vo.Map;

/**
 * Created by felipets on 7/18/17.
 */

public class MapsPresenter implements IMapsPresenter {

    private MapsView view;
    private MapsRepository repository;

    public MapsPresenter(MapsView view, MapsRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadMaps() {
        view.showLoading();

        repository.getMaps(new MapsRepository.Callback<List<Map>>() {
            @Override
            public void response(List<Map> result) {
                view.hideLoading();
                if (result != null) {
                    view.showMaps(result);
                }
            }
        });
    }
}
