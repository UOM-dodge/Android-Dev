package com.example.curemeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class HomeFragment_R9 extends Fragment implements SelectListener_R9 {



    private String myIP, patient_amka;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_r9, container, false);

        assert getArguments() != null;
        myIP = getArguments().getString("myIP");
        patient_amka = getArguments().getString("userID");


        createEvents(patient_amka, view);







        // Inflate the layout for this fragment
        return view;

    }

    private void createEvents(String patient_amka, View view) {
        RequestHandle_R9 request = new RequestHandle_R9(myIP);
        List<Event_R9> events;
        events = request.requestUpcomingVisits(patient_amka);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new UpcomingVisitAdapter_R9(getContext(), events, this));

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
                .replace(((ViewGroup)getView().getParent()).getId(), VisitDetailsFragment_R9.class, bundle)
                .addToBackStack(null)
                .commit();



    }


}