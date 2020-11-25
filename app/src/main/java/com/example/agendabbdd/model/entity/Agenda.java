package com.example.agendabbdd.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "agenda")
public class Agenda {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "apellidos")
    private String apellidos;

    @NonNull
    @ColumnInfo(name = "telefono")
    private int telefono;

    @NonNull
    @ColumnInfo(name = "fechaNac")
    private String fechaNac;

    @NonNull
    @ColumnInfo(name = "localidad")
    private String localidad;

    @NonNull
    @ColumnInfo(name = "calle")
    private String calle;

    @NonNull
    @ColumnInfo(name = "numero")
    private int numero;


    public Agenda() {
        this("", "" , 0, "", "", "", 0);
    }

    public Agenda(@NonNull String nm, @NonNull String ap, @NonNull int tl, @NonNull String fn, @NonNull String lc, @NonNull String cl, @NonNull int nu) {
        this.nombre = nm;
        this.apellidos = ap;
        this.telefono = tl;
        this.fechaNac = fn;
        this.localidad = lc;
        this.calle = cl;
        this.numero = nu;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(@NonNull String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(@NonNull int telefono) {
        this.telefono = telefono;
    }

    public void setFechaNac(@NonNull String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setLocalidad(@NonNull String localidad) {
        this.localidad = localidad;
    }

    public void setCalle(@NonNull String calle) {
        this.calle = calle;
    }

    public void setNumero(@NonNull int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return id + ";" + nombre + ";" + apellidos + ";" + telefono + ";" + fechaNac + ";" + localidad + ";" + calle + ";" + numero + "\n";
    }
}
