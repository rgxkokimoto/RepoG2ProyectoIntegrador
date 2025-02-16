package com.example.g2int101experience.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavAction;
import androidx.navigation.Navigation;

import com.example.g2int101experience.R;
import com.example.g2int101experience.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private DashboardViewModel dashboardViewModel;

    // Inflado de la vista del fragmento
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    // Configuración dinamica de los textos y elementos guadaddos en la clase dashboardViewModel
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dashboardViewModel = new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);
        dashboardViewModel.getTextDashboard().observe(getViewLifecycleOwner(), binding.tvTituloDashBoardMain::setText);

        // 1º Forma de navegar a otro fragmento por codigo
//        binding.btnGoToASub1.setOnClickListener(v -> {
//            Navigation.findNavController(view).navigate(R.id.dashboardSub1Fragment);
//        });

        // 2º Método de navegacion por xml y ui Soporta Animaciones
        binding.btnGoToASub1.setOnClickListener( v-> Navigation.findNavController(view).navigate(R.id.action_navigation_dashboard_to_dashboardSub1Fragment));

        binding.btnCambiarTexto.setOnClickListener(v -> dashboardViewModel.cambiarTexto());

    }

    // Liberar memoria para evitar Memory leeks
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}