package com.lksnext.parking.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.android.material.textview.MaterialTextView;
import com.lksnext.parking.R;
import com.lksnext.parking.databinding.FragmentRealizarReservaBinding;
import com.lksnext.parking.model.Reserva;
import com.lksnext.parking.viewmodel.MainViewModel;
import com.lksnext.parking.viewmodel.RealizarReservaViewModel;

public class RealizarReservaFragment extends Fragment {

    FragmentRealizarReservaBinding mFragmentRealizarReservaBinding;
    RealizarReservaViewModel viewModel;
    MainViewModel mMainViewModel;
    Reserva reserva = new Reserva();
    Button boton;
    EditText usuario;
    int numeroPlaza;

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

        //MainViewModel
        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        //Get an instance of the AddViewModel using the fragment as the owner to retain the ViewModel
        viewModel = new ViewModelProvider(this).get(RealizarReservaViewModel.class);
        //Set the binding's viewModel variable
        mFragmentRealizarReservaBinding.setViewModel(viewModel);
        //Return the root view
        return mFragmentRealizarReservaBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        numeroPlaza = RealizarReservaFragmentArgs.fromBundle(getArguments()).getNumPlaza() + 1;
        MaterialTextView numPlazaTextView = view.findViewById(R.id.numeroPlaza);
        numPlazaTextView.setText("Plaza Numero: " + numeroPlaza);

        usuario = view.findViewById(R.id.username);
        Spinner horaInicio = view.findViewById(R.id.horaInicio);
        Spinner horaFin = view.findViewById(R.id.horaFin);
        boton = view.findViewById(R.id.botonReserva);
        horaInicioListener(horaInicio);
        horaFinListener(horaFin);

        boton.setOnClickListener(this::onNextClicked);
    }


    private void onNextClicked(View view) {
        reserva.setNombreUsuario(usuario.getText().toString());
        mMainViewModel.añadirReserva(numeroPlaza - 1, reserva);
        NavDirections action = RealizarReservaFragmentDirections.actionFragmentRealizarReservaToReserva();
        Navigation.findNavController(view).navigate(action);
    }

    private void horaInicioListener(Spinner spinner){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setHoraInicio(parent.getItemAtPosition(position).toString());
                reserva.setHoraInicio(parent.getItemAtPosition(position).toString());
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
                reserva.setHoraFin(parent.getItemAtPosition(position).toString());
                boton.setEnabled(viewModel.comprobarHora());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nothing to do
            }
        });
    }
}
