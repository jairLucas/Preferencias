package com.jk.agendacontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_nombre,et_datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nombre = (EditText)findViewById(R.id.editText_nombre);
        et_datos = (EditText)findViewById(R.id.editText_datos);

    }
    public void guardar(View view){
        String nombre = et_nombre.getText().toString();
        String datos = et_datos.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre,datos);
        obj_editor.commit();
        et_nombre.setText("");
        et_datos.setText("");
        Toast.makeText(this, "Preferencia Guardada", Toast.LENGTH_LONG).show();
    }

    public void buscar(View view){
        String nombre = et_nombre.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String datos = preferencias.getString(nombre,"");
        if(datos.length()==0){
            Toast.makeText(this, "Preferencia no encontrada", Toast.LENGTH_LONG).show();
        }else{
            et_datos.setText(datos);
            Toast.makeText(this, "Preferencia encontrada", Toast.LENGTH_LONG).show();
        }
    }
}