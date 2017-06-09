package com.maplist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.maplist.R;
import com.maplist.adapter.RecyclerAdapter;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearPlaceListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public static NearPlaceListFragment getInstance(ArrayList<String> list) {
        NearPlaceListFragment nearPlaceListFragment = new NearPlaceListFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("list", list);
        nearPlaceListFragment.setArguments(bundle);
        return nearPlaceListFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_data, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        setRecyclerView(getArguments().getStringArrayList("list"));
    }

    private void setRecyclerView(ArrayList<String> stringArrayList) {

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(stringArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(recyclerAdapter);
    }
}
