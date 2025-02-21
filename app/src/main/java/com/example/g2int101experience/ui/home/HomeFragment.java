package com.example.g2int101experience.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g2int101experience.R;
import com.example.g2int101experience.databinding.ActivityPrubButtonNavigationBinding;
import com.example.g2int101experience.databinding.FragmentHomeBinding;
import com.example.g2int101experience.models.Desafio;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private ListDesafiosAdapter adapter;

    private List<Desafio> userList;

    private RecyclerView rcDesafios;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rcDesafios = rcDesafios.findViewById(R.id.rvListaExperiencias);

        binding.homeRvMisRetos.setLayoutManager(new LinearLayoutManager(getContext()));

        userList = new ArrayList<>(userList);
        //adapter = new ListDesafiosAdapter(userList);
        //binding.homeRvMisRetos.setAdapter(adapter);

        // Método de prueba para cargar elementos en la vista
        //userList.add(new Desafio("101 Madrid", R.drawable.btn_desafio_madrid));
        //userList.add(new Desafio("101 Barcelona", R.drawable.btn_desafio_croquetas));

        ListDesafiosAdapter adapter = new ListDesafiosAdapter(getContext(), userList);
        //rcDesafios.setAdapter(adapter);

    }

    private void setContentView(ConstraintLayout root) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}