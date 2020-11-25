package com.example.agendabbdd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agendabbdd.R;

public class ActivityPregunta_ID extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta__i_d);

        EditText etId = findViewById(R.id.etIDdeaseado);
        Button bt = findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etId.getText().toString());
                lanzarActividad(id);
            }
        });
    }

    private void lanzarActividad(int id) {
        Intent i = new Intent(this, ActivityUpdate.class);
        i.putExtra("idSeleccionado", id);
        startActivity(i);
    }
}