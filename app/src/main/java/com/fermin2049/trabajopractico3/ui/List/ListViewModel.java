package com.fermin2049.trabajopractico3.ui.List;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fermin2049.trabajopractico3.Model.Note;
import com.fermin2049.trabajopractico3.Model.NoteAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends AndroidViewModel {

    private final MutableLiveData<List<Note>> notes;

    public ListViewModel(@NonNull Application application) {
        super(application);
        // Inicializar la lista de notas
        notes = new MutableLiveData<>(new ArrayList<>());
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        List<Note> currentNotes = notes.getValue();
        if (currentNotes != null) {
            currentNotes.add(note);
            notes.setValue(new ArrayList<>(currentNotes));  // Crear una nueva lista para notificar a los observadores
        }
    }
}
