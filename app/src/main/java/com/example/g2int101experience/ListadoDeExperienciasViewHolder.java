package com.example.g2int101experience;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class ListadoDeExperienciasViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public ListadoDeExperienciasViewHolder(@NotNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tvTituloExperiencia);
    }
}
