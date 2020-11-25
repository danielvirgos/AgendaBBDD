package com.example.agendabbdd.model.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.agendabbdd.model.dao.AgendaDao;
import com.example.agendabbdd.model.entity.Agenda;

;import static com.example.agendabbdd.AgendaAplication.threadExecutor;

@Database(entities = {Agenda.class}, version = 1, exportSchema = false)
public abstract class AgendaDataBase extends RoomDatabase{

    public abstract AgendaDao getAgendaDao();

    private volatile static AgendaDataBase INSTANCE;

    public static AgendaDataBase getDb(final Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AgendaDataBase.class, "dbagenda").build();
        }
        return INSTANCE;
    }
}
