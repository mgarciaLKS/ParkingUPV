package com.lksnext.parking.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lksnext.parking.R;
import com.lksnext.parking.databinding.FragmentReservaBinding;
import com.lksnext.parking.viewmodel.MainViewModel;
import com.lksnext.parking.viewmodel.ReservaViewModel;

public class ReservaFragment extends Fragment {

    FragmentReservaBinding mFragmentReservaBindingBinding;
    ReservaViewModel viewModel;

    public ReservaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Create the binding instance by inflating the layout
        mFragmentReservaBindingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_reserva, container, false);
        //Set the fragment as the binding lifecycle owner
        mFragmentReservaBindingBinding.setLifecycleOwner(getViewLifecycleOwner());

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
}