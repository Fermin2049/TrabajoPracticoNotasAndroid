package com.fermin2049.trabajopractico3.ui.carry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fermin2049.trabajopractico3.Model.Note;

import java.util.ArrayList;
import java.util.List;

public class CarryViewModel extends ViewModel {

    private final MutableLiveData<List<Note>> notes;

    public CarryViewModel() {
        notes = new MutableLiveData<>(new ArrayList<>());
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        List<Note> currentNotes = notes.getValue();
        if (currentNotes != null) {
            currentNotes.add(note);
            notes.setValue(currentNotes);
        }
    }
}