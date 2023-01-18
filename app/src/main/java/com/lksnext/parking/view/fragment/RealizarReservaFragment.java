package com.lksnext.parking.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textview.MaterialTextView;
import com.lksnext.parking.R;
import com.lksnext.parking.databinding.FragmentRealizarReservaBinding;
import com.lksnext.parking.viewmodel.RealizarReservaViewModel;

public class RealizarReservaFragment extends Fragment {

    FragmentRealizarReservaBinding mFragmentRealizarReservaBinding;
    RealizarReservaViewModel viewModel;
    Button boton;

    public RealizarReservaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Create the binding instance by inflating the layout
        mFragmentRealizarReservaBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_realizar_reserva, container, false);
        //Set the fragment as the binding lifecycle owner
        mFragmentRealizarReservaBinding.setLifecycleOwner(getViewLifecycleOwner());

        //Get an instance of the AddViewModel using the fragment as the owner to retain the ViewModel
        viewModel = new ViewModelProvider(this).get(RealizarReservaViewModel.class);
        //Set the binding's viewModel variable
        mFragmentRealizarReservaBinding.setViewModel(viewModel);
        //Return the root view
        return mFragmentRealizarReservaBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        MaterialTextView numPlazaTextView = view.findViewById(R.id.numeroPlaza);
        int numeroPlaza = RealizarReservaFragmentArgs.fromBundle(getArguments()).getNumPlaza() + 1;
        numPlazaTextView.setText("Plaza Numero: " + numeroPlaza);


        Spinner horaInicio = view.findViewById(R.id.horaInicio);
        Spinner horaFin = view.findViewById(R.id.horaFin);
        boton = view.findViewById(R.id.botonReserva);
        horaInicioListener(horaInicio);
        horaFinListener(horaFin);
    }


    private void horaInicioListener(Spinner spinner){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setHoraInicio(parent.getItemAtPosition(position).toString());
                boton.setEnabled(viewModel.comprobarHora());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nothing to do
            }
        });
    }

    private void horaFinListener(Spinner spinner){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setHorafin(parent.getItemAtPosition(position).toString());
                boton.setEnabled(viewModel.comprobarHora());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nothing to do
            }
        });
    }
}
