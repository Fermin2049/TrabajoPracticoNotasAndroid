package com.fermin2049.trabajopractico3.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fermin2049.trabajopractico3.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolderNote> {

    private List<Note> notes;
    private LayoutInflater li;

    // Constructor mejorado
    public NoteAdapter(Context context) {
        this.notes = new ArrayList<>();
        this.li = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public ViewHolderNote onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.note_item, parent, false);
        return new ViewHolderNote(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNote holder, int position) {
        Note note = notes.get(position);
        holder.tvContent.setText(note.getContent());
        holder.tvCreationDate.setText(note.getCreationDate().toString());
        holder.tvEndDate.setText(note.getEndDate().toString());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    // Método para actualizar la lista de notas
    public void submitList(List<Note> newNotes) {
        this.notes.clear();
        this.notes.addAll(newNotes);
        notifyDataSetChanged();
    }

    public static class ViewHolderNote extends RecyclerView.ViewHolder {

        TextView tvContent, tvCreationDate, tvEndDate;

        public ViewHolderNote(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.textContent);
            tvCreationDate = itemView.findViewById(R.id.textCreationDate);
            tvEndDate = itemView.findViewById(R.id.textEndDate);
        }
    }
}
