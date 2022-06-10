package com.example.projeto_final_cdm.Aplicativo.viewmodel;

import android.location.Location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GPSViewModel extends ViewModel {
    MutableLiveData<Location> location;

    public GPSViewModel(){
        super();
        this.location = new MutableLiveData();
    }

    public MutableLiveData<Location> getLocation() {
        return location;
    }

    public void setLocation(Location loc){
        this.location.setValue(loc);
    }
}
