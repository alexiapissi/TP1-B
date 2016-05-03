package com.example.clase1.clase1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clase1.clase1.Model.Person;

public class Actividadsec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividadsec);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        Person p = (Person)extras.getSerializable("persona");

        TextView nombreyapVw = (TextView)findViewById(R.id.nombreyapellido);
        TextView sexoVw = (TextView)findViewById(R.id.sexo);

        try{
            nombreyapVw.setText(p.imprimir());
        } catch (Exception e) {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        //String sexoStr = String.valueOf(p.getSexo());
        String sexoStr;
        if (p.getSexo() == 2) {
            sexoStr = "Femenino";
            sexoVw.setText(sexoStr);
            nombreyapVw.setTextColor(Color.parseColor("#5C3379"));
        }
        else {
            sexoStr = "Masculino";
            sexoVw.setText(sexoStr);
            nombreyapVw.setTextColor(Color.parseColor("#38B51B"));
        }



    }
    public void btnInvertir(View view) {
        Bundle extras = getIntent().getExtras();
        Person p = (Person)extras.getSerializable("persona");
        String nombre=p.getNombre();
        String nombreinvertido = "";
        for (int i=nombre.length()-1;i>=0;i--) {
            nombreinvertido=nombreinvertido + nombre.charAt(i);
        }
        TextView parte2=(TextView) findViewById(R.id.parte2);
        parte2.setText(nombreinvertido);
    }

    public  void btnCantidad (View view){
        Bundle extras = getIntent().getExtras();
        Person p = (Person)extras.getSerializable("persona");
        int cant= p.getNombre().length();
        TextView parte2=(TextView) findViewById(R.id.parte2);
        parte2.setText(String.valueOf(cant));


    }

}

