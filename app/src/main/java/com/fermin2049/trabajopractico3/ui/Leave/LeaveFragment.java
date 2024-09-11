package com.fermin2049.trabajopractico3.ui.Leave;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.fermin2049.trabajopractico3.R;
import com.fermin2049.trabajopractico3.databinding.FragmentLeaveBinding;

public class LeaveFragment extends Fragment {

    private FragmentLeaveBinding binding;

    public static LeaveFragment newInstance() {
        return new LeaveFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLeaveBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Configurar el botón de salida con un diálogo de confirmación
        binding.btSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExitConfirmationDialog();
            }
        });

        // Configurar el menú
        MenuHost menuHost = requireActivity();
        menuHost.addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.bottom_nav_menu, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_leave) {
                    showExitConfirmationDialog();
                    return true;
                }
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void showExitConfirmationDialog() {
        // Mostrar un cuadro de diálogo para confirmar la salida
        new AlertDialog.Builder(requireContext())
                .setTitle("Confirmación de salida")
                .setMessage("¿Estás seguro de que deseas salir de la aplicación?")
                .setPositiveButton("Sí", (dialog, which) -> exitApp())
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void exitApp() {
        // Cerrar la aplicación
        requireActivity().finishAffinity();
        System.exit(0);
    }
}