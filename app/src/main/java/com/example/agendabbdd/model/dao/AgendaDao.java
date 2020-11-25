package com.example.agendabbdd.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.agendabbdd.model.entity.Agenda;

import java.util.List;

@Dao
public interface AgendaDao {

    @Query("delete from agenda")
    void deleteAll();

    @Query("select * from agenda where id = :id")
    Agenda get(int id);

    @Query("select * from agenda order by apellidos")
    List<Agenda> getAll();

    @Query("select * from agenda where nombre = :nombre")
    Agenda getNm(String nombre);

    @Query("select * from agenda where apellidos = :apellidos")
    Agenda getAp(String apellidos);

    @Query("select * from agenda where telefono = :telefono")
    Agenda getTl(int telefono);

    @Query("select * from agenda where localidad = :localidad")
    Agenda getLc(String localidad);

    @Query("select * from agenda where calle = :calle")
    Agenda getCl(String calle);

    @Query("select * from agenda where fechaNac = :fechaNac")
    Agenda getFn(String fechaNac);

    @Query("select * from agenda where numero = :numero")
    Agenda getNu(int numero);

    @Insert
    void insert(Agenda agenda);

    @Query("select * from agenda order by apellidos")
    LiveData<List<Agenda>> getAllLive();

    @Update
    void update(Agenda agenda);

    @Delete
    void delete(Agenda agenda);

    @Query("delete from agenda where id = :id")
    void deleteMio(int id);

    @Query("update agenda set nombre= :nombre, apellidos= :apellidos, telefono = :telefono, fechaNac= :fechaNac, localidad= :localidad, calle= :calle, numero= :numero where id= :id")
    void updateMio(int id, String nombre, String apellidos, int telefono, String fechaNac, String localidad, String calle, int numero);

}
