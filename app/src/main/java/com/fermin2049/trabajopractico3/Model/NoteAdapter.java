package com.fermin2049.trabajopractico3.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.fermin2049.trabajopractico3.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolderNote> {

    private List<Note> notes;
    private final LayoutInflater li;
    private final SimpleDateFormat dateFormat;

    public NoteAdapter(Context context) {
        this.li = LayoutInflater.from(context);
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
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

        // Configurar los textos de los TextViews
        holder.tvContent.setText(note.getContent());
        holder.tvCreationDate.setText(dateFormat.format(note.getCreationDate()));
        holder.tvEndDate.setText(dateFormat.format(note.getEndDate()));

        // Cambiar el color de fondo según el estado de la nota
        if ("red".equals(note.getColor())) {
            holder.cardView.setCardBackgroundColor(holder.cardView.getResources().getColor(R.color.red)); // Obtener color como entero
        } else {
            holder.cardView.setCardBackgroundColor(holder.cardView.getResources().getColor(R.color.green)); // Obtener color como entero
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    // Método para actualizar la lista de notas
    public void submitList(List<Note> newNotes) {
        this.notes = newNotes;
        notifyDataSetChanged();
    }

    public static class ViewHolderNote extends RecyclerView.ViewHolder {

        TextView tvContent, tvCreationDate, tvEndDate;
        CardView cardView;

        public ViewHolderNote(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.textContent);
            tvCreationDate = itemView.findViewById(R.id.textCreationDate);
            tvEndDate = itemView.findViewById(R.id.textEndDate);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
