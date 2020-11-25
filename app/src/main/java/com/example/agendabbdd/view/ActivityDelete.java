package com.example.agendabbdd.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agendabbdd.MainActivity;
import com.example.agendabbdd.R;
import com.example.agendabbdd.viewModel.AgendaViewModel;

public class ActivityDelete extends AppCompatActivity {

    EditText etborrar;
    Button btborrar;
    AgendaViewModel agendaViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etborrar = findViewById(R.id.etDelete);
        btborrar = findViewById(R.id.btDelete);
        agendaViewModel = new ViewModelProvider(this).get(AgendaViewModel.class);
        btborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idBorrar = etborrar.getText().toString();

                agendaViewModel.delete(Integer.parseInt(idBorrar));

                lanzarActividad();
            }
        });

    }

    private void lanzarActividad() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}