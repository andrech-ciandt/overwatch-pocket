package info.arimateia.overwatchpocket.ui.maps;

import android.app.ProgressDialog;
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
import info.arimateia.overwatchpocket.ui.heros.IHerosPresenter;
import info.arimateia.overwatchpocket.vo.Map;

/**
 * Created by felipets on 7/18/17.
 */

public class MapsFragment extends Fragment implements MapsView, Injectable{

    MapsPresenter presenter;

    private RecyclerView listMaps;
    private MapsAdapter adapter;
    private ProgressDialog progressDialog;

    public static MapsFragment newInstance() {
        MapsFragment fragment = new MapsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listMaps = (RecyclerView)view.findViewById(R.id.list_maps);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        listMaps.setLayoutManager(layoutManager);
        adapter = new MapsAdapter(new ArrayList<Map>());
        listMaps.setAdapter(adapter);

        presenter.loadMaps();
    }

    @Override
    public void showMaps(List<Map> maps) {
        adapter.addAll(maps);
    }

    @Override
    public void showLoading() {
        progressDialog = ProgressDialog.show(getContext(), getString(R.string.app_name), "Carregando...");
         progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
