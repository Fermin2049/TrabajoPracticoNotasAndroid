package com.fermin2049.trabajopractico3.ui.carry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fermin2049.trabajopractico3.Model.Note;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CarryViewModel extends ViewModel {

    private final MutableLiveData<List<Note>> notes;
    private final SimpleDateFormat dateFormat;

    public CarryViewModel() {
        notes = new MutableLiveData<>(new ArrayList<>());
        dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }

    public void createAndAddNote(String content, String creationDateStr, String endDateStr) {
        try {
            Date creationDate = dateFormat.parse(creationDateStr);
            Date endDate = dateFormat.parse(endDateStr);

            // Crear una nueva nota
            Note newNote = new Note(content, creationDate, endDate);
            addNote(newNote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNote(Note note) {
        List<Note> currentNotes = notes.getValue();
        if (currentNotes != null) {
            currentNotes.add(note);
            updateNoteColors(currentNotes); // Actualizar los colores de las notas
            notes.setValue(currentNotes);
        }
    }

    private void updateNoteColors(List<Note> currentNotes) {
        Date currentDatePlusFive = getCurrentDatePlusFiveDays();
        for (Note note : currentNotes) {
            if (note.getEndDate().before(currentDatePlusFive) || note.getEndDate().equals(currentDatePlusFive)) {
                note.setColor("red"); // Cambiar color de la nota a rojo
            } else {
                note.setColor("green"); // Color normal
            }
        }
    }

    private Date getCurrentDatePlusFiveDays() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5); // Obtener la fecha 5 días a partir de hoy
        return calendar.getTime();
    }
}
