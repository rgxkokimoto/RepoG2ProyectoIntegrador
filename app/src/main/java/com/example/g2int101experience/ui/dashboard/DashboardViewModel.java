package com.example.g2int101experience.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {


    /*
        Zona de configuración de textViews Dinamicos
     */

    private final MutableLiveData<String> textDashboard;
    private final MutableLiveData<String> textDashBoardSub1;
    private final MutableLiveData<String> textDashBoardSub2;
    private int contador = 1;

    public DashboardViewModel() {
        textDashBoardSub2 = new MutableLiveData<>();
        textDashBoardSub1 = new MutableLiveData<>();
        textDashboard = new MutableLiveData<>();

        textDashboard.setValue("This is dashboard fragment");
        textDashBoardSub1.setValue("Fragmento principal del Dashboard1");
        textDashBoardSub2.setValue("Fragmento secundario del Dashboard2");
    }

    public MutableLiveData<String> getTextDashboard() {
        return textDashboard;
    }

    public MutableLiveData<String> getTextDashBoardSub1() {
        return textDashBoardSub1;
    }

    public MutableLiveData<String> getTextDashBoardSub2() {
        return textDashBoardSub2;
    }

    public void cambiarTexto() {
        textDashboard.setValue("Texto cambiado por " + contador + "º vez");
        contador++;
    }



}