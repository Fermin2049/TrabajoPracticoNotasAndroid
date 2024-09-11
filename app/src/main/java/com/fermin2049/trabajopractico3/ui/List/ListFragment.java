package com.fermin2049.trabajopractico3.ui.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fermin2049.trabajopractico3.Model.Note;
import com.fermin2049.trabajopractico3.Model.NoteAdapter;
import com.fermin2049.trabajopractico3.databinding.FragmentListBinding;
import com.fermin2049.trabajopractico3.ui.carry.CarryViewModel;

import java.util.List;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private CarryViewModel carryViewModel;
    private NoteAdapter noteAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Inicializar el ViewModel compartido del CarryFragment
        carryViewModel = new ViewModelProvider(requireActivity()).get(CarryViewModel.class);

        // Inicializar el adaptador con el contexto actual
        noteAdapter = new NoteAdapter(getContext());

        // Configurar RecyclerView
        RecyclerView recyclerView = binding.recyclerViewNotes;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(noteAdapter);  // Asignar el adaptador al RecyclerView

        // Observar cambios en las notas a través del CarryViewModel
        carryViewModel.getNotes().observe(getViewLifecycleOwner(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                if (noteAdapter != null) {
                    noteAdapter.submitList(notes);  // Actualizar el adaptador con la lista de notas
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}