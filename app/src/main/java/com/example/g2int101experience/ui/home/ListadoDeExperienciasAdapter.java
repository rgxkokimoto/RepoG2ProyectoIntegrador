package com.example.g2int101experience.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.g2int101experience.ui.home.ListadoDeExperienciasViewHolder;
import com.example.g2int101experience.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListadoDeExperienciasAdapter extends RecyclerView.Adapter<ListadoDeExperienciasViewHolder> {
    private List<String> lista;

    public ListadoDeExperienciasAdapter(List<String> lista) {
        this.lista = lista;
    }

    @NotNull
    @Override
    public ListadoDeExperienciasViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout, parent, false);
        return new ListadoDeExperienciasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull ListadoDeExperienciasViewHolder holder, int position) {
        holder.textView.setText(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
