package com.lksnext.parking.view.fragment;

import static com.lksnext.parking.utils.PlazasGenerator.numeroPlazas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.lksnext.parking.adapter.ParkingAdapter;
import com.lksnext.parking.databinding.FragmentReservaBinding;
import com.lksnext.parking.model.Plaza;
import com.lksnext.parking.view.activity.MainActivity;
import com.lksnext.parking.viewmodel.MainViewModel;
import com.lksnext.parking.viewmodel.ReservaViewModel;
import com.lksnext.parking.utils.PlazasGenerator;

import java.util.ArrayList;
import java.util.List;

public class ReservaFragment extends Fragment {
    FragmentReservaBinding mFragmentReservaBindingBinding;
    ReservaViewModel viewModel;
    MainViewModel mMainViewModel;
    RecyclerView parkingRV;
    ParkingAdapter parkingAdapter;
    List<Plaza> plazas;

    public ReservaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Create the binding instance by inflating the layout
        mFragmentReservaBindingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_reserva, container, false);
        //Set the fragment as the binding lifecycle owner
        mFragmentReservaBindingBinding.setLifecycleOwner(getViewLifecycleOwner());

        //Asign the recycler view to the one in the layaut
        parkingRV = mFragmentReservaBindingBinding.parkingRV;
        parkingRV.setLayoutManager((new LinearLayoutManager(getActivity())));

        //MainViewModel
        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        plazas = mMainViewModel.getPlazas();

        //Prepare the adapter
        parkingAdapter = new ParkingAdapter(this::onClicked);
        mMainViewModel.setPLazas(plazas);
        //AÑADIR AL CONSTRUCTOR
        parkingAdapter.setPlazasList(plazas);

        //Asing the adapter to the recyclerView
        parkingRV.setAdapter(parkingAdapter);

        //Get an instance of the MainViewModel using the activity as the owner to retain the ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(ReservaViewModel.class);

        //Set the binding's viewModel variable
        mFragmentReservaBindingBinding.setViewModel(viewModel);

        //Return the root view
        return mFragmentReservaBindingBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void onClicked(View view, Integer position, Boolean vacio) {
        NavDirections action;
        if (vacio) {
            action = ReservaFragmentDirections.actionFragmentReservaToRealizarReserva(position);
        } else {
            action = ReservaFragmentDirections.actionFragmentReservaToVerReserva(position);
        }
        Navigation.findNavController(view).navigate(action);
    }
}