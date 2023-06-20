package com.example.curemeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class R10_MainActivity_Fragment extends Fragment implements R10_SelectListener{

    private String myIP, userID;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main_r10, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        myIP = getArguments().getString("myIP");
        userID = getArguments().getString("userID");

        createItems(userID, myIP);
    }


    private void createItems(String patient_amka, String myIP){
        R10_RequestObject request = new R10_RequestObject(myIP);

        List<R10_HistoryItem> items;
        items = request.requestItems(patient_amka);

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getView().getContext()));
        recyclerView.setAdapter(new R10_HistoryViewAdapter(getView().getContext(), items, this));
    }

    @Override
    public void onItemClicked(Bundle bundle) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(((ViewGroup)getView().getParent()).getId(), R10_DetailsActivity_Fragment.class, bundle)
                .addToBackStack(null)
                .commit();
    }
}