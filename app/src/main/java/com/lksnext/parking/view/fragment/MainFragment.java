package com.lksnext.parking.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;
import com.lksnext.parking.R;


public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Find the next button view
        MaterialButton next = view.findViewById(R.id.btn_next);
        //Add click listener to next button
        next.setOnClickListener(this::onNextClicked);
    }

    private void onNextClicked(View view) {
        //Navigate to Step1 fragment
        NavDirections action = MainFragmentDirections.actionMainFragmentToFragmentReserva();
        Navigation.findNavController(view).navigate(action);
    }
}