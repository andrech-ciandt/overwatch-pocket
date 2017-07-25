package info.arimateia.overwatchpocket.ui.maps;

import java.util.List;

import info.arimateia.overwatchpocket.vo.Hero;
import info.arimateia.overwatchpocket.vo.Map;

/**
 * Created by felipets on 7/18/17.
 */

public interface MapsView {

    void showMaps(List<Map> maps);
    void showLoading();
    void hideLoading();
}
