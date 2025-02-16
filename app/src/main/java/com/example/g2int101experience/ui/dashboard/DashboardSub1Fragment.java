package com.example.g2int101experience.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.g2int101experience.R;
import com.example.g2int101experience.databinding.FragmentDashboardSub1Binding;


public class DashboardSub1Fragment extends Fragment {

    private FragmentDashboardSub1Binding binding;

    private DashboardViewModel dashboardViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDashboardSub1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dashboardViewModel = new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);
        dashboardViewModel.getTextDashBoardSub1().observe(getViewLifecycleOwner(), binding.tvDashboardSub1::setText);
        binding.btnGotoDashboardSub2.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.dashboardSub2Fragment));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}