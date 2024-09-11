package com.fermin2049.trabajopractico3.ui.carry;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fermin2049.trabajopractico3.databinding.FragmentCarryBinding;

import java.util.Calendar;

public class CarryFragment extends Fragment {

    private FragmentCarryBinding binding;
    private CarryViewModel carryViewModel;
    private final Calendar calendar = Calendar.getInstance();
    private EditText editTextEndDate, editTextCreationDate, editTextContent;
    private Button buttonSaveNote;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCarryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Enlazar los elementos de la vista
        editTextEndDate = binding.editTextEndDate;
        editTextCreationDate = binding.editTextCreationDate;
        editTextContent = binding.editTextContent;
        buttonSaveNote = binding.buttonSaveNote;

        // Obtener el ViewModel compartido
        carryViewModel = new ViewModelProvider(requireActivity()).get(CarryViewModel.class);

        // Mostrar el DatePickerDialog al hacer clic en editTextEndDate y editTextCreationDate
        editTextEndDate.setOnClickListener(v -> showDatePickerDialog(editTextEndDate));
        editTextCreationDate.setOnClickListener(v -> showDatePickerDialog(editTextCreationDate));

        // Acción del botón para guardar la nota
        buttonSaveNote.setOnClickListener(v -> {
            String content = editTextContent.getText().toString();
            String creationDateStr = editTextCreationDate.getText().toString();
            String endDateStr = editTextEndDate.getText().toString();

            // Delegar la creación de la nota al CarryViewModel
            carryViewModel.createAndAddNote(content, creationDateStr, endDateStr);
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
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(myFormat, java.util.Locale.US);
        editText.setText(sdf.format(calendar.getTime()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
