package com.moisesbarrerakeb.tareasemana2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Data extends AppCompatActivity {

    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descripción;

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Bundle bundle = getIntent().getExtras();

        nombre = bundle.getString("Nombre").toString();
        fecha = bundle.getString("Fecha").toString();
        telefono = bundle.getString("Telefono").toString();
        email = bundle.getString("Email").toString();
        descripción = bundle.getString("Descripcion").toString();

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText("Nombre: "+nombre);
        tvFecha.setText("Fecha: "+fecha);
        tvTelefono.setText("Telefono: "+telefono);
        tvEmail.setText("Email: "+email);
        tvDescripcion.setText(descripción);

    }

    public void editar(View v){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("Nombre", nombre);
        i.putExtra("Fecha", fecha);
        i.putExtra("Telefono", telefono);
        i.putExtra("Email", email);
        i.putExtra("Descripcion", descripción);
        startActivity(i);
    }
}
