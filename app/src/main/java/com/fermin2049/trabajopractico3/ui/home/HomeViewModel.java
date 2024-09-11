package com.fermin2049.trabajopractico3.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fermin2049.trabajopractico3.Model.Note;
import com.fermin2049.trabajopractico3.ui.carry.CarryViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<Integer> notesInTime;
    private final MutableLiveData<Integer> notesNearDeadline;
    private final CarryViewModel carryViewModel;

    public HomeViewModel(CarryViewModel carryViewModel) {
        this.carryViewModel = carryViewModel;
        notesInTime = new MutableLiveData<>(0);
        notesNearDeadline = new MutableLiveData<>(0);
        calculateNotesStatus();
    }

    public LiveData<Integer> getNotesInTime() {
        return notesInTime;
    }

    public LiveData<Integer> getNotesNearDeadline() {
        return notesNearDeadline;
    }

    private void calculateNotesStatus() {
        carryViewModel.getNotes().observeForever(notes -> {
            int inTimeCount = 0;
            int nearDeadlineCount = 0;

            for (Note note : notes) {
                if ("red".equals(note.getColor())) {
                    nearDeadlineCount++;
                } else if ("green".equals(note.getColor())) {
                    inTimeCount++;
                }
            }

            notesInTime.setValue(inTimeCount);
            notesNearDeadline.setValue(nearDeadlineCount);
        });
    }
}