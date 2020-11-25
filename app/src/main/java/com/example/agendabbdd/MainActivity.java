package com.example.agendabbdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agendabbdd.model.entity.Agenda;
import com.example.agendabbdd.view.ActivityAdd;
import com.example.agendabbdd.view.ActivityDelete;
import com.example.agendabbdd.view.ActivityPregunta_ID;
import com.example.agendabbdd.view.ActivityUpdate;
import com.example.agendabbdd.view.RecyclerViewAdapter.AgendaRecyclerViewAdapter;
import com.example.agendabbdd.viewModel.AgendaViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btborrar;
    Button btadd;
    List<Agenda> contactos;
    AgendaViewModel agendaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btadd = findViewById(R.id.btadd);


        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActividad();
            }
        });

        Button btupdate = findViewById(R.id.btupdate);
        btupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActividad2();
            }
        });
    }

    private void lanzarActividad2() {
        Intent i = new Intent(this, ActivityPregunta_ID.class);
        startActivity(i);
    }

    private void lanzarActividad() {
        Intent i = new Intent(this, ActivityAdd.class);
        startActivity(i);
    }

    private void init() {

        agendaViewModel = new ViewModelProvider(this).get(AgendaViewModel.class);

        agendaViewModel.getAllContactos().observe(this, new Observer<List<Agenda>>() {
            @Override
            public void onChanged(List<Agenda> agenda) {
                contactos = new ArrayList<>();
                    for (int i = 0; i < agenda.size(); i++) {
                        contactos.add(agenda.get(i));
                }
                    Log.v("zzzz", contactos.toString());
                MostrarAgenda();
            }
        });

        btborrar = findViewById(R.id.btborrar);
        btborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActividad1();
                Log.v("zzzz", "lanzo actividad1");
            }
        });
    }



    private void lanzarActividad1() {
        Intent i = new Intent(this, ActivityDelete.class);
        startActivity(i);
    }

    private void MostrarAgenda() {

        AgendaRecyclerViewAdapter agendaRecyclerViewAdapter = new AgendaRecyclerViewAdapter(contactos, this);

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);

        recyclerView.setAdapter(agendaRecyclerViewAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}