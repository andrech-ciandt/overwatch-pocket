package info.arimateia.overwatchpocket.ui.heros;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import info.arimateia.overwatchpocket.R;
import info.arimateia.overwatchpocket.di.Injectable;
import info.arimateia.overwatchpocket.vo.Hero;

/**
 * Created by felipets on 7/18/17.
 */

public class HerosFragment extends Fragment implements HerosView, Injectable{


    @Inject
    IHerosPresenter presenter;

    private RecyclerView listHeros;
    private HerosAdapter adapter;

    public static HerosFragment newInstance() {
        HerosFragment fragment = new HerosFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_heros, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listHeros = (RecyclerView)view.findViewById(R.id.list_heros);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        listHeros.setLayoutManager(layoutManager);
        adapter = new HerosAdapter(new ArrayList<Hero>());
        listHeros.setAdapter(adapter);

        presenter.loadHeros();
    }

    @Override
    public void showHeros(List<Hero> heros) {
        adapter.addAll(heros);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
