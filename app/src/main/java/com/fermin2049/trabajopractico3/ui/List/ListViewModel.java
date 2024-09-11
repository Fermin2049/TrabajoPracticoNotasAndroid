package com.fermin2049.trabajopractico3.ui.List;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fermin2049.trabajopractico3.Model.Note;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends AndroidViewModel {

    private MutableLiveData<List<Note>> notes;

    public ListViewModel(@NonNull Application application) {
        super(application);
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