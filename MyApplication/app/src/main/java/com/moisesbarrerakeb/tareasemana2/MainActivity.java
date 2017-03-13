package com.moisesbarrerakeb.tareasemana2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtFecha;
    private EditText txtTelefono;
    private EditText txtEmail;
    private EditText txtDescripcion;

    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descripción;
    private int Year;
    private int Month;
    private int Day;
    private static final int TIPO_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFechas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);

        obtenerFecha();
        oyenteSelectorFechas = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Day = dayOfMonth;
                Month = month;
                Year = year;
                mostrarFecha();
            }
        };

        try{

            Bundle bundle = getIntent().getExtras();

            txtNombre.setText(bundle.getString("Nombre").toString());
            txtFecha.setText(bundle.getString("Fecha").toString());
            txtTelefono.setText(bundle.getString("Telefono").toString());
            txtEmail.setText(bundle.getString("Email").toString());
            txtDescripcion.setText(bundle.getString("Descripcion").toString());
        }catch (Exception e){

        }


    }
    @Override
    protected Dialog onCreateDialog(int id) {
        try{

            switch (id){
                case 0:
                    return new DatePickerDialog(this, oyenteSelectorFechas, Year, Month, Day);
                default:
                    break;
            }

        }catch (Exception e){}
        return null;
    }

    public void mostrarFecha(){
        String tmpMonth = "", tmpDay = "";
        int tempMonth = 0;
        tempMonth = Month + 1;

        if (tempMonth < 10){
            tmpMonth = "0"+tempMonth;
        }else{
            tmpMonth = String.valueOf(Month);
        }
        if (Day < 10){
            tmpDay = "0"+Day;
        }else{
            tmpDay   = String.valueOf(Day);
        }
        txtFecha.setText(tmpDay+"/"+tmpMonth+"/"+Year);
    }
    public void seleccionarFecha(View control){
        showDialog(TIPO_DIALOGO);
    }

    public void obtenerFecha(){
        Calendar calendario = Calendar.getInstance();
        Day = calendario.get(Calendar.DAY_OF_MONTH);
        Month = calendario.get(Calendar.MONTH);
        Year = calendario.get(Calendar.YEAR);
        mostrarFecha();

    }

    public void siguiente(View v){

        Intent i= new Intent(this, Data.class);
        i.putExtra("Nombre", txtNombre.getText().toString());
        i.putExtra("Fecha", txtFecha.getText().toString());
        i.putExtra("Telefono", txtTelefono.getText().toString());
        i.putExtra("Email", txtEmail.getText().toString());
        i.putExtra("Descripcion", txtDescripcion.getText().toString());
        startActivity(i);
    }
}
