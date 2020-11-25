package com.example.agendabbdd.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.agendabbdd.model.AgendaRepository;
import com.example.agendabbdd.model.entity.Agenda;

import java.util.List;

public class AgendaViewModel extends AndroidViewModel {

    private AgendaRepository repository;

    private LiveData<List<Agenda>> liveContactos;

    public AgendaViewModel(@NonNull Application application) {
        super(application);
        repository = new AgendaRepository(application);
        liveContactos = repository.getLiveListaContactos();
    }


    public LiveData<List<Agenda>> getAllContactos() {
        return liveContactos;
    }

    public void insert(Agenda contacto) {
        repository.insert(contacto);
    }

    public void delete(int id) { repository.delete(id); }

    public void update(int id, String nombre, String apellidos, int telefono, String fechaNac, String localidad, String calle, int numero) {
        repository.update(id, nombre, apellidos, telefono, fechaNac, localidad, calle, numero);}

}
