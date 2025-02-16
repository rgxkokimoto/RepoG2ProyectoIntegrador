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
import com.example.g2int101experience.databinding.FragmentDashboardSub2Binding;

public class DashboardSub2Fragment extends Fragment {

    private FragmentDashboardSub2Binding binding;

    private DashboardViewModel dashboardViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDashboardSub2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dashboardViewModel = new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);
        dashboardViewModel.getTextDashBoardSub2().observe(getViewLifecycleOwner(), binding.tvDashboardSub2::setText);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}