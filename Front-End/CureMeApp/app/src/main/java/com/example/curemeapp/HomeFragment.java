package com.example.curemeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class HomeFragment extends Fragment implements SelectListener {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        String amka = "123456789";
        createEvents(amka, view);







        // Inflate the layout for this fragment
        return view;

    }

    private void createEvents(String patient_amka, View view) {
        RequestHandler request = new RequestHandler();
        List<Event> events;
        events = request.requestUpcomingVisits(patient_amka);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new UpcomingVisitAdapter(getContext(), events, this));

    }

    @Override
    public void onItemClicked(Bundle bundle) {
//        FragmentManager fragmentManager = getChildFragmentManager();
//
//
//        fragmentManager.beginTransaction()
//                .replace(getView().getId(), VisitDetailsFragment.class, bundle)
//                .setReorderingAllowed(true)
//                .addToBackStack("name")
//                .commit();


        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(((ViewGroup)getView().getParent()).getId(), VisitDetailsFragment.class, bundle)
                .addToBackStack(null)
                .commit();



    }
}