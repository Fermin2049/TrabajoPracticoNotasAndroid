package com.fermin2049.trabajopractico3.ui.carry;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.fermin2049.trabajopractico3.Model.Note;
import com.fermin2049.trabajopractico3.Model.NoteAdapter;
import com.fermin2049.trabajopractico3.databinding.FragmentCarryBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CarryFragment extends Fragment {

    private FragmentCarryBinding binding;
    private CarryViewModel carryViewModel;
    private final Calendar calendar = Calendar.getInstance();
    private NoteAdapter noteAdapter = null;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCarryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Obtener el ViewModel
        carryViewModel = new ViewModelProvider(this).get(CarryViewModel.class);

        carryViewModel.getNotes().observe(getViewLifecycleOwner(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {

                noteAdapter.submitList(notes);  // Asegúrate de actualizar la lista del adaptador
            }
        });

        // Referencias a los elementos de la vista
        EditText editTextContent = binding.editTextContent;
        EditText editTextCreationDate = binding.editTextCreationDate;
        EditText editTextEndDate = binding.editTextEndDate;
        Button buttonSaveNote = binding.buttonSaveNote;

        // Mostrar el DatePickerDialog al hacer clic en editTextCreationDate
        editTextCreationDate.setOnClickListener(v -> showDatePickerDialog(editTextCreationDate));

        // Mostrar el DatePickerDialog al hacer clic en editTextEndDate
        editTextEndDate.setOnClickListener(v -> showDatePickerDialog(editTextEndDate));

        // Acción del botón para guardar la nota
        buttonSaveNote.setOnClickListener(v -> {
            String content = editTextContent.getText().toString();
            String creationDateStr = editTextCreationDate.getText().toString();
            String endDateStr = editTextEndDate.getText().toString();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            try {
                Date creationDate = sdf.parse(creationDateStr);
                Date endDate = sdf.parse(endDateStr);

                // Crear y agregar la nueva nota al ViewModel
                Note newNote = new Note(content, creationDate, endDate);
                carryViewModel.addNote(newNote);  // Agrega la nota al ViewModel compartido
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        return root;
    }

    private void showDatePickerDialog(EditText editText) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                (view, year, monthOfYear, dayOfMonth) -> {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, monthOfYear);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel(editText);
                },
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void updateLabel(EditText editText) {
        String myFormat = "dd/MM/yyyy"; // Formato de fecha
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(sdf.format(calendar.getTime()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
