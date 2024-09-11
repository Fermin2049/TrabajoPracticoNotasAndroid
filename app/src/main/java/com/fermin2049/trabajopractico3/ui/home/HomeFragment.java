package com.fermin2049.trabajopractico3.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fermin2049.trabajopractico3.databinding.FragmentHomeBinding;
import com.fermin2049.trabajopractico3.ui.carry.CarryViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CarryViewModel carryViewModel = new ViewModelProvider(requireActivity()).get(CarryViewModel.class);
        homeViewModel = new HomeViewModel(carryViewModel); // Pasar el CarryViewModel a HomeViewModel

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeViewModel.getNotesInTime().observe(getViewLifecycleOwner(), count -> {
            binding.textNotesInTime.setText("Notas en Tiempo: " + count);
        });

        homeViewModel.getNotesNearDeadline().observe(getViewLifecycleOwner(), count -> {
            binding.textNotesNearDeadline.setText("Notas por Vencer: " + count);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}