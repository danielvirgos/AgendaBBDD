package com.example.agendabbdd.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agendabbdd.MainActivity;
import com.example.agendabbdd.R;
import com.example.agendabbdd.model.entity.Agenda;
import com.example.agendabbdd.viewModel.AgendaViewModel;

public class ActivityAdd extends AppCompatActivity {

    EditText etnombre, etapellido, ettelefono, etfecha, etlocalidad, etcalle, etnumero;
    AgendaViewModel agendaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etapellido = findViewById(R.id.etApellidoUp);
        etnombre = findViewById(R.id.etNombreUp);
        etnumero = findViewById(R.id.etNumeroUp);
        etfecha = findViewById(R.id.etFechaNacUp);
        etlocalidad = findViewById(R.id.etLocalidadUp);
        ettelefono = findViewById(R.id.etTelefonoUp);
        etcalle = findViewById(R.id.etCalleUp);
        agendaViewModel = new ViewModelProvider((ViewModelStoreOwner) this).get(AgendaViewModel.class);

        Button btinsertar = findViewById(R.id.btUpdate);

        btinsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etnombre.getText().toString();
                String apellido = etapellido.getText().toString();
                int telefono = Integer.parseInt(ettelefono.getText().toString());
                String fecha = etfecha.getText().toString();
                String localidad = etlocalidad.getText().toString();
                String calle = etcalle.getText().toString();
                int numero = Integer.parseInt(etnumero.getText().toString());

                Agenda agenda = new Agenda(nombre, apellido, telefono, fecha, localidad, calle, numero);

                agendaViewModel.insert(agenda);

                lanzarActividad();

            }
        });
    }

    private void lanzarActividad() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}