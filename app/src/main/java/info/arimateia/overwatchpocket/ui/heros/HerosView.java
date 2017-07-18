package info.arimateia.overwatchpocket.ui.heros;

import java.util.List;

import info.arimateia.overwatchpocket.vo.Hero;

/**
 * Created by felipets on 7/18/17.
 */

public interface HerosView {

    void showHeros(List<Hero> heros);
    void showLoading();
    void hideLoading();
}
