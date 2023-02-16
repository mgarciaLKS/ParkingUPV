package com.lksnext.parking.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.lksnext.parking.R;
import com.lksnext.parking.adapter.ReservasAdapter;
import com.lksnext.parking.databinding.FragmentVerReservaBinding;
import com.lksnext.parking.model.Plaza;
import com.lksnext.parking.model.Reserva;
import com.lksnext.parking.viewmodel.MainViewModel;
import com.lksnext.parking.viewmodel.ReservaViewModel;

import java.util.List;

public class VerReservaFragment extends Fragment {

    final int NUMEROPLAZAS = 9;

    FragmentVerReservaBinding mFragmentVerReservaBinding;
    RecyclerView reservasRV;
    ReservasAdapter reservasAdapter;
    Button boton;
    MainViewModel mMainViewModel;
    Integer numeroPlaza;

    public VerReservaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Create the binding instance by inflating the layout
        mFragmentVerReservaBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_ver_reserva, container, false);
        //Set the fragment as the binding lifecycle owner
        mFragmentVerReservaBinding.setLifecycleOwner(getViewLifecycleOwner());

        //MainViewModel
        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        //Asign the recycler view to the one in the layaut
        reservasRV = mFragmentVerReservaBinding.reservasRV;
        reservasRV.setLayoutManager((new LinearLayoutManager(getActivity())));

        numeroPlaza  = RealizarReservaFragmentArgs.fromBundle(getArguments()).getNumPlaza();
        //Prepare the adapter
        reservasAdapter = new ReservasAdapter();
        //AÑADIR AL CONSTRUCTOR
        reservasAdapter.setReservasList(getReservasPlaza(numeroPlaza));

        //Asing the adapter to the recyclerView
        reservasRV.setAdapter(reservasAdapter);


        //Return the root view
        return mFragmentVerReservaBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialButton next = view.findViewById(R.id.reservar);
        next.setOnClickListener(this::onNextClicked);
    }

    private void onNextClicked(View view) {
        //Navigate to Step1 fragment
        NavDirections action =
            VerReservaFragmentDirections.actionFragmentVerReservaToRealizarReserva(numeroPlaza);
        Navigation.findNavController(view).navigate(action);
    }

    private List<Reserva> getReservasPlaza(Integer numPLaza) {
        Plaza plaza = mMainViewModel.getPlazas().get(numPLaza);
        return plaza.reservas;
    }
}