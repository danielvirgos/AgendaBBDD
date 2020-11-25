package com.example.agendabbdd.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.agendabbdd.AgendaAplication;
import com.example.agendabbdd.model.dao.AgendaDao;
import com.example.agendabbdd.model.entity.Agenda;
import com.example.agendabbdd.model.room.AgendaDataBase;

import java.util.List;

public class AgendaRepository {

    //acceso a la base de datos
    private AgendaDataBase db;

    //acceso a los DAOs, o sea a cada una de las tablas
    private AgendaDao agendaDao;

    private LiveData<List<Agenda>> liveListaContactos;

    public AgendaRepository(Application context) {
        db = AgendaDataBase.getDb(context);
        agendaDao = db.getAgendaDao();

        //LiveData: carga de datos en segundo plano
        liveListaContactos = agendaDao.getAllLive();
    }

    public LiveData<List<Agenda>> getLiveListaContactos() {
        return liveListaContactos;
    }

    public void insert(Agenda agenda) {
        //lambda expresión: forma abreviada (Interface, método)
        //de implementar una interfaz con un sólo método
        /*PalabroApplication.databaseWriteExecutor.execute(() -> {
            palabroDao.insert(palabro);
        });*/
        //sin lambda expresión
        AgendaAplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.insert(agenda);
            }
        });

    }

    public void delete (int id) {
        AgendaAplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.deleteMio(id);
            }
        });
    }

    public void update (int id, String nombre, String apellidos, int telefono, String fechaNac, String localidad, String calle, int numero) {
        AgendaAplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.updateMio(id, nombre, apellidos, telefono, fechaNac, localidad, calle, numero);
            }
        });
    }
}
