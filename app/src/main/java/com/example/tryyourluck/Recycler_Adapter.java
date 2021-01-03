package com.example.tryyourluck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.ViewHolder> {
    private Context context;
    private List<roulets> notes;

    Recycler_Adapter(Context context, List<roulets> notes) {
            this.context = context;
            this.notes = notes;
        }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_info, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final roulets r = notes.get(position);

        holder.textViewNumber.setText(Integer.toString(r.ID));
        holder.textViewInfo.setText(r.STAVKA);
        holder.textViewDescription.setText(r.RESULT);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, Integer.toString(r.ID), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return notes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textViewNumber;
        final TextView textViewInfo;
        final TextView textViewDescription;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumber = itemView.findViewById(R.id.text_view_number);
            textViewInfo = itemView.findViewById(R.id.text_view_info);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
        }
    }
}
